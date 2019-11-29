package ru.netology.gson

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: Long = System.currentTimeMillis()/1000,
    val postType: PostType = PostType.POST,
    val source: Post? = null,
    val address: String? = null,
    val location: Pair<Double, Double>? = null,
    val videoLink: String? = null,
    val adLink: String? = null,
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    var likes: Int = 0,
    var comments: Int = 0,
    var shares: Int = 0

)

enum class PostType {
    POST,
    REPOST,
    EVENT,
    VIDEO,
    AD
}