package com.example.newtest.data.model


data class News(
    var section: String? = null,
    var subsection: String? = null,
    var title: String? = null,
    var abstract: String? = null,
    var url: String? = null,
    var byline: String? = null,
    var itemType: String? = null,
    var updatedDate: String? = null,
    var createdDate: String? = null,
    var publishedDate: String? = null,
    var materialTypeFacet: String? = null,
    var kicker: String? = null,
    var desFacet: List<String>? = null,
    var orgFacet: List<String>? = null,
    var perFacet: List<String>? = null,
    var geoFacet: List<String>? = null,
    var multimedia: List<Multimedia>? = null,
    var shortUrl: String? = null
)