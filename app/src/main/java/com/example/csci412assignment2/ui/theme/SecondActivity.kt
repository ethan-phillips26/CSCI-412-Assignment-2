package com.example.csci412assignment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen()
        }
    }
}

@Composable
fun SecondScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mobile Software Engineering Challenges:", fontSize = 20.sp)

        Column(horizontalAlignment = Alignment.Start) {
            Text("1. Device fragmentation")
            Text("2. Tool Support")
            Text("3. Low Tolerance")
            Text("4. Low Security and Privacy Awareness")
            Text("5. Unstable and Dynamic Environment")
        }
        Button(onClick = onMainActivityClick(context)) {
            Text("Main Activity")
        }
    }
}

fun onMainActivityClick(context: Context) = {
    // Go back to main activity explicitly
    context.startActivity(Intent(context, MainActivity::class.java))
}
