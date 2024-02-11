package com.montecastelo.todolist.features.addlistas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddListasScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add Listas Screen",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Contenido")
    }
}

@Preview(showBackground = true)
@Composable
fun AddListasScreenPreview() {
    AddListasScreen()
}