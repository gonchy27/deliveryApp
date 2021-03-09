package com.dreamsoft.ui.viewmodel

import androidx.lifecycle.*
import com.dreamsoft.domain.Repo
import com.dreamsoft.vo.Resource
import kotlinx.coroutines.Dispatchers

class DishViewModel(private val repo: Repo): ViewModel() {

    private val dishData = MutableLiveData<String>()

    fun setDish(dishName: String) {
        dishData.value = dishName
    }

    /*init {
        setDish("pique")
    }*/

    val fetchDishList = liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getDishList())//pone un string en el metodo por defecto
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

/*
* importar lo que falta y ver el minuto 33:22 c-21-01-21
* */

//val fetchDishList = dishData.distinctUntilChanged().switchMap { nameDish ->
/*liveData(Dispatchers.IO){
    emit(Resource.Loading())
    try {
        emit(repo.getDishList(nameDish))
    }catch (e:Exception) {
        emit(Resource.Failure(e))
    }
}*/