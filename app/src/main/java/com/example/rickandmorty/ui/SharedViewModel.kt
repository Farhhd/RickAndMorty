package com.example.rickandmorty.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.network.Repository
import com.example.rickandmorty.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository) : ViewModel() {
    fun getCharacters(): LiveData<Resource<List<Character>>> {
        val resultLiveData = MutableLiveData<Resource<List<Character>>>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characters = repository.getCharacters()
            } catch (e: Exception) {
                resultLiveData.postValue(Resource.Error("Error occurred"))
            }
        }
        return resultLiveData
    }
}
