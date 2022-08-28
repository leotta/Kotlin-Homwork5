data class Audio (
    val id: Int,
    val artist: String
    )

data class Video(
    val id: Int,
    val ownerId: Int
)

data class Photo(
    val id: Int,
    val albumeId: Int
)

data class Doc(
    val id: Int,
    val title: String
)

data class Link(
    val url: String,
    val title: String
)
interface Attachment{
    var type: String
}

data class AudioAttachment(val audio: Audio): Attachment{
    override var type = "audio"
}

data class VideoAttachment(val video: Video): Attachment{
    override var type = "video"
}

data class PhotoAttachment(val photo: Photo): Attachment{
    override var type = "photo"
}

data class DocAttachment(val doc: Doc): Attachment{
    override var type = "doc"
}

data class LinkAttachment(val link: Link): Attachment{
    override var type = "link"
}

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
    val comments: Comment,
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
    val donut: Donut,
    val attachments: Array<Attachment> = emptyArray()
    //val complaints: Complaint
    )
data class Comment(
    var count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Int,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
    )

data class Complaint (
    val ownerId: Int,
    val commentId: Int,
    val reason: Int
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

class PostNotFoundException (message: String) : RuntimeException (message)
object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var complaints = emptyArray<Complaint>()
    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
    }

    fun createComplaint (postId: Int, complaint: Complaint): Complaint{
            for ((index, item) in posts.withIndex()) {
                if (postId == index) {
                    complaints += complaint.copy()
                    return complaints.last()
//                    try {
//                        complaint.reason < 0 && complaint.reason > 10
//                        "Error"
//                    } catch (complain.reason == 0) {
//                        "spam"
//                    }
                }
            }
        return throw PostNotFoundException ("$postId пост не найден")
    }

//    fun AddReason (reason: Int, complaint: Complaint): Complaint{
//        try {
//            complaint.reason < 0 && createComplaint().reason > 10
//            PostNotFoundException  ("Error")
//        } catch (e:RuntimeException){
//            complaint.reason == 0
//            PostNotFoundException  ("spam")
//        }
//    }
    fun createComment (postId: Int, comment: Comment): Comment{
        for ((index, item) in posts.withIndex()){
            if (index == postId) {
                comments += comment.copy()
                return comments.last()
            }
        }
        return throw PostNotFoundException ("$postId пост не найден")
    }
    fun add(post: Post): Post {
        posts += post.copy()
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (post.id == item.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }
}

fun main () {
    println(WallService.createComplaint(1, complaint = Complaint(1, 1,1)))
//    println(WallService.add(Post(1,1,1,1,1,1,22,"Первый пост", true)))
//    println(WallService.add(Post(2,1,1,1,1,1,22,"Первый пост", true)))
//    println(WallService.update(Post(1,2,2,2,2,1,22,"Первый пост обновленный", true)))
}