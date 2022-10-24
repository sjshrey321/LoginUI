package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppUI(applicationContext)
        }
    }
}

@Composable
fun LoginAppUI(context: Context) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // we'll have two text boxes in column and a button
    Column() {
        Text(
            text = "Login Here ",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Left,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        // now we need to create a text field for taking text
        // for that we might need to set a variable
        //there are two types of text field : 1. normal text field 2. outline text field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Your Mail") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Your password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Lock")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),


            )
        OutlinedButton(
            onClick = { logged(email, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )
        }
    }
}

fun logged(email: String, password: String, context: Context) {
    if (email == "shreyjalota@gmail.com" && password == "shrey") {
        Toast.makeText(
            context, "Logged In Successfully",
            Toast.LENGTH_SHORT
        ).show()
    }
    else {
        Toast.makeText(
            context, "Logged In Failed",
            Toast.LENGTH_SHORT
        ).show()
    }

}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview()
//{
//    LoginAppUI(context =  )
//}