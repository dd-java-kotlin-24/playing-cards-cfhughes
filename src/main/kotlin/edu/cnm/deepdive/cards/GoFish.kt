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
        GoFishGameplay(playerHand, computerHand, deck).playTurns()
    }

}

fun main() {
    GoFish().play()
}
