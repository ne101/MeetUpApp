package com.example.domain.entities

data class Community(
    val communityName: String = "Designa",
    val avatarCommunity: String = IMAGE_URL,
    val tags: List<String> = listOf(),
    val id: Int = 0,
    val personList: List<Person> = mutableListOf<Person>().apply {
        repeat(200) {
            add(Person(id = it))
        }
    },
    val description: String = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями."
) {
    companion object {
        const val IMAGE_URL =
            "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/square-logo-social-media-template-design-3c67549ba9a7c8c66b762920347c7939_screen.jpg?ts=1589204086"
    }
}
