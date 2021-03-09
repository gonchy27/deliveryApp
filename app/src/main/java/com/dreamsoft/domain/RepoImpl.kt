package com.dreamsoft.domain

import com.dreamsoft.data.DataSource
import com.dreamsoft.data.model.Dish
import com.dreamsoft.vo.Resource

class RepoImpl(private val dataSource:DataSource): Repo{
    override fun getDishList(): Resource<List<Dish>> {
        return dataSource.generateDishList
    }
}