package com.example.newtest.data.model1


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: Any? = Any(),
    @SerializedName("name")
    val name: String? = ""
)