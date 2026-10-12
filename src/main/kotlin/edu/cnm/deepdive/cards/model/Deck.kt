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

    fun shuffle() {
        cards.shuffle()
    }

    fun deal(number: Int) : Hand {
        val taken = cards.take(number)
        cards.removeAll(taken)
        return Hand(taken.toMutableList())
    }

    fun draw(): Card {
        return cards.removeFirst()
    }

    fun isEmpty(): Boolean {
        return cards.isEmpty()
    }

}