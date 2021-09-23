package com.example.newtest.data.model1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_article_id")
    val articleId: Long? = null,

    @ColumnInfo(name = "article_title")
    val title: String? = null,

    @ColumnInfo(name = "article_desc")
    val description: String? =  null,

    @ColumnInfo(name = "article_content")
    val content: String? = null,

    @ColumnInfo(name = "article_author")
    val author: String? = null,

    @ColumnInfo(name = "article_url")
    val url: String? = null,

    @ColumnInfo(name = "article_image_url")
    val urlToImage: String? = "",

    @ColumnInfo(name = "article_source")
    val source: String? = null,

    @ColumnInfo(name = "article_source_id")
    val sourceId: String? = null,

    @ColumnInfo(name = "article_published_at")
    val publishedAt: String? = null,

    @ColumnInfo(name = "article_is_bookmarked")
    val isBookmarked: Boolean?
)
fun ArticleEntity.toNews() : Article {
   return Article(
      author,
      content,
      description,
      publishedAt,
      source,
      title,
      url,
       urlToImage
   )
}

