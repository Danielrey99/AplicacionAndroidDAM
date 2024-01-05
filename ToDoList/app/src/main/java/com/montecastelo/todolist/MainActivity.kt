package com.montecastelo.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.montecastelo.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWindow()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWindow(){
    Column {
        Row {
            CenterAlignedTopAppBar(
                title = {
                    Text("Small Top App Bar")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }

        Row (modifier = Modifier.padding(10.dp)) {
            Column {
                Image(
                    painter = painterResource(R.drawable.pato),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        // Set image size to 40 dp
                        .size(50.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                )
            }

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Row {
                    Text(text = "Perfil")
                }
                // Add a vertical space between rows
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Text(text = "Pato")
                }
            }

        }

        Row (modifier = Modifier.align(Alignment.CenterHorizontally)) {
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = listOf("Item 1", "Item 2", "Item 3")) { item ->
                    CustomText(text = item)
                }
            }
        }
    }
}

@Composable
fun CustomText(text: String, modifier: Modifier = Modifier) {
    Text("• " + text, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoListTheme {
        MainWindow()
    }
}