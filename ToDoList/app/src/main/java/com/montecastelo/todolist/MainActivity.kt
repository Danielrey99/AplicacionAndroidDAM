package com.montecastelo.todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.montecastelo.todolist.navigation.Navigation
import com.montecastelo.todolist.ui.theme.ToDoListTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                Scaffold(
                    topBar = {
                             WorkoutsTopAppBar()
                    },
                    bottomBar = {
                                WorkoutsBottomAppBar()
                    },
                    floatingActionButton = {

                    },
                ) { paddingValues ->
                    MainWindow(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }

    @Composable
    private fun MainWindow(
        modifier: Modifier = Modifier
    ){
        val workouts = listOf(
            Workout("Kettlebell", R.drawable.pato),
            Workout("Dumbbell", R.drawable.pato),
            Workout("Cardio", R.drawable.pato),
            Workout("Kettlebell", R.drawable.pato),
            Workout("Dumbbell", R.drawable.pato),
            Workout("Cardio", R.drawable.pato),
        )
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(3)
        ){
            items(workouts){workout ->
                WorkoutCard(modifier = modifier, name = workout.name, image = workout.image)
            }
        }
    }

}

data class Workout(val name:String, @DrawableRes val image: Int)

@Composable
fun WorkoutCard(modifier: Modifier = Modifier, name: String, @DrawableRes image: Int){
    Box{
        Image(
            modifier = modifier,
            painter = painterResource(id = image),
            contentDescription = "Wokout image"
        )
        Text(text = name, color = Color.Blue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutsTopAppBar(
    modifier: Modifier = Modifier,
){
    TopAppBar(
        modifier = Modifier,
        title = { Text(text = "Home") },
    )
}

@Composable
fun WorkoutsBottomAppBar(
    modifier: Modifier = Modifier
){
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Home, contentDescription = "Icon Home",)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.DateRange, contentDescription = "Icon Calendar",)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Settings, contentDescription = "Icon Settings",)
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Add, contentDescription = "Icon image",)
            }
        }
    )
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWindow(
    onDuckClick: () -> Unit
) {
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
                        .clickable {
                            onDuckClick()
                        }
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
*/

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoListTheme {
        MainWindow()
    }
}
*/