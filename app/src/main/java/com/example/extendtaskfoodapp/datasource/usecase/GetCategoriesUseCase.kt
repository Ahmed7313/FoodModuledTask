package com.example.extendtaskfoodapp.datasource.usecase

import com.example.extendtaskfoodapp.datasource.ICategoryRepository
import com.example.extendtaskfoodapp.model.CategoryResponse
import javax.inject.Inject

interface IGetCategoriesUseCase{

    operator suspend fun invoke() : CategoryResponse
}
class GetCategoriesUseCase  @Inject constructor(
    val repo : ICategoryRepository
) : IGetCategoriesUseCase{
    override suspend fun invoke(): CategoryResponse {
        return repo.getAllCategories()
    }


}