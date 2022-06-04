package com.example.extendtaskfoodapp.datasource.repository

import com.example.extendtaskfoodapp.model.DishResponse
import com.example.extendtaskfoodapp.serviece.IDishService
import javax.inject.Inject


interface IDishRepository{
    suspend fun getAllMeals(dishCategory: String): DishResponse
}

class DishRepository @Inject constructor(val service: IDishService): IDishRepository{
    override suspend fun getAllMeals(dishCategory: String): DishResponse {
        return service.getAllMeals(dishCategory)
    }
}