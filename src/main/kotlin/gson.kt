package ru.netology.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
    val currentTime: Long = System.currentTimeMillis()/1000
    val postPost = Post(
        1,
        "Дядя Фёдор",
        "Я ничей. Я сам по себе мальчик. Свой собственный. Я из города приехал.",
        1574814997,
        postType = PostType.POST,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = true,
        likes = 111,
        comments = 27,
        shares = 61
    )

    val list = listOf(
        postPost,
        Post(2, "Шарик", "Здравствуйте. Возьмите меня к себе жить. Я вам буду все охранять.",
            1574818997, source = postPost, postType = PostType.REPOST,
            likedByMe = false, commentedByMe = false, sharedByMe = false, likes = 11, comments = 7, shares = 0),
        Post(3, "Почтальон Печкин", "The old post office in Ny-Ålesund is not in official use anymore, but it is open and visitors are free to walk in.",
            1574819997, postType = PostType.EVENT, address = "Ny-Ålesund Post Office", location = 78.9237826 to 11.9079864,
            likes = 36, comments = 12, shares = 3, likedByMe = true, commentedByMe = true),
        Post(4, "Мама", "Как мне все это надоело. Наша квартира мне телевизионнную передачу напоминает. \"Что-где-когда\" называется.",
            1574821297, postType = PostType.AD, adLink = "https://netology.ru/programs/profession-product",
            likedByMe = true, commentedByMe = false, sharedByMe = true, likes = 38, comments = 2, shares = 1),
        Post(5, "Кот Матроскин", "Lorde - Yellow Flicker Beat (cover by Sershen&Zaritskaya)",
            1574823001,
            postType = PostType.VIDEO,
            videoLink = "https://www.youtube.com/watch?v=3Bg_bj8pI5c",
            likedByMe = true, commentedByMe = true, sharedByMe = true, likes = 98, comments = 123, shares = 12),
        Post(6, "Друг Гельмут", "Это совсем немного!", 1574823801, PostType.POST)

    )

    println(Gson().toJson(list))

    val gson = GsonBuilder().apply {
        setPrettyPrinting()
        serializeNulls()
    }.create()
    Files.write(Paths.get("./output.json"), gson.toJson(list).toByteArray(), StandardOpenOption.CREATE)
}
