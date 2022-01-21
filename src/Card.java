public class Card {
    private final int cardSuit;
    private final int cardRank;

    //KEY for VALUES
    //0 = Spades, 1 = Hearts, 2 = Diamonds , 3 = Clubs , Joker = 4
    //All cards are their value, J = 11, Q = 12, K = 13, A = 14, Joker = 15
    Card(int cardSuit, int cardRankbyte){
        this.cardSuit = cardSuit;
        this.cardRank = cardRankbyte;
    }

    //Gets the Card Suit. Refer to the key for the return value.
    public int getCardSuit(){
        return cardSuit;
    }

    //Gets the card rank, refer to the key for faceCard values.
    public int getCardRank(){
        return cardRank;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        switch(cardRank){ //Assign the face value if possible.
            case 15 -> {return "Joker";}
            case 14 -> sb.append("Ace");
            case 11 -> sb.append("J");
            case 12 -> sb.append("Q");
            case 13 -> sb.append("K");
            default -> sb.append(cardRank);
        }

        switch(cardSuit){ //Say the Suit of the card.
            case 0 -> sb.append(" of Spades");
            case 1 -> sb.append(" of Hearts");
            case 2 -> sb.append(" of Diamonds");
            case 3 -> sb.append(" of Clubs");
            case 4 -> {return "Joker";}
        }

        return sb.toString();
    }
}