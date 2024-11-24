package com.vk.education.homework2.network

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val hits: List<ApiImage>
)

data class ApiImage(
    val id: Int,
    @SerializedName("webformatURL")
    val url: String,
    val tags: String
)
