package com.example.extendtaskfoodapp.datasource.usecase

import com.example.extendtaskfoodapp.datasource.repository.DishRepository
import com.example.extendtaskfoodapp.model.DishResponse
import javax.inject.Inject

interface IDishesUseCase{
    suspend operator fun invoke(selectedCategory: String): DishResponse
}

class GetDishUseCase @Inject constructor(private val repo: DishRepository): IDishesUseCase{
    override suspend fun invoke(selectedCategory: String): DishResponse {
        return repo.getAllMeals(selectedCategory)
    }
}