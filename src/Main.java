import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String stars ="********************";
        Deck deck = new Deck();

        Card[] gameDeck = deck.getShuffledGameDeck();
        String [] P1Hand = new String[10];
        String [] AIHand = new String[10];



      /*  for (int i =0;i<gameDeck.length;i++){
            System.out.println(gameDeck[i]);
        }

       */


        int decksLastCard=39;
        int decksFirstCard=0;
        int AIhandIndex=0;
        int P1handIndex=0;
        //Dealing the cards on by one (top,bottom)
        for (int i =0;i<5;i++){
            AIHand[AIhandIndex]= String.valueOf(gameDeck[decksFirstCard]);
            P1Hand[P1handIndex]=String.valueOf(gameDeck[decksLastCard]);
            AIhandIndex++;
            P1handIndex++;
            decksFirstCard++;
            decksLastCard--;

        }
        String[] addCartColor={"Blue","Yellow","Red","Green"};
        String[] addCartNumber={"1","2","3","4","5","6"};
        String[] addPositivity={"-","+"};
        for (int i =0;i<3;i++){

            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            AIHand[AIhandIndex]= String.valueOf(new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartNumber[randomNumber]));
            AIhandIndex++;
        }
        for (int i =0;i<3;i++){

            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            P1Hand[P1handIndex]= String.valueOf(new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartNumber[randomNumber]));
            P1handIndex++;
        }





        for (int i =0;i<8;i++){
            System.out.println("AI Hand: "+AIHand[i]);
        }
        System.out.println(stars);
        for (int i =0;i<8;i++){
            System.out.println("P1 Hand: "+P1Hand[i]);
        }





    }
}
