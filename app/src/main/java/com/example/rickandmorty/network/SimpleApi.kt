package com.example.rickandmorty.network

import com.example.rickandmorty.model.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("character")
    suspend fun getCharacters(): Response<BaseResponse<Character>>
}