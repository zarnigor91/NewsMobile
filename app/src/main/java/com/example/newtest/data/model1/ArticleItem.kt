package com.example.newtest.data.model1


import com.google.gson.annotations.SerializedName

data class ArticleItem (
  @SerializedName("author")
  val author: String? = "",
  @SerializedName("content")
  val content: String? = "",
  @SerializedName("description")
  val description: String? = "",
  @SerializedName("publishedAt")
  val publishedAt: String? = "",
  @SerializedName("source")
  val source: Source? = Source(),
  @SerializedName("title")
  val title: String? = "",
  @SerializedName("url")
  val url: String? = null,
  @SerializedName("urlToImage")
  val urlToImage: String? = ""
)

fun ArticleItem.toEntity() : ArticleEntity {
  return ArticleEntity(null, title,description,content,author,url,urlToImage,source?.name,sourceId = null,
    publishedAt, isBookmarked = true )
}

fun ArticleItem.toNewsItem() : Article {
 return Article(author,content,description,publishedAt,source?.name,title,url,urlToImage)
}

