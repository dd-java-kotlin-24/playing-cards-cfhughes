package edu.cnm.deepdive.cards

import edu.cnm.deepdive.cards.model.Deck

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
    }

}

fun main() {
    GoFish().play()
}
