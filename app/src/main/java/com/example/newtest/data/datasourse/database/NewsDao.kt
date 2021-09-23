package com.example.newtest.data.datasourse.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem
import com.example.newtest.data.model1.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM article")
    fun getAllNews(): List<ArticleEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsEntity: List<ArticleEntity>)


}