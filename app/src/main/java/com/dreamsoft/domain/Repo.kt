package com.dreamsoft.domain

import com.dreamsoft.data.model.Dish
import com.dreamsoft.vo.Resource

interface Repo {
    fun getDishList(): Resource<List<Dish>>
}