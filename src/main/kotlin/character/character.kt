package org.example.character

import org.example.Races.RaceStrategy
import org.example.classes.CharacterClass
import org.example.utils.Calculator

class Character(
    val id: Int = 0,
    val name: String,
    val race: RaceStrategy,
    val characterClass: CharacterClass,
    val alignment: String,
    val background: String,
    baseAttributes: Attributes,
) {
    private var _baseAttributes: Attributes = baseAttributes
    private var _adjustedAttributes: Attributes = race.applyRaceBonuses(_baseAttributes)
    private val calculator = Calculator()

    val baseAttributes: Attributes
        get() = _baseAttributes

    val adjustedAttributes: Attributes
        get() = _adjustedAttributes

    // Companion object com metodo factory
    companion object {
        fun create(
            id: Int,
            name: String,
            race: RaceStrategy,
            characterClass: CharacterClass,
            alignment: String,
            background: String,
            baseAttributes: Attributes
        ): Character {
            return Character(id, name, race, characterClass, alignment, background, baseAttributes)
        }
    }
}
