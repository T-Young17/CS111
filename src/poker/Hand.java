/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */


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
        sortByValue();
        Card[] temp = new Card[5];
        int count = 0;
        int tcount = 0;
        for (int i = 0; i < hand.length; i++) {
            temp[i] = hand[i];
        }
        int i = 0;
        while (true) {
            if (i == temp.length - 1)
                break;
            if (temp[i].getValue() == temp[i + 1].getValue()) {
                tcount++;
            } else if (temp[i + 1].getValue() != temp[i].getValue()) {
                count += tcount / 2;
                tcount = 0;
            }

            i++;
        }
        return count;
    }


    public boolean hasTriplet() {
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == val)
                    count++;
                if (count >= 3)
                    return true;

            }
            count = 0;

        }
        return false;
    }

    public boolean hasFlush() {
        int count = 0;
        boolean flush = false;
        Card c = hand[0];

        int val = hand[0].getSuit();
        for (int j = 1; j < hand.length; j++) {
            if (hand[j].getSuit() != val)
                return false;

        }
        return true;
    }

    public boolean hasFullHouse() {
        return hasTriplet() && numPairs() == 1;
    }

    public boolean hasFourOfAKind() {
        sortByValue();
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == val)
                    count++;
                if (count == 4)
                    return true;

            }
            count = 0;
        }
        return false;
    }

    public Card highestValue() {
        sortByValue();
        Card temp = hand[0];
        if (hasStraight() && hand[0].getValue() == 1 && hand[1].getValue() == 2)
            return hand[4];
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getValue() == 1)
                return hand[i];
            else if (hand[i].getValue() > temp.getValue())
                temp = hand[i];
        }
        return temp;
    }

    public boolean hasStraight() {
        sortByValue();
        if (hand[0].getValue() == 1 && hand[1].getValue() == 10 && hand[2].getValue() == 11 && hand[3].getValue() == 12 && hand[4].getValue() == 13)
            return true;
        for (int i = 0; i < hand.length; i++) {
            if (i < hand.length - 1 && hand[i].getValue() != hand[i + 1].getValue() - 1)
                return false;
        }

        return true;
    }

    public Card highestDuplicate() {
        if (numPairs() == 0)
            return null;

        Card[] temp = new Card[2];
        int b = 0;
        for (int i = 0; i < temp.length; i++) {
            if (isDup(hand[i].getValue()) == 4)
                return hand[i];
            if (isDup(hand[i].getValue()) == 3 || isDup(hand[i].getValue()) == 2) {
                if (temp[0].getValue() != hand[i].getValue() || temp[1].getValue() != hand[i].getValue()) {
                    temp[b] = hand[i];
                    b++;
                }
            }
        }
        if (temp[0].getValue() >= temp[1].getValue())
            return temp[0];
        else
            return temp[1];

    }

    private int isDup(int val) {
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() == val)
                count++;
        }
        return count;
    }

    public int compareTo(Hand h) {
        int a = 0; //hand for one that is called on
        int b = 0; //hand for h
        if (this.numPairs() == 1 && !(this.hasTriplet()))
            a = 1;
        else if (this.numPairs() == 2 && !(this.hasFourOfAKind()))
            a = 2;
        else if (this.hasTriplet() && this.numPairs() == 0)
            a = 3;
        else if (this.hasStraight() && !(this.hasFlush()))
            a = 5;
        else if (this.hasFlush() && !(this.hasStraight()))
            a = 6;
        else if (this.hasFullHouse())
            a = 7;
        else if (this.hasFourOfAKind())
            a = 8;
        else if (this.hasStraight() && this.hasFlush())
            a = 9;
        else if (this.hasRoyalFlush())
            a = 10;

        if (h.numPairs() == 1 & !(h.hasTriplet()))
            b = 1;
        else if (h.numPairs() == 2 && !(h.hasFourOfAKind()))
            b = 2;

        else if (h.hasTriplet() && h.numPairs() == 0)
            b = 3;

        else if (h.hasStraight() && !(h.hasFlush()))
            b = 5;

        else if (h.hasFlush() && !(h.hasStraight()))
            b = 6;
        else if (h.hasFullHouse())
            b = 7;
        else if (h.hasFourOfAKind())
            b = 8;
        else if (h.hasStraight() && h.hasFlush() && !(h.hasRoyalFlush()))
            b = 9;
        else if (h.hasRoyalFlush())
            b = 10;

        if (a == 0 && b == 0) {
            if (this.highestValue().getValue() > h.highestValue().getValue())
                return 1;
            if (this.highestValue().getValue() < h.highestValue().getValue())
                return -1;
            else
                return 0;
        }
        if (a > b)
            return 1;
        if (a < b)
            return -1;

        if (a == 10 && b == 10)
            return 0;
        if (a == 1 && b == 1) {
            if (this.highPairVal() > h.highPairVal())
                return 1;
            if (this.highPairVal() < h.highPairVal())
                return -1;
            if (this.highPairVal() == h.highPairVal())
                return 0;
        } else if (a == 6 && b == 6) {
            if (this.highestValue().getValue() > h.highestValue().getValue())
                return 1;
            if (this.highestValue().getValue() < h.highestValue().getValue())
                return -1;
            else
                return 0;
        } else if (a == 3 && b == 3) {
            if (this.tripVal() > h.tripVal())
                return 1;
            if (this.tripVal() < h.tripVal())
                return -1;
            if (this.tripVal() == h.tripVal()) {
                if (Hand.maxArr(this.nonTripVal()) > Hand.maxArr(h.nonTripVal()))
                    return 1;
                if (Hand.maxArr(this.nonTripVal()) < Hand.maxArr(h.nonTripVal()))
                    return -1;
                if (Hand.maxArr(this.nonTripVal()) == Hand.maxArr(h.nonTripVal())){
                    int[] x = this.nonTripVal();
                    int[] y = h.nonTripVal();
                    if (Hand.maxArr2(this.nonTripVal()) > Hand.maxArr2(h.nonTripVal()))
                        return 1;
                    if (Hand.maxArr2(this.nonTripVal()) < Hand.maxArr2(h.nonTripVal()))
                        return -1;
                    if (Hand.maxArr2(this.nonTripVal()) == Hand.maxArr2(h.nonTripVal()))
                        return 0;
                }
            }

        } else if (a == 8 && b == 8) {
            if (this.quadVal() > h.quadVal())
                return 1;
            if (this.quadVal() < h.quadVal())
                return -1;
            if (this.quadVal() == h.quadVal()) {
                if (Hand.maxArr(this.nonTripVal()) > Hand.maxArr(h.nonTripVal()))
                    return 1;
                if (Hand.maxArr(this.nonTripVal()) < Hand.maxArr(h.nonTripVal()))
                    return -1;
                if (Hand.maxArr(this.nonTripVal()) == Hand.maxArr(h.nonTripVal()))
                    return 0;
            }

        } else if (b == 5 && a == 5 || a == 9 && b == 9) { //NEED TO ACCOUNT FOR ACE STRAIGHT CHEACH HIGHESTVALUE
            if (this.highestValue().getValue() > h.highestValue().getValue())
                return 1;
            if (this.highestValue().getValue() < h.highestValue().getValue())
                return -1;
            if (this.highestValue().getValue() == h.highestValue().getValue())
                return 0;
        }
        if (a == 7 && b == 7) {
            if (this.hand[2].getValue() > h.hand[2].getValue())
                return 1;
            else if (this.hand[2].getValue() < h.hand[2].getValue())
                return -1;
        }

        if (a == 2 && b == 2) {
            if (this.highPairVal() > h.highPairVal())
                return 1;
            if (this.highPairVal() < h.highPairVal())
                return -1;
            if (this.highPairVal() == h.highPairVal()) {
                if (this.lowPairVal() > h.lowPairVal())
                    return 1;
                if (this.lowPairVal() < h.lowPairVal())
                    return -1;
                if (this.highPairVal() == h.highPairVal()) {
                    if (this.nonPairVal() > h.nonPairVal())
                        return 1;
                    if (this.nonPairVal() < h.nonPairVal())
                        return -1;
                    if (this.nonPairVal() == h.nonPairVal())
                        return 0;
                }
            }

        }

        return 12;
    }


    private int highPairVal() {
        sortByValue();
        int count = 0;
        int[] temp = new int[4];
        int a = 0;


        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() == hand[i + 1].getValue() && hand[i].getValue() != temp[0] && hand[i].getValue() != temp[1] && hand[i].getValue() != temp[2]) {
                temp[a] = hand[i].getValue();
                temp[a + 1] = hand[i].getValue();
                a++;
            }
        }
        int val = temp[0];
        for (int i = 1; i < 3; i++) {
            if (val <= temp[i])
                val = temp[i];
        }
        return val;

    }

    private int lowPairVal() {
        sortByValue();
        int count = 0;
        int[] temp = new int[3];
        int a = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() == hand[i + 1].getValue() && hand[i].getValue() != temp[0] && hand[i].getValue() != temp[1] && hand[i].getValue() != temp[2]) {
                temp[a] = hand[i].getValue();
                a++;
                i++;
            }
        }
        int val = temp[0];
        for (int i = 1; i < 3; i++) {
            if (val > temp[i])
                val = temp[i];
        }
        return val;

    }

    private int nonPairVal() {
        sortByValue();
        int count = 0;
        int val;
        for (int i = 0; i < hand.length; i++) {
            val = hand[i].getValue();
            if ((i != 0 || i != 4) && (val != hand[i + 1].getValue() || hand[i - 1].getValue() != val))
                return val;
            if (i == 0 && val != hand[i + 1].getValue())
                return val;
            if (i == 4 && val != hand[i - 1].getValue())
                return val;
        }
        return -1;

    }

    private boolean hasRoyalFlush() {
        sortByValue();
        if (hasStraight() && hasFlush() && hand[0].getValue() == 1 && hand[4].getValue() == 13 && hand[1].getValue() == 11 && hand[0].getValue() == 10 && hand[3].getValue() == 12)
            return true;
        return false;
    }

    private int tripVal() {
        sortByValue();
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == val)
                    count++;
                if (count >= 3)
                    return hand[i].getValue();

            }
            count = 0;

        }
        return -1;
    }

    private int quadVal() {
        sortByValue();
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == val)
                    count++;
                if (count == 4)
                    return hand[i].getValue();

            }
            count = 0;

        }
        return -1;
    }

    private int[] nonTripVal() {
        sortByValue();
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            int val = hand[i].getValue();
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == val)
                    count++;
                if (count == 3 && hand[1 + j].getValue() != val) {
                    removeCard(j);
                    removeCard(j - 1);
                    removeCard(j - 2);
                }
                if (count == 4) {
                    removeCard(j);
                    removeCard(j - 1);
                    removeCard(j - 2);
                    removeCard(j - 3);
                }
            }
            count = 0;

        }
        int[] a = new int[3];
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null)
                a[i] = hand[i].getValue();
        }
        return a;
    }

    private static int maxArr(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    private static int maxArr2(int[] a) {
        if (a[0] > a[1])
            return a[0];
        else
            return a[1];
    }
}