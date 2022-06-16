package com.example.data.repository

import com.example.data.netowrk.mapper.toDomain
import com.example.data.netowrk.model.DishResponseDTO
import com.example.data.netowrk.servieces.IDishService
import com.example.domain.model.DishResponse
import com.example.domain.repository.IDishRepository
import javax.inject.Inject

class DishRepository @Inject constructor(val service: IDishService): IDishRepository {
    override suspend fun getAllMeals(dishCategory: String): DishResponse {
        return service.getAllMeals(dishCategory).toDomain()
    }
}