import java.util.Collections;
import java.util.Stack;

public class Deck {
    protected Stack<Card> deckOfCards = new Stack<>();
    private Stack <Card> cardsOut = new Stack<>();

    // create the deck and fill it with all the cards.
    public Deck(){
        //For every Suit, create 1 card of that type.
        for(int i=0;i<4;i++){
            for(int j=2;j<15;j++) deckOfCards.add(new Card(i,j));
        }
        shuffleDeck();
    }

    //Overloaded constructor that adds the amount of jokers specified.
    public Deck(int numJokers){
        //For every Suit, create 1 card of that type.
        for(int i=0;i<4;i++){
            for(int j=2;j<15;j++) deckOfCards.add(new Card(i,j));
        }
        for(int i=0;i<numJokers;i++){
            deckOfCards.add(new Card(4,15)); // Add as many jokers as requested.
        }
    }

    //Shuffle Deck
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    //Deals the top card out and adds it to the cards out
    public Card dealOneCard(){
        cardsOut.push(deckOfCards.pop()); // This takes the top card of the deck, and puts it to the top of cards out.
        return cardsOut.peek();
    }

    //This deals a hand of 5 cards all at once and returns it as an array.
    public Card[] getHandOf5Cards(){
        Card []hand = new Card[5];
        for (int i=0;i<5;i++){
            hand[i] = dealOneCard();
        }
        return hand;
    }

    private Card[] deal5SetCardsTesting(){
        Card []hand = new Card[5];
        hand[0] = new Card((byte)0,(byte)2);
        hand[1] = new Card((byte)1,(byte)2);
        hand[2] = new Card((byte)2,(byte)3);
        hand[3] = new Card((byte)3,(byte)4);
        hand[4] = new Card((byte)2,(byte)14);
        return hand;
    }


    //This returns the deck's current size.
    public int deckOfCardsLength(){
        return deckOfCards.size();
    }

    //This returns the number of cards currently out
    public int numCardsOut(){
        return cardsOut.size();
    }

    //This will reset the deck by adding all the cards out back into the deck.
    public void resetDeck(){
        deckOfCards.addAll(cardsOut);
        cardsOut.clear();
        shuffleDeck();
    }
}