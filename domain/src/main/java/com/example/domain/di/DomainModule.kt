package com.example.domain.di

import com.example.data.repository.CategoryRepository
import com.example.data.repository.DishRepository
import com.example.domain.repository.ICategoryRepository
import com.example.domain.repository.IDishRepository
import com.example.domain.useCase.GetCategoriesUseCase
import com.example.domain.useCase.GetDishUseCase
import com.example.domain.useCase.IDishesUseCase
import com.example.domain.useCase.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideDishUseCase(uc: GetDishUseCase): IDishesUseCase
    }

}
