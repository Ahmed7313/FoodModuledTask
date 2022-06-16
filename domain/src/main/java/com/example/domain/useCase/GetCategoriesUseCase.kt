package com.example.domain.useCase

import com.example.domain.model.CategoryResponse
import com.example.domain.repository.ICategoryRepository
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