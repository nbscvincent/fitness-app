package com.nbscollege.fitnessapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.AbsInter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.ChestInter
import com.nbscollege.fitnessapp.ui.theme.FitnessAppTheme
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.AbsBeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.ChestBeg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val begabs = AbsBeg()
//                    begabs.absbeg()
            //        val interabs = AbsInter()
            //        interabs.absinter()
                    val begchest = ChestBeg()
                    begchest.chestbeg()
            //        val interchest = ChestInter()
            //        interchest.chestinter()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Text(
        text = ""
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
        Greeting("Android")
    }
}