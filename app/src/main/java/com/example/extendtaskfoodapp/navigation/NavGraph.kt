package com.example.extendtaskfoodapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.extendtaskfoodapp.UIScreens.CategoryScreen
import com.example.extendtaskfoodapp.UIScreens.DishesScreen
import com.example.loginappcomposesmaat.views.loginFullView
import com.example.loginappcomposesmaat.views.registerView


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController , startDestination = "category_screen" ){
        composable(route = Screen.CategoryScreen.route){
            CategoryScreen(){ category ->
                navController.navigate("dish_screen/${category}")
            }
        }
        composable("${Screen.DishesScreen.route}/{category}",
            arguments = listOf(navArgument("category"){
            type = NavType.StringType
        })){
            val category = remember {
                it.arguments?.getString("category")
            }
            DishesScreen(category = category)
        }
    }
}