package com.sermage.surfteam.data

data class Employee(
    val name: String,
    val photoUrl: String,
    val position: String,
    val skills: List<Skill>
)

val employees = listOf(
    Employee(
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",
        position = "Менеджер проектов",
        skills = Skills.project
    ),
    Employee(
        name = "Дмитрий Кузьменчук",
        position = "Android Texлид",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",
        skills = Skills.android
    ),
    Employee(
        name = "Анна Домме",
        position = "UI/UX Дизайнер",
        photoUrl = "https://sci-fi-news.ru/wp-content/uploads/2017/10/Wonder-Woman-Justice-League-Headshot-850x500.jpg",
        skills = Skills.design

    ),
    Employee(
        name = "Никита Гагаринов",
        position = "IOS Разработчик",
        photoUrl = "https://24smi.org/public/media/resize/800x-/person/2017/11/14/ynr58l3rqn8p-zheleznyi-chelovek.jpg",
        skills = Skills.ios
    ),
    Employee(
        name = "Елизавета Цыганкова",
        position = "Аналитик",
        photoUrl = "https://gamerwall.pro/uploads/posts/2021-11/thumbs/1637894591_1-gamerwall-pro-p-osa-marvel-evandzhelin-lilli-oboi-na-raboc-1.jpg",
        skills = Skills.analytic
    )
)
