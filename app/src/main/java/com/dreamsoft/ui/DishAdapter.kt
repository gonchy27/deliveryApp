package com.dreamsoft.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dreamsoft.base.BaseViewHolder
import com.dreamsoft.data.model.Dish
import com.dreamsoft.deliveryapp.R
import kotlinx.android.synthetic.main.dish_row.view.*
import kotlinx.android.synthetic.main.fragment_slideshow.*

class DishAdapter(private val context: Context, private val dishList: List<Dish>,
                    private val itemClickListener: OnDishClickListener) : RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnDishClickListener{
        fun onDishClick(dish:Dish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return DishViewHolder(LayoutInflater.from(context).inflate(R.layout.dish_row, parent,false))
    }

    override fun getItemCount(): Int {
       return dishList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is DishViewHolder-> holder.bind(dishList[position], position)
        }
    }

    inner class DishViewHolder(itemView: View):BaseViewHolder<Dish>(itemView){
        override fun bind(item: Dish, position: Int) {
            Glide.with(context).load(item.image).centerCrop().into(itemView.img_dish)
            itemView.txt_title.text = item.name
            itemView.txt_desc.text=item.description
            itemView.setOnClickListener{itemClickListener.onDishClick(item)}
        }

    }
}

/*
* ir creando el activity details, ir investigando como conectar mysql con 000webhost c-31-01-21
* e ir creando de a poco el about o lo necesario
* */