package com.sermage.surfteam.data

data class Employee(
    val id: String = "",
    val name: String = "",
    val photoUrl: String = "",
    val position: String = "",
    val skills: List<Skill> = emptyList(),
    val phoneNumber: String = "",
    val experience: Int = 0,
    val projects: List<Project> = emptyList(),
    val currentProject: Project = Project(),
    val age: Int = 0,
    val residentialAddress: String = ""
)

val employees = listOf(
    Employee(
        id = "1",
        name = "Олег Пашинин",
        photoUrl = "https://www.meme-arsenal.com/memes/d72919f26e4101c169a95b894bd3a4a3.jpg",
        position = "Менеджер проектов",
        skills = Skills.project,
        phoneNumber = "+79954567823",
        experience = 2,
        projects = projects.drop(3),
        currentProject = projects[0],
        age = 28,
        residentialAddress = "Воронеж"
    ),
    Employee(
        id = "2",
        name = "Дмитрий Кузьменчук",
        position = "Android Texлид",
        photoUrl = "https://www.film.ru/sites/default/files/filefield_paths/1464175888-hugh-jackman-muscles-claws-in-the-wolverine.jpg",
        skills = Skills.android,
        phoneNumber = "+79114532898",
        experience = 4,
        projects = projects.drop(2),
        currentProject = projects[1],
        age = 26,
        residentialAddress = "Курск"
    ),
    Employee(
        id = "3",
        name = "Анна Домме",
        position = "UI/UX Дизайнер",
        photoUrl = "https://sci-fi-news.ru/wp-content/uploads/2017/10/Wonder-Woman-Justice-League-Headshot-850x500.jpg",
        skills = Skills.design,
        phoneNumber = "+79562348759",
        experience = 3,
        projects = projects.drop(1),
        currentProject = projects[3],
        age = 24,
        residentialAddress = "Москва"

    ),
    Employee(
        id = "4",
        name = "Никита Гагаринов",
        position = "IOS Разработчик",
        photoUrl = "https://24smi.org/public/media/resize/800x-/person/2017/11/14/ynr58l3rqn8p-zheleznyi-chelovek.jpg",
        skills = Skills.ios,
        phoneNumber = "+79062348576",
        experience = 3,
        projects = projects.drop(2),
        currentProject = projects[0],
        age = 26,
        residentialAddress = "Тбилиси"
    ),
    Employee(
        id = "5",
        name = "Елизавета Цыганкова",
        position = "Аналитик",
        photoUrl = "https://gamerwall.pro/uploads/posts/2021-11/thumbs/1637894591_1-gamerwall-pro-p-osa-marvel-evandzhelin-lilli-oboi-na-raboc-1.jpg",
        skills = Skills.analytic,
        phoneNumber = "+79113458701",
        experience = 2,
        projects = projects.take(3),
        currentProject = projects[0],
        age = 25,
        residentialAddress = "Москва"
    )
)
