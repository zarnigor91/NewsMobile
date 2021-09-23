package com.example.newtest.app.feature.news.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtest.R
import com.example.newtest.app.feature.news.NewsAdapter
import com.example.newtest.data.model1.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_dashboard.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class NewsFragment : MvpAppCompatFragment(), NewsView {

    private var adapter: NewsAdapter? = null

    private var adapterBreaking: NewsBreakingAdapter? = null

    @Inject
    lateinit var provider: NewsPresenter

    @Inject
    lateinit var controllerNews: RouterCOntroller

    private val presenter by moxyPresenter { provider }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controllerNews.setNavController(findNavController())

        adapter = NewsAdapter(requireContext(), action = { action(it) })

        adapterBreaking = NewsBreakingAdapter(requireContext(), action = { action(it) })

        rv_news_list.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        rv_news_list.adapter = adapter
        presenter.getNews()

        breaking_news_recycler_view.layoutManager =  LinearLayoutManager(requireContext(), GridLayoutManager.HORIZONTAL, false)
        breaking_news_recycler_view.adapter = adapterBreaking


    }

    override fun onNewsSuccess(news: List<ArticleItem>) {
        pb_loading.visibility = View.GONE
        adapter?.updateNews(news.map {
            it.toNewsItem()
        })

        adapterBreaking?.updateNews(news.map {
            it.toNewsItem()
        })
    }

    override fun onNewsSuccessData(news: List<ArticleEntity>) {
        adapter?.updateNews(news.map {
            it.toNews()
        })

    }

    override fun onNewsError(news: List<ArticleEntity>) {
        pb_loading.visibility = View.GONE
        adapter?.updateNews(news.map {
            it.toNews()
        })
        Toast
            .makeText(
                requireContext(),
                "Xabarlar offline kursatilmoqda",
                Toast.LENGTH_LONG
            ).show()

            adapterBreaking?.updateNews(news.map {
            it.toNews()
        })
//        pb_loading.visibility = View.GONE
    }

    override fun action(newsItem: Article) {
        presenter.openDeta(newsItem.title!!, newsItem.urlToImage!!, newsItem.source.toString(),newsItem.description.toString(), newsItem.publishedAt!!)
    }

    override fun actionTitle(title: String, url: String, sourceName: String, published: String) {
        TODO("Not yet implemented")
    }

//    override fun action(newsItem: NewsEntity) {
//        presenter.openDeta(newsItem.title!!, newsItem.multimedia!![0].url!!, newsItem.abstract!!)
//    }



}