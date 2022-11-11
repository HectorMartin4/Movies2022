package com.example.app.data

class MemDataStore <T> {
    private val dataStore: MutableMap<String, T> = mutableMapOf()

    fun save(id:String, model:T){
        dataStore[id] = model
    }

    fun getAll()=
        dataStore.map{
            it.value
        }

    fun findById(id: String) = dataStore[id]
}