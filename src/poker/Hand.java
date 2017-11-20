/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */
package poker;

import java.util.ArrayList;


public class Hand {

    private Card[] hand;   // The cards in the hand.
    private int count;

    /**
     * Create a hand that is initially empty.
     */
    public Hand() {
        hand = new Card[5];
        count = 0;
    }

    /**
     * Remove all cards from the hand, leaving it empty.
     */
    public void clear() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
        count = 0;
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     *
     * @param c the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */
    public void addCard(Card c) {

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = c;
                count = count + 1;
                break;
            }
        }


    }

    /**
     * Remove a card from the hand, if present.
     *
     * @param c the card to be removed.  If c is null or if the card is not in
     *          the hand, then nothing is done.
     */
    public void removeCard(Card c) {

        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(c)) {
                hand[i] = null;
                count = count - 1;
            }
        }

    }

    /**
     * Remove the card in a specified position from the hand.
     *
     * @param position the position of the card that is to be removed, where
     *                 positions are starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     *                                  the hand, that is if the position is less than 0 or greater than
     *                                  or equal to the number of cards in the hand.
     */
    public void removeCard(int position) {
        if (position < 0 || position >= hand.length)
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        hand[position] = null;
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int getCardCount() {
        return count;
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     *
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.length)
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        return hand[position];
    }

    /**
     * Sorts the cards in the hand so that cards of the same suit are
     * grouped together, and within a suit the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortBySuit() {
        int size = count;
        int nonnull = 0;
        int index = 0;

        Card[] newHand = new Card[5];
        while (size > 0) {
            if (hand[nonnull] == null) {
                nonnull = nonnull + 1;
                continue;
            }
            int pos = nonnull;  // Position of minimal card.
            Card c = hand[nonnull];  // Minimal card.

            for (int i = nonnull + 1; i < hand.length; i++) {
                Card c1 = hand[i];
                if (c1 != null) {
                    if (c1.getSuit() < c.getSuit() ||
                            (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                        pos = i;
                        c = c1;
                    }
                }
            }
            hand[pos] = null;
            size = size - 1;
            newHand[index++] = c;
            nonnull = 0;
        }
        hand = newHand;
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by suit.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        int size = count;
        int nonnull = 0;
        int index = 0;

        Card[] newHand = new Card[5];
        while (size > 0) {
            if (hand[nonnull] == null) {
                nonnull = nonnull + 1;
                continue;
            }
            int pos = nonnull;  // Position of minimal card.
            Card c = hand[nonnull];  // Minimal card.

            for (int i = nonnull + 1; i < hand.length; i++) {

                Card c1 = hand[i];
                if (c1 != null) {
                    if (c1.getValue() < c.getValue() ||
                            (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                        pos = i;
                        c = c1;
                    }
                }
            }
            hand[pos] = null;
            size = size - 1;
            newHand[index++] = c;
            nonnull = 0;
        }
        hand = newHand;
    }

    public void printHand() {

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                System.out.println(hand[i]);
            }
        }
        System.out.println();
    }


    /******************************** Implement your methods here ****************************************/
    //counts number of pairs in the hand
    public int numPairs() {
        int count = 0;
        int pairs = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (j != i && hand[j].getValue() == val)
                    count++;

            }
            if (count == 2)
                pairs++;
        }

        return pairs;
    }

    public boolean hasTriplet() {
        int count = 0;
        boolean triplet = false;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (j != i && hand[j].getValue() == val)
                    count++;

            }
            if (count == 3)
                triplet = true;
        }

        return triplet;
    }
    public boolean hasFlush() {
        int count = 0;
        boolean flush = false;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (j != i && hand[j].getSuit() == val)
                    count++;
                else
                    return false;

            }
            if (count == 5)
                flush = true;
        }

        return flush;
    }

}