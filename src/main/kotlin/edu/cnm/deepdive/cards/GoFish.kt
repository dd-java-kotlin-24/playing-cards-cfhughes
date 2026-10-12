package edu.cnm.deepdive.cards

import edu.cnm.deepdive.cards.model.Deck
import edu.cnm.deepdive.cards.model.Rank

class GoFish {

    fun play() {
        println("Welcome to Go Fish!")
        val deck = Deck()
        deck.shuffle()
        val playerHand = deck.deal(7)
        val computerHand = deck.deal(7)
        println("Cards have been dealt.")
        println("Behold your cards!:")
        println(playerHand)
        println("Which card value would you like to ask for?")
        do {
            val input = readln()
            val rank = Rank.fromAbbreviation(input)
            if (rank == null) {
                println("That is not a valid value! Try again.")
            }
        } while (rank == null)

    }

}

fun main() {
    GoFish().play()
}
