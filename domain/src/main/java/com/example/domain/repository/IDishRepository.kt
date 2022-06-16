package com.example.domain.repository

import com.example.domain.model.DishResponse

interface IDishRepository{
    suspend fun getAllMeals(dishCategory: String): DishResponse
}
