package edu.cnm.deepdive.cards.model

class Hand(private val cards: MutableList<Card>) {

    override fun toString(): String {
        return cards.toList().joinToString(" ")
    }

    fun removeCardsOfRank(rank: Rank): List<Card> {
        val removedCards = mutableListOf<Card>()
        for (card in cards) {
            if (card.rank == rank) {
                removedCards.add(card)
                cards.remove(card)
            }
        }
        return removedCards
    }

    fun addCards(cardsToAdd: List<Card>) {
        cards.addAll(cardsToAdd)
    }
}