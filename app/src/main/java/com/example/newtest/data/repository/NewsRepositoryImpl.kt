package com.example.newtest.data.repository

import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.datasourse.rest.INetService
import com.example.newtest.data.model1.ArticleEntity
import com.example.newtest.data.model1.ArticleItem
import com.example.newtest.data.model1.toEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepositoryImpl(
    private val netService: INetService,
    private val newsDao: NewsDao
) : NewsRepository {
        override fun getNews(): Single<List<ArticleItem>> {
        return netService.fetchNews()
            .map {
                it.articles!!.map { it }
            }
            .doOnSuccess {
                newsDao.insertNews(it.map{ it.toEntity() })
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getNewsDB(): List<ArticleEntity>{
        return newsDao.getAllNews()
    }


}