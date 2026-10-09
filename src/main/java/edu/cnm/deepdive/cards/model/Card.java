package edu.cnm.deepdive.cards.model;

/**
 * Encapsulates the attributes and basic operations of a standard playing card.
 *
 * @param rank One of Ace through King.
 * @param suit One of Clubs, Diamonds, Hearts, Spades.
 */
public record Card(Rank rank, Suit suit) {

  // TODO: 2026-10-09 Implement Comparable<Card> to support sorting back into shrinkwrap order.

}
