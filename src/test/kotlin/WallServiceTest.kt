import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    @Test
    fun updateExisting() {
        //val service = WallService() //Ошибка Expression 'WallService' of type 'WallService' cannot be invoked as a function. The function 'invoke()' is not found
        WallService.add(Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(2, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(3, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))

        val update = Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1"))

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        //val service = WallService() //Ошибка Expression 'WallService' of type 'WallService' cannot be invoked as a function. The function 'invoke()' is not found
        WallService.add(Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(2, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(3, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))

        val update = Post(5, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1"))

        val result = WallService.update(update)

        assertFalse(result)
    }

    @Test
    fun add() {

        val post = WallService.add(Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))

        val result = (post.id > 0)

        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow(){
        WallService.add(Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(2, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(3, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))

        WallService.createComment(10, Comment(1, true, 1, true, true))
    }

    @Test
    fun addComment(){
        WallService.add(Post(1, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(2, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))
        WallService.add(Post(3, 1,1,1,1,"1",22,1,true, Comment(0, true, 1, true, true),Copyright(1,"1", "1","1"), Likes(1, true,1,1),Reposts(1, null), Views(1), "1", PostSource("1", "1", "1", "1"), Geo("1","1", Place(1, "1", 1, 1, 1, "1", 1, 1, 1,1,1,"1")),1,true, true, false, true, true,true,1, Donut(true,1,Placeholder(true),true,"1")))

        val addComment = WallService.createComment(1, Comment(1, true, 1, true, true))
        val result = (addComment.count > 0)

        assertTrue(result)
    }
}