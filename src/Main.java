public class Main {
    public static Deck gameDeck = new Deck();

    public static void main(String[] args) {
        Deck deck = new Deck();

        Card[] gameDeck = deck.getShuffledGameDeck();
        String [] playerHand = new String[10];
        String [] AIHand = new String[10];


      //  gameDeck.printDeck();

        int decksLastCard=39;
        int decksFirstCard=0;
        int handIndex=0;
        for (int i =0;i<5;i++){
            AIHand[handIndex]= String.valueOf(gameDeck[decksFirstCard]);
            playerHand[handIndex]=String.valueOf(gameDeck[decksLastCard]);
            handIndex++;
            decksFirstCard++;
            decksLastCard--;

        }
        for (int i =0;i<5;i++){
            System.out.println("AI -"+AIHand[i]);
        }
        for (int i =0;i<5;i++){
            System.out.println("Player -"+playerHand[i]);
        }





    }
}
