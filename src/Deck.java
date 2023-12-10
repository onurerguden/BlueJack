
import java.util.Random;
public class Deck {
    Random r = new Random();

    private String[] Color={"Blue","Yellow","Red","Green"};
    private String[] Number={"1","2","3","4","5","6","7","8","9","10"};

    public Deck(){
        Card[] gameDeck = new Card[40];
        int cardIndex=0;

        for (int i =0;i<Color.length;i++){
            for (int j=0;j<Number.length;j++){
                gameDeck[cardIndex]=new Card(cardIndex,Color[i],Number[j]);
                cardIndex++;
            }
        }


    }
    public void printDeck(){
        Card[] gameDeck = new Card[40];
        int cardIndex=0;

        for (int i =0;i<Color.length;i++){
            for (int j=0;j<Number.length;j++){
                gameDeck[cardIndex]=new Card(cardIndex,Color[i],Number[j]);
                cardIndex++;
            }
        }

        for (int i =0;i<40;i++){
            System.out.println(gameDeck[i]);
        }
    }
}

