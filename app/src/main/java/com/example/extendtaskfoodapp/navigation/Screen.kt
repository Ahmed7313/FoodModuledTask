package com.example.extendtaskfoodapp.navigation

sealed class Screen(val route : String){
    object RegisterView : Screen(route = "register_screen")
    object LoginView : Screen(route = "login_screen")
    object DishesScreen : Screen(route = "dish_screen")
    object CategoryScreen : Screen(route = "category_screen")
}