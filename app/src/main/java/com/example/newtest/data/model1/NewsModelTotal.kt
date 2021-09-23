package com.example.newtest.data.model1


import com.google.gson.annotations.SerializedName

data class NewsModelTotal(
    @SerializedName("articles")
    val articles: List<ArticleItem>? = listOf(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)