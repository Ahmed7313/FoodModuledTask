package com.example.data.netowrk.mapper

import com.example.data.netowrk.model.CategoryDTO
import com.example.data.netowrk.model.CategoryResponseDTO
import com.example.data.netowrk.model.DishDTO
import com.example.data.netowrk.model.DishResponseDTO
import com.example.domain.model.Category
import com.example.domain.model.CategoryResponse
import com.example.domain.model.Dish
import com.example.domain.model.DishResponse

fun List<CategoryDTO>.toDomain() : List<Category>{
    return map {
        Category(
            strCategory = it.strCategory,
            idCategory = it.idCategory,
            strCategoryDescription = it.strCategoryDescription,
            strCategoryThumb = it.strCategoryThumb
        )
    }
}

fun CategoryResponseDTO.toDomain() : CategoryResponse {
    return CategoryResponse(
        categories = categories.toDomain()
    )
}

fun List<DishDTO>.toMealDomain() : List<Dish>{
    return map {
        Dish(
            idMeal = it.idMeal,
            strMeal = it.strMeal,
            strMealThumb = it.strMealThumb
        )
    }
}

fun DishResponseDTO.toDomain() : DishResponse {
    return DishResponse(
        meals = meals.toMealDomain()
    )
}

