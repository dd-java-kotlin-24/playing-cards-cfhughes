package edu.cnm.deepdive.cards.model

class Deck {

    private val cards: MutableList<Card>

    init {
        cards = mutableListOf()
        for (suit in Suit.entries) {
            for (rank in Rank.entries) {
                cards += Card(rank, suit)
            }
        }
    }

}