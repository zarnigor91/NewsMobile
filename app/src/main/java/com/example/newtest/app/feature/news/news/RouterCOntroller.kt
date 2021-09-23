package com.example.newtest.app.feature.news.news

import androidx.navigation.NavController

class RouterCOntroller {
    private var navController: NavController? = null

    fun setNavController(navController: NavController?) {
        this.navController =navController
    }
    fun navigateOpenDateils(title:String, url:String, source: String, description: String, published: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToDetalyNewsFragment(title, url, source, description,published)
        navController?.navigate(action)
    }

}