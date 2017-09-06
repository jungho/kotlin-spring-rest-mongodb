package ca.architech.api

import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.servlet.http.HttpServletResponse

/**
 * Simple RestController in Kotlin
 */
@RestController
@RequestMapping("/api/posts")
class BlogController(@Autowired
                     val repository: PostRepository) {
    //the !! is how we tell the compiler that we know this function will not return null
    //and if it does, we accept the consequences.  Kotlin forces us to make our intention
    //clear
    val logger = LogFactory.getLog(BlogController::class.java)!!

    @GetMapping()
    fun getPosts(): List<Post> = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getPost(@PathVariable id: String, response: HttpServletResponse): Post? =
            repository.findById(id) ?: notFound(response)

    @PostMapping()
    fun createPost(@RequestBody post: Post): ResponseEntity<HttpStatus> {
        val newPost = repository.insert(post)
        val uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.id)
                .toUri()
        return ResponseEntity.created(uri).build()
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: String): ResponseEntity<HttpStatus> =
            //when is like the Java switch but more powerful
            //notice it evaluates to an expression
            //and because it is an expression, we can use the expression body syntax
            //for functions
            when(repository.findById(id)) {
                null -> {
                    logger.debug("Post not found for id: $id")
                    ResponseEntity(HttpStatus.NOT_FOUND)
                }
                else -> {
                    repository.delete(id)
                    ResponseEntity(HttpStatus.ACCEPTED)
                }
            }

    // Generic function that updates response to 'Not Found' and returns a null object based on caller's type
    private fun <T> notFound(response: HttpServletResponse): T? {
        response.status = 404
        return null
    }
}
