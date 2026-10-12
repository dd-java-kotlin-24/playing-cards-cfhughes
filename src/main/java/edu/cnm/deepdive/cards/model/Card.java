package edu.cnm.deepdive.cards.model;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;

/**
 * Encapsulates the attributes and basic operations of a standard playing card.
 *
 * @param rank One of Ace through King.
 * @param suit One of Clubs, Diamonds, Hearts, Spades.
 */
public record Card(Rank rank, Suit suit) implements Comparable<Card>{

  @NotNull
  @Override
  public String toString() {
    return rank.toString() + suit.toString();
  }

  @Override
  public int compareTo(@NotNull Card otherCard) {
    if (suit == otherCard.suit) {
      return rank.compareTo(otherCard.rank);
    } else {
      return suit.compareTo(otherCard.suit);
    }
  }

  static class CardValueGroupsComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
      if (card1.rank == card2.rank) {
        return card1.suit.compareTo(card2.suit);
      } else {
        return card1.rank.compareTo(card2.rank);
      }
    }

  }
}
