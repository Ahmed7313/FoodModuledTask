package com.example.extendtaskfoodapp.UIScreens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.extendtaskfoodapp.datasource.viewmodel.CategoryViewModel
import com.example.extendtaskfoodapp.model.Category

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
){
    val listOfCategories by remember { viewModel.listOfCategories }
    
    LazyColumn{
        items(listOfCategories){ item ->
            SingleCategoryItem(category = item)
        }
    }
}

@Composable
fun SingleCategoryItem (
    category: Category
){
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth(), elevation = 8.dp,) {
        Row (modifier = Modifier.padding(16.dp)){
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
                contentDescription = null)
            Text(text = category.strCategory, fontSize = 24.sp)
        }
    }

}