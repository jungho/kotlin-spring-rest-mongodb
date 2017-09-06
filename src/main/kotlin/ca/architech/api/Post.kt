package ca.architech.api

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "posts")
class Post (val id: String? = null, val categories: String = "", val content: String = "")