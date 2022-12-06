package com.sermage.surfteam.data

data class Project(
    val name: String = "",
    val participants: List<Participant> = emptyList()
)

data class Participant(
    val name: String,
    val photoUrl: String
)

private val infijoyParticipants = listOf(
    Participant(
        name = "Никита Гагаринов",
        photoUrl = "https://24smi.org/public/media/resize/800x-/person/2017/11/14/ynr58l3rqn8p-zheleznyi-chelovek.jpg",

        ),
    Participant(
        name = "Елизавета Цыганкова",
        photoUrl = "https://gamerwall.pro/uploads/posts/2021-11/thumbs/1637894591_1-gamerwall-pro-p-osa-marvel-evandzhelin-lilli-oboi-na-raboc-1.jpg",
    )
)

private val avengersParticipants = listOf(
    Participant(
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",

        ),
    Participant(
        name = "Дмитрий Кузьменчук",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",

        ),
    Participant(
        name = "Анна Домме",
        photoUrl = "https://sci-fi-news.ru/wp-content/uploads/2017/10/Wonder-Woman-Justice-League-Headshot-850x500.jpg",

        ),
    Participant(
        name = "Никита Гагаринов",
        photoUrl = "https://24smi.org/public/media/resize/800x-/person/2017/11/14/ynr58l3rqn8p-zheleznyi-chelovek.jpg",

        ),
    Participant(
        name = "Елизавета Цыганкова",
        photoUrl = "https://gamerwall.pro/uploads/posts/2021-11/thumbs/1637894591_1-gamerwall-pro-p-osa-marvel-evandzhelin-lilli-oboi-na-raboc-1.jpg",

        )
)
val beethovenParticipants = listOf(
    Participant(
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",

        ),
    Participant(
        name = "Дмитрий Кузьменчук",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",

        )
)
val kfcParticipants = listOf(
    Participant(
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",

        ),
    Participant(
        name = "Дмитрий Кузьменчук",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",

        ),
)
val unicreditParticipants = listOf(
    Participant(
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",

        ),
    Participant(
        name = "Дмитрий Кузьменчук",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",

        ),
    Participant(
        name = "Анна Домме",
        photoUrl = "https://sci-fi-news.ru/wp-content/uploads/2017/10/Wonder-Woman-Justice-League-Headshot-850x500.jpg",

        ),
)

val projects = listOf(
    Project("Infijoy", participants = infijoyParticipants),
    Project("Avengers", participants = avengersParticipants),
    Project("Beethoven", participants = beethovenParticipants),
    Project("KFC", participants = kfcParticipants),
    Project("Unicredit", participants = unicreditParticipants)
)


