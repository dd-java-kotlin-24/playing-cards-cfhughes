package edu.cnm.deepdive.cards


import edu.cnm.deepdive.cards.model.Deck
import edu.cnm.deepdive.cards.model.Hand
import edu.cnm.deepdive.cards.model.Rank

class GoFishGameplay(val playerHand: Hand, val computerHand: Hand, val deck: Deck) {

    fun playTurns() {
        do {
            println("Score: Player: ${playerHand.getScore()} Computer: ${computerHand.getScore()}")
            println("Behold your cards!:")
            println(playerHand)
            do {
                val rank: Rank = promptForRank()
                val takenCards = computerHand.removeCardsOfRank(rank)
                playerHand.addCards(takenCards)
                if (takenCards.isNotEmpty()) {
                    println("I had ${takenCards.count()} $rank cards! Go again!")
                }
            } while (takenCards.isNotEmpty())
            println("Go Fish!")
            playerHand.addCards(listOf(deck.draw()))
            // TODO If player draws a card of the rank they asked for, they can go again
            // Computer turn
            do {
                val rank: Rank = computerPickRank()
                val takenCards = playerHand.removeCardsOfRank(rank)
                computerHand.addCards(takenCards)
                if (takenCards.isNotEmpty()) {
                    println("Computer player took ${takenCards.count()} $rank cards!")
                }
            } while (takenCards.isNotEmpty())
            println("Computer goes fishing")
            computerHand.addCards(listOf(deck.draw()))
        } while (!isGameOver())
        println("Game Over!")
        println("Score: Player: ${playerHand.getScore()} Computer: ${computerHand.getScore()}")
    }

    private fun isGameOver(): Boolean {
        return playerHand.getScore() + computerHand.getScore() == 13
    }

    private fun promptForRank(): Rank {
        println("Which card value would you like to ask for?")
        var rank: Rank?
        do {
            val input = readln().trim()
            rank = Rank.fromAbbreviation(input)
            if (rank == null) {
                println("That is not a valid value! Try again.")
            }
        } while (rank == null)
        return rank
    }

    private fun computerPickRank(): Rank {
        // Pick the rank the computer has the greatest number of
        return computerHand.getCards().groupingBy { it.rank }
            .eachCount().maxBy { it.value }.key
    }

}