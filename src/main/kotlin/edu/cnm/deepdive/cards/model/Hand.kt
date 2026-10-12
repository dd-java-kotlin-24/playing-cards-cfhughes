package edu.cnm.deepdive.cards.model

class Hand(private val cards: MutableList<Card>) {

    private val books = mutableSetOf<Rank>()

    init {
        checkForBooks()
        cards.sortWith(Card.CardValueGroupsComparator())
    }

    private fun checkForBooks() {
        cards.groupingBy { it.rank }.eachCount().forEach { (rank, count) ->
            if (count == 4) {
                books.add(rank)
                cards.removeAll { it.rank == rank }
            }
        }
    }

    fun getCards(): List<Card> {
        return cards.toList()
    }

    override fun toString(): String {
        return cards.toList().joinToString(" ")
    }

    fun removeCardsOfRank(rank: Rank): List<Card> {
        val removedCards = mutableListOf<Card>()
        for (card in cards) {
            if (card.rank == rank) {
                removedCards.add(card)
            }
        }
        cards.removeAll(removedCards)
        return removedCards
    }

    fun addCards(cardsToAdd: List<Card>) {
        cards.addAll(cardsToAdd)
        checkForBooks()
        cards.sortWith(Card.CardValueGroupsComparator())
    }

    fun getScore(): Int {
        return books.size
    }
}