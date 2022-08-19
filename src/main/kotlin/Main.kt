data class Post(
    val id: Int,
    val fromId: Int,
    val createdBy: Int,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val ownerId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val comments: Comments
    ){
    class Comments(
        var count: Int = 0,
        val canPost: Boolean = true
    )
}

object WallService{
    private var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }
    fun add (post: Post): Post {
        posts += post.copy()
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var result = true
        for ((index, item) in posts.withIndex())
        if (post.id == item.id){
            posts[index] = post.copy()
            return true
        } else result = false
        return result
    }
}

fun main () {
//    println(WallService.add(Post(1,1,1,1,1,1,22,"Первый пост", true)))
//    println(WallService.add(Post(2,1,1,1,1,1,22,"Первый пост", true)))
//    println(WallService.update(Post(1,2,2,2,2,1,22,"Первый пост обновленный", true)))
}