package com.example.examendadubay

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Login(onNextButtonClicked: () -> Unit){
    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.istockphoto_167120918_612x612),
                contentDescription = "Imagen Login",
                modifier = Modifier
                    .padding(25.dp)
                    .weight(1f)
            )
        }
        Row(modifier = Modifier.padding(10.dp)) {
            var email = remember { mutableStateOf("")}
            Text(
                text = "Ususario",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            )
            OutlinedTextField(
                value = email.value,
                singleLine = true,
                onValueChange = {email.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .padding(10.dp)
                    .weight(2f)
            )
        }
        Row(modifier = Modifier.padding(10.dp)) {
            var password = remember { mutableStateOf("") }
            var passwordVisible by rememberSaveable { mutableStateOf(false) }

            Text(
                text = "Contraseña",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)

            )
            OutlinedTextField(
                value = password.value,
                singleLine = true,
                onValueChange = {password.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(10.dp)
                    .weight(2f)
            )
        }
        Row(modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)) {
            Button(
                onClick = onNextButtonClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Enable")
            }
        }
    }
}