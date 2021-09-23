package com.example.newtest.app.feature.news.news


import android.annotation.SuppressLint
import android.util.Log
import com.example.newtest.data.model1.ArticleEntity
import com.example.newtest.data.repository.NewsRepository
import moxy.MvpPresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    private val routerCOntroller: RouterCOntroller
) : MvpPresenter<NewsView>(){
    var list: List<ArticleEntity>? =null
    @SuppressLint("CheckResult")
    fun getNews() {
        newsRepository.getNews()
            .subscribe(
                {
                    viewState.onNewsSuccess(it.map { it })
                    Log.wtf("NewsViewPresenterSuccess", "success items = $it")
                },
                {
                    viewState.onNewsError(
                        newsRepository.getNewsDB().onEach { it
                            Log.wtf("NewsViewPresenterError", "failed = error = $it")
                        }
                    )

//                        if(it is ConnectException ){
//                            newsRepository.getNewsDB().onEach{
//                               viewState.onNewsSuccessData(it)
//                                Log.wtf("NewsViewPresenterHost", "failed = error = $it")
//                            }
//                        }else{
//                        viewState.onNewsError(
//                            newsRepository.getNewsDB().onEach{it}
//                        )
//                        Log.wtf("NewsViewPresenterError", "failed = error = $it")
//                    }
                }
            )
    }

    fun openDeta(title: String, url: String, source: String, description: String, published: String){
        routerCOntroller.navigateOpenDateils(title, url, source, description , published)
    }

}