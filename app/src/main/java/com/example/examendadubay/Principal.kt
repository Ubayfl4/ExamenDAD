package com.example.examendadubay

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Principal(onNextButtonClicked: () -> Unit){
    var estadoSheets by rememberSaveable { mutableStateOf(false) }
    var contenidoSheets by rememberSaveable {
        mutableStateOf("")
    }
    val informacionLista = listOf(
        Data(textoCard = "texto1", imagen = painterResource(id = R.drawable.persona1), textoSheet = "sheet 1"),
        Data(textoCard = "texto2", imagen = painterResource(id = R.drawable.persona2), textoSheet = "sheet 2"),
        Data(textoCard = "texto3", imagen = painterResource(id = R.drawable.persona3), textoSheet = "sheet 3")
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for(informacion in informacionLista){
            ElevatedCard(
                modifier = Modifier
                    .padding(25.dp)
                    .clickable {
                        estadoSheets = true
                        contenidoSheets = informacion.textoSheet
                    }
            ) {
                Image(painter = informacion.imagen , contentDescription ="hola")
                Text(
                    text = informacion.textoCard,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(25.dp)
                )
            }
        }
        Sheets({ estadoSheets = false; contenidoSheets = "" }, estadoSheets, contenidoSheets)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheets(onDismissModalBottomSheet: () -> Unit, estadoSheets: Boolean, contenidoSheets: String) {
    val sheetState = rememberModalBottomSheetState()
    if (estadoSheets){
        ModalBottomSheet(
            onDismissRequest = { onDismissModalBottomSheet() },
            sheetState = sheetState
        ) {
            Row(modifier = Modifier.padding(60.dp), Arrangement.Center) {
                Text(
                    text = contenidoSheets,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}