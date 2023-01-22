package com.language_cards_v2

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/language_cards")
class LanguageCardController(val appService: LanguageCardAppService) {

    @GetMapping("/all")
    fun getAllLanguageCards(): List<LanguageCardDTO> {
        val result = appService.getAllLanguageCards();
        return result.map { it.toDTO() }
    }

    @GetMapping("/random")
    fun getRandomLanguageCard(): LanguageCardDTO {
        return appService.getRandomLanguageCard().toDTO();
    }

    @PostMapping("/create")
    fun createNewLanguageCard(@RequestBody languageCard: CreateLanguageCardDTO) : LanguageCardDTO {
        return appService.createNewLanguageCard(languageCard.spanish, languageCard.englishTranslations).toDTO()
    }
}