package br.edu.ifsp.scl.sc304775x.trucoscoreboard

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc304775x.trucoscoreboard.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MarcadorTruco(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrucoScoreBoardComposeTheme {
        MarcadorTruco(modifier = Modifier)
    }
}

@Composable
fun MarcadorTruco(modifier: Modifier = Modifier) {
    var pontosA by remember { mutableIntStateOf(0) }
    var pontosB by remember { mutableIntStateOf(0) }
    var vencedor by remember { mutableStateOf("") }
    var maoDeOnzeA by remember { mutableStateOf(false) }
    var maoDeOnzeB by remember { mutableStateOf(false) }

    val valoresTruco = listOf(1, 3, 6, 9, 12)
    var indiceTruco by remember { mutableIntStateOf(0) }
    val valorRodada = valoresTruco[indiceTruco]

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    pontosA = 0
                    pontosB = 0
                    vencedor = ""
                    maoDeOnzeA = false
                    maoDeOnzeB = false
                    indiceTruco = 0
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Reiniciar", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Equipe A", fontSize = 28.sp)
            Text(text = "Equipe B", fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = if (pontosA >= 12) "12" else "$pontosA", fontSize = 56.sp)
            Text(text = if (pontosB >= 12) "12" else "$pontosB", fontSize = 56.sp)
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (vencedor.isEmpty()) {
                        pontosA += valorRodada
                        indiceTruco = 0
                        if (pontosA >= 12) {
                            maoDeOnzeA = false
                            maoDeOnzeB = false
                            vencedor = "Equipe A venceu!"
                        }
                        if (pontosA == 11) maoDeOnzeA = true
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "+$valorRodada", fontSize = 26.sp)
            }

            Button(
                onClick = {
                    if (vencedor.isEmpty()) {
                        pontosB += valorRodada
                        indiceTruco = 0
                        if (pontosB >= 12) {
                            maoDeOnzeB = false
                            maoDeOnzeA = false
                            vencedor = "Equipe B venceu!"
                        }
                        if (pontosB == 11) maoDeOnzeB = true
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "+$valorRodada", fontSize = 26.sp)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (vencedor.isEmpty()) {
                        indiceTruco = if (indiceTruco == valoresTruco.lastIndex) 0 else indiceTruco + 1
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Truco",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = vencedor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                if (maoDeOnzeA) {
                    Text(
                        text = "Equipe A está na mão de Onze!",
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                if (maoDeOnzeB) {
                    Text(
                        text = "Equipe B está na mão de Onze!",
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
