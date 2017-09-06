package ca.architech.api

import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, String> {
    //Post? means that return value can be null
    fun findById(id: String) : Post?
}