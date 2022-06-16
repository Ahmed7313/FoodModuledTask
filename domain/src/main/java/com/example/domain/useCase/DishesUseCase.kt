package com.example.domain.useCase

//import com.example.data.repository.DishRepository
import com.example.domain.model.DishResponse
import com.example.domain.repository.IDishRepository
import javax.inject.Inject

interface IDishesUseCase{
    suspend operator fun invoke(selectedCategory: String): DishResponse
}

class GetDishUseCase @Inject constructor(
    private val repo: IDishRepository)
    : IDishesUseCase{
    override suspend fun invoke(selectedCategory: String): DishResponse {
        return repo.getAllMeals(selectedCategory)
    }
}