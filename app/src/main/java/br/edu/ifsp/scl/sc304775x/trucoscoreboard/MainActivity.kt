package br.edu.ifsp.scl.sc304775x.trucoscoreboard

import android.os.Bundle
import android.text.style.AlignmentSpan
import android.util.MutableInt
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Equipe A",
                fontSize = 30.sp
            )
            Text(
                text = "Equipe B",
                fontSize = 30.sp
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceEvenly
        ) {
            Text(
                text = "$pontosA" ,
                fontSize = 48.sp
            )
            Text(
                text = "$pontosB" ,
                fontSize = 48.sp
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { pontosA++ },
                colors = ButtonD
            ) {
                Text(
                    text = "+1",
                    fontSize = 30.sp,
                )
            }

            Button(
                onClick = { pontosB++ }
            ) {
                Text(
                    text = "+1",
                    fontSize = 30.sp
                )
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {  }
            ) {
                Text(
                    text = "Truco",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}
