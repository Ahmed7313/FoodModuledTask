 package com.example.extendtaskfoodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.extendtaskfoodapp.UIScreens.CategoryScreen
import com.example.extendtaskfoodapp.UIScreens.DishesScreen
import com.example.extendtaskfoodapp.navigation.SetupNavGraph
import com.example.myapplication.ui.theme.LoginAppComposeSmaatTheme
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
class MainActivity : ComponentActivity() {

     lateinit var navController: NavHostController

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppComposeSmaatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginAppComposeSmaatTheme {
        Greeting("Android")
    }
}
