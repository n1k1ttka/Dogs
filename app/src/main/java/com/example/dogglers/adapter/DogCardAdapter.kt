/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(private val context: Context?, private val layout: Int)
    : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Инициализируйте данные, используя список, найденный в data/DataSource
    private val dataset: List<Dog> = dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Объявляйте и инициализируйте все компоненты UI элемента списка
        val imageView: ImageView = view!!.findViewById(R.id.dog_face)
        val dogName: TextView = view!!.findViewById(R.id.dog_name)
        val dogAge: TextView = view!!.findViewById(R.id.dog_age)
        val dogHobbies: TextView = view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Используйте условное выражение для определения типа макета и установите его соответствующим образом.
        //  если переменной layout является Layout.GRID следует использовать элемент списка сетки. В противном случае
        //  следует использовать элемент списков по вертикали/горизонтали.
        if (layout == 3) {
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        }
        else{
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        }
    }

    override fun getItemCount() = dataset.size // TODO: возвращает размер набора данных

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Получить текущую позицию
        val pos = dataset[position]
        // TODO: Установите изображение для текущей собаки
        holder.imageView.setImageResource(pos.imageResourceId)
        // TODO: Set the text for the current dog's name
        // holder.dogName.text = context?.resources?.getString(pos.name)
        holder.dogName.text = context?.resources?.getString(R.string.dog_name, pos.name)
        // TODO: Set the text for the current dog's age
        holder.dogAge.text = context?.resources?.getString(R.string.dog_age, pos.age)
        val resources = context?.resources
        // TODO: Задайте текст для увлечений текущей собаки, передав увлечения в
        //  R.string.dog_hobbies string constant.
        //  Передача аргумента строковому ресурсу выглядит следующим образом:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobbies.text = resources?.getString(R.string.dog_hobbies, pos.hobbies)
    }
}
