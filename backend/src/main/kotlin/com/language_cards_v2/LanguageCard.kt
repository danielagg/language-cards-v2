package com.language_cards_v2

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "spanish_english_translations")
data class LanguageCard(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: String = "",
    val spanish: String = "",
    val englishTranslations: List<String> = listOf(),
    val createdOn: LocalDate = LocalDate.now()) {

    fun toDTO(): LanguageCardDTO {
        return LanguageCardDTO(id, spanish, englishTranslations)
    }
}