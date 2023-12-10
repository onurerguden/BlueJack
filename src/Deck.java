
import java.util.Random;
public class Deck {
    Random r = new Random();

    private String[] Color={"Blue","Yellow","Red","Green"};
    private String[] Number={"1","2","3","4","5","6","7","8","9","10"};
    private String[] Positivity={"-","+"};
    Card[] gameDeck = new Card[40];

    public Deck(){
        int cardIndex=0;
        for (int i =0;i<Color.length;i++){
            for (int j=0;j<Number.length;j++){
                gameDeck[cardIndex]=new Card(Color[i],Positivity[1],Number[j]);
                cardIndex++;
            }
        }
    }



    public Card[] getShuffledGameDeck() {
        for (int i =0;i<gameDeck.length;i++){
            int shuffeler= r.nextInt(0, gameDeck.length);
            Card temp= gameDeck[i];
            gameDeck[i] = gameDeck[shuffeler];
            gameDeck[shuffeler]=temp;
        }
           return gameDeck;
    }

}

