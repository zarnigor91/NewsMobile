package com.example.newtest.data.repository

import com.example.newtest.data.model1.ArticleEntity
import com.example.newtest.data.model1.ArticleItem
import io.reactivex.Single


interface NewsRepository {
    fun getNews() : Single<List<ArticleItem>>
    fun getNewsDB(): List<ArticleEntity>
}