package edu.cnm.deepdive.cards.model

class Hand(private val cards: MutableList<Card>) {

    override fun toString(): String {
        return cards.toList().joinToString(" ")
    }
}