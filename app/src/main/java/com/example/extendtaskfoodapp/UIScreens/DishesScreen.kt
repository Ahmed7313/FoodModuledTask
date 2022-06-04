package com.example.extendtaskfoodapp.UIScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.extendtaskfoodapp.datasource.viewmodel.DishViewModel.ViewState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.extendtaskfoodapp.datasource.viewmodel.DishViewModel
import com.example.extendtaskfoodapp.model.Dish

@Composable
fun DishesScreen(
    viewModel: DishViewModel = hiltViewModel(),
    category : String?
) {

    DisposableEffect(key1 = Unit){
        if (!category.isNullOrBlank()){
            viewModel.getAllDish(category)
        }
        onDispose {  }
    }

    val viewState by remember { viewModel.viewState }

    when ( val state = viewState) {
        is ViewState.Success ->{
            LazyColumn {
                items(state.data) { dish ->
                    DisplayDish(dish = dish)
                }
            }
        }
        is ViewState.Error -> {
            Text(text = "Error ${state.errorMessage}")
        }
    }

}

@Composable
fun DisplayDish(dish: Dish) {
    Card(
        shape = RoundedCornerShape(10.dp), elevation = 5.dp, modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = rememberImagePainter(dish.strMealThumb),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))
            androidx.compose.material.Text(text = dish.strMeal, fontSize = 24.sp)
        }
    }

}