package com.example.csci412assignment2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csci412assignment2.ui.theme.CSCI412Assignment2Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import android.content.Intent
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSCI412Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Ethan Phillips",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Surface(
        color = Color.Cyan,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$name!",
            )
            Text(
                text = "Student Id: 1478321"
            )

            Button(onClick = { onClickExplicit(context) }) {
                Text("Start Activity Explicitly")
            }

            Button(onClick = { onClickImplicit(context) }) {
                Text("Start Activity Implicitly")
            }
        }
    }
}

fun onClickExplicit(context: Context) {
    // Go to the second activity explicitly
    context.startActivity(Intent(context, SecondActivity::class.java))
}

fun onClickImplicit(context: Context) {
    // go to the second activity implicitly
    context.startActivity(Intent("com.example.csci412assignment2.ACTION_VIEW_SECOND"))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CSCI412Assignment2Theme {
        Greeting("Ethan Phillips")
    }
}