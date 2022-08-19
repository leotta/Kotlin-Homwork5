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
        WallService.add(Post(1, 1,1,1,1,1,22,"Первый пост", true))
        WallService.add(Post(2, 1,1,1,1,1,22,"Второй пост", true))
        WallService.add(Post(3, 1,1,1,1,1,22,"Третий пост", false))

        val update = Post(1,2,2,2,2,2,22,"Первый пост обновлненный", false)

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Before
    fun clearBeforeTest2() {
        WallService.clear()
    }
    @Test
    fun updateNotExisting() {
        //val service = WallService() //Ошибка Expression 'WallService' of type 'WallService' cannot be invoked as a function. The function 'invoke()' is not found
        WallService.add(Post(1, 1,1,1,1,1,22,"Первый пост", true))
        WallService.add(Post(2, 1,1,1,1,1,22,"Второй пост", true))
        WallService.add(Post(3, 1,1,1,1,1,22,"Третий пост", false))

        val update = Post(5,2,2,2,2,2,22,"Первый пост обновлненный", false)

        val result = WallService.update(update)

        assertFalse(result)
    }

    @Test
    fun add() {

        val post = WallService.add(Post(1, 1,1,1,1,1,22,"Первый пост", true))

        val result = (post.id > 0)

        assertTrue(result)
    }
}