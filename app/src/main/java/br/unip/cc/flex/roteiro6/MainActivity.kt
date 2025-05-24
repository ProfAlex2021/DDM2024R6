package br.unip.cc.flex.roteiro6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.unip.cc.flex.roteiro6.ui.theme.Roteiro6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Roteiro6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun GreetingPreview() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { newValue ->
                // Aceita apenas dígitos para garantir que a soma seja numérica
                numero1 = newValue.filter { it.isDigit() }
            },
            label = { Text("numero 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = numero2,
            onValueChange = { newValue ->
                // Aceita apenas dígitos para garantir que a soma seja numérica
                numero2 = newValue.filter { it.isDigit() }
            },
            label = { Text("numero 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                val val1 = numero1.toIntOrNull() ?: 0
                val val2 = numero2.toIntOrNull() ?: 0
                resultado = (val1 + val2).toString()
            },
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 16.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Adicionar")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Somar")
        }

        Text(text = "Resultado: $resultado", style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Roteiro6Theme {
        GreetingPreview()
    }
}