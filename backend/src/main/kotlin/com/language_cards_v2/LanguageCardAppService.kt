package com.language_cards_v2

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull
import kotlin.random.Random

@Service
class LanguageCardAppService(val repository: LanguageCardRepository) {

    fun getAllLanguageCards(): Iterable<LanguageCard> {
        return repository.findAll()
    }

    fun getRandomLanguageCard() : LanguageCard {

        val totalCount = repository.count().toInt();
        val idOfRandomEntry = Random.nextInt(1, totalCount + 1);

        val randomEntry = repository.findByIdOrNull(idOfRandomEntry.toLong());

        if(randomEntry != null)
            return randomEntry
        else {
            throw Exception("Could not find random entry");
        }
    }

    fun createNewLanguageCard(spanish: String, englishTranslations: List<String>) : LanguageCard {
        val newEntity = LanguageCard(
            spanish = spanish,
            englishTranslations = englishTranslations
        )
        try {
            return repository.save(newEntity)
        } catch (e: Exception) {
            throw Exception("Could not save new entity")
        }
    }
}