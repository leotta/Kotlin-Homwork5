
data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val postSource: PostSource,
    val geo: Geo,
    val signerId: Int,
    //val copyHistory TODO(),
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
    val donut: Donut
    )
data class Comments(
    var count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Int,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
    )

data class Copyright (
    val id: Int,
    val link: String,
    val name: String,
    val type: String
    )

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLikes: Int,
    val canPublish: Int
        )

data class Reposts (
    val count: Int,
    val userReposted: Post?
        )

data class Views (
    val count: Int
        )

data class PostSource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)

data class Geo (
    val type: String,
    val coordinates: String,
    val place: Place
        )

data class Place (
    val id: Int,
    val title: String,
    val latitude: Int,
    val longitude: Int,
    val created: Int,
    val icon: String,
    val checkins: Int,
    val updated: Int,
    val type: Int,
    val country: Int,
    val city: Int,
    val address: String
        )

data class Donut (
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Placeholder,
    val canPublishFreeCopy: Boolean,
    val editMode: String
        )
data class Placeholder(
    val placeholder: Boolean
)
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