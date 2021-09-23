package com.example.newtest.app.feature.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newtest.R
import com.example.newtest.data.model1.Article
import kotlinx.android.synthetic.main.item_news_list_read.view.*

class NewsAdapter(context: Context, private val action: (Article) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(), Filterable{
    private var myList = mutableListOf<Article>()
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_news_list_read, parent, false)
        return ViewHolder(view, action)
    }
    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(myList[position])
    }


    fun updateNews(newList: List<Article>) {
        myList.clear()
        myList.addAll(newList)
        this.notifyDataSetChanged()
    }

    fun setProvidedPrice(newPrice: Int) {
//        price = newPrice;
        notifyDataSetChanged()
    }

    class ViewHolder(contienerView: View, private val action: (Article) -> Unit) :
        RecyclerView.ViewHolder(contienerView) {
        private var selectSubject: Article? = null

        fun onBind(newsItem: Article) {
            this.selectSubject = newsItem

            itemView.apply {
                setOnClickListener { action.invoke(selectSubject!!) }

                Glide.with(itemView)
                    .load(newsItem.urlToImage)
                    .centerCrop()
                    .error(R.drawable.newss)
                    .into(iv_news_item_image)
                tv_source_name.text = newsItem.source
                    tv_title.text = newsItem.title
                published_at_text_view.text = newsItem.publishedAt
            }

        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    myList = myList as ArrayList<Article>
                } else {
                    val resultList = ArrayList<Article>()
                    for (row in myList) {
                        if (row.title!!.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    myList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = myList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                myList = results?.values as ArrayList<Article>
                notifyDataSetChanged()
            }
        }
    }

}