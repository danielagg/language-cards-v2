package com.language_cards_v2

import org.springframework.data.repository.CrudRepository

interface LanguageCardRepository : CrudRepository<LanguageCard, Long> {
}