package com.example.extendtaskfoodapp.DI

import android.system.Os.bind
import com.example.extendtaskfoodapp.datasource.CategoryRepository
import com.example.extendtaskfoodapp.datasource.ICategoryRepository
import com.example.extendtaskfoodapp.datasource.repository.DishRepository
import com.example.extendtaskfoodapp.datasource.repository.IDishRepository
import com.example.extendtaskfoodapp.datasource.usecase.GetCategoriesUseCase
import com.example.extendtaskfoodapp.datasource.usecase.GetDishUseCase
import com.example.extendtaskfoodapp.datasource.usecase.IDishesUseCase
import com.example.extendtaskfoodapp.datasource.usecase.IGetCategoriesUseCase
import com.example.extendtaskfoodapp.datasource.viewmodel.CategoryViewModel
import com.example.extendtaskfoodapp.datasource.viewmodel.DishViewModel
import com.example.extendtaskfoodapp.serviece.ICategoryService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val module = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ICategoryService::class.java)
    }

    single <ICategoryRepository>{
        CategoryRepository(get())
    }

    single <IGetCategoriesUseCase> {
        GetCategoriesUseCase(get())
    }
//    singleOf(::CategoryRepository) { bind<ICategoryRepository>() }
//
//    singleOf(::GetCategoriesUseCase) { bind<IGetCategoriesUseCase>() }

    //viewModelOf(::CategoryViewModel)

    viewModel {
        CategoryViewModel(get())
    }



//    single <IDishRepository>{
//        DishRepository(get())
//    }
//
//    single <IDishesUseCase> {
//        GetDishUseCase(get())
//    }
//
//    viewModel {
//        DishViewModel(get())
//    }

    singleOf(::DishRepository) { bind<IDishRepository>() }

    singleOf(::GetDishUseCase) { bind<IDishesUseCase>() }

    viewModelOf(::DishViewModel)
}