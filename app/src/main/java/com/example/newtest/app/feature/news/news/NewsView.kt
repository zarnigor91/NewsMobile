package com.example.newtest.app.feature.news.news

import com.example.newtest.data.model1.Article
import com.example.newtest.data.model1.ArticleEntity
import com.example.newtest.data.model1.ArticleItem
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface NewsView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onNewsSuccess(news : List<ArticleItem>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onNewsSuccessData(news : List<ArticleEntity>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onNewsError(news : List<ArticleEntity>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun action(newsItem: Article)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun actionTitle(title: String, url: String, description: String, published: String)
}