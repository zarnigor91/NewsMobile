package com.example.newtest.app.feature.news.detalies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newtest.R
import kotlinx.android.synthetic.main.details_layout.*
import moxy.MvpAppCompatFragment

class DetailNewsFragment: MvpAppCompatFragment()  {

     private val args : DetailNewsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            tv_title_item.text = args.ttitle
            tv_source_item.text =  args.description
        }

        Glide.with(this)
            .load(args.url)
            .centerCrop()
            .error(R.drawable.newss)
            .into(iv_news_main_Image)
        tv_source_item.text =  args.source
        tv_published_item.text = args.published
        tv_title_item.text = args.ttitle
        tv_description_item.text= args.description

    }

}