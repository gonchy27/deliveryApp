package com.dreamsoft.data

import com.dreamsoft.data.model.Dish
import com.dreamsoft.vo.Resource

class DataSource {
    val generateDishList = Resource.Success(listOf(
        Dish(image = "",name = "Pique", description = "plato tradicional"),
        Dish(image = "",name = "Planchita", description = "plato tradicional"),
        Dish(image = "",name = "Sillpancho", description = "plato tradicional")
    ))


}

/*
* agregar los platos desde url
* */