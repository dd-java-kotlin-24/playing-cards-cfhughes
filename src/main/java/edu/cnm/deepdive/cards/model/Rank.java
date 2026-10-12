package edu.cnm.deepdive.cards.model;

/**
 * Defines the set of possible values for playing card ranks.
 *
 * <p>Note that Joker cards are not supported.</p>
 */
public enum Rank {
  ACE("A"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("T"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");

  private final String abbreviation;

  Rank(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  @Override
  public String toString() {
    return abbreviation;
  }

  public static Rank fromAbbreviation(String abbreviation) {
    for (Rank rank : values()) {
      if (rank.abbreviation.equals(abbreviation)) {
        return rank;
      }
    }
    return null;
  }
}
