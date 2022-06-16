package com.example.extendtaskfoodapp.datasource.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Dish
import com.example.domain.useCase.IDishesUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(val useCase: IDishesUseCase) : ViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(val data : List<Dish>) : ViewState()
        data class Error(val errorMessage : String) : ViewState()
    }

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState: State<ViewState> = _viewState



    fun getAllDish(selectedCategory: String){
        viewModelScope.launch {
            try {
                val dishList = useCase(selectedCategory)
                _viewState.value = ViewState.Success(dishList.meals)
            }catch (e : Exception){
                _viewState.value = ViewState.Error(e.message ?: "Unknown Error")
            }
        }
    }

}