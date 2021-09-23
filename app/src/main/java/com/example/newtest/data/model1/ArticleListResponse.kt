package com.example.newtest.data.model1

import com.google.gson.annotations.SerializedName


data class ArticleListResponse(
    @SerializedName("results")
    val results: List<ArticleItem>
)