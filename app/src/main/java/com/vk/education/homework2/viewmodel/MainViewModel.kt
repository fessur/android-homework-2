package com.vk.education.homework2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.education.homework2.BuildConfig
import com.vk.education.homework2.network.ApiClient
import com.vk.education.homework2.network.ApiImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    companion object {
        private const val API_TOKEN = BuildConfig.API_TOKEN
        private const val IMAGES_PER_LOAD = 10
    }
    private var page = 1

    private val _images = MutableStateFlow<List<ApiImage>>(emptyList())
    val images: StateFlow<List<ApiImage>> = _images

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<Exception?>(null)
    val error: StateFlow<Exception?> = _error


    fun loadImages() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response = ApiClient.service.getImages(API_TOKEN, page, IMAGES_PER_LOAD)
                _images.value += response.hits
                page++
            } catch (e: Exception) {
                _error.value = e
            } finally {
                _loading.value = false
            }
        }
    }

    fun retry() {
        loadImages()
    }
}