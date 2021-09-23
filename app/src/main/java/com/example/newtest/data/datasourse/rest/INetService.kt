package com.example.newtest.data.datasourse.rest

import com.example.newtest.data.model1.NewsModelTotal
import io.reactivex.Single
import retrofit2.http.GET

interface INetService {
//    @GET("topstories/v2/home.json?api-key=4rfwOLzLTWd1a5xixcPjwddAhw3p0eiF")
    @GET("v2/everything?q=tesla&from=2021-08-22&sortBy=publishedAt&apiKey=b4395cf497934e9a8cefa7437062ee0b")
    fun fetchNews(): Single<NewsModelTotal>
//    fun fetchNews(): Single<List<NewsItem>>
}