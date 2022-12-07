package com.sermage.surfteam.data

data class Project(
    val name: String = "",
    val description: String = "",
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
    Project(
        "Infijoy",
        participants = infijoyParticipants,
        description = "Онлайн образовательный проект мирового уровня. В первых рядах: США, Англия и другие страны Европы." +
                "Цель - помочь людям получить качественную информацию в сфере психологии. Преподаватели из Стэнфордского, Колумбийского университетов. В приложении можно получить доступ к готовым видео-аудио материалам и посещать онлайн-уроки, мастер классы." +
                "Планируется пока только приложение для студентов. В будущем возможно будет приложение для преподавателей."
    ),
    Project(
        "Avengers",
        participants = avengersParticipants,
        description = "Вам предстоит играть за Железного человека, Человека-паука, Халка, Капитана Америку, Росомаху и многих других персонажей Марвел. Персонажи вместе будут пытаться сорвать планы Локи и других злодеев из вселенной Марвел и не дать тем собрать сверхоружие, способное уничтожить весь мир!"
    ),
    Project(
        "Beethoven",
        participants = beethovenParticipants,
        description = "Приложение для магазина зоотоваров Beethoven. В первом выпуске мы сосредоточились на двух основных этапах: создании удобного каталога с удобной навигацией и выбором товаров, а также вариантов быстрого заказа, где каждый шаг понятен и прозрачен для клиента. Ключевая задача - обеспечить максимальную прозрачность при расчете стоимости доставки, применении скидок, точности и простоте оформления заказа. "
    ),
    Project(
        "Burger King",
        participants = kfcParticipants,
        description = "Приложение для ресторанной сети Burger King. Совместно с дизайнером «Бургер Кинга» мы реализовали новую концепцию дизайна бренда в мобильном приложении. Теперь у канала продаж «Бургер Кинга» гораздо более современный и стильный дизайн, отражающий текущие ценности бренда. С изменением дизайна менялось и позиционирование, и логика приложения. Параллельно с редизайном реализовали и некоторые улучшения UX. Например, раньше для авторизации пользователю нужно было пройти три экрана, а теперь — всего один. Сейчас мы продолжаем развивать проект, добавляем новые возможности для пользователей. Например, запустили оплату через SberPay."
    ),
    Project(
        "Unicredit",
        participants = unicreditParticipants,
        description = "Mobile.UniCredit - мобильное приложение от ЮниКредит Банка в России, позволит вам легко управлять своими финансами.\n" +
                "Возможности общего раздела:\n" +
                "- поиск ближайших банкоматов и отделений ЮниКредит Банка;\n" +
                "- просмотр новостей и курсов валют (для банкоматов, обменных пунктов и безналичных операций по счетам физических лиц) в ЮниКредит Банке;\n" +
                "- доступ к информации о специальных предложениях и продуктах ЮниКредит Банка (с возможностью оставить заявку)"
    )
)


