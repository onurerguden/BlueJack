import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String stars ="********************";
        Deck deck = new Deck();

        Card[] gameDeck = deck.getShuffledGameDeck();
        Card [] P1Hand = new Card[10];
        Card [] AIHand = new Card[10];



       for (int i =0;i<gameDeck.length;i++){
            System.out.println(gameDeck[i]);
        }
       


        int decksLastCard=39;
        int decksFirstCard=0;
        int AIhandIndex=0;
        int P1handIndex=0;
        //Dealing the cards on by one (top,bottom)
        for (int i =0;i<5;i++){
            AIHand[AIhandIndex]= (gameDeck[decksFirstCard]);
            P1Hand[P1handIndex]= (gameDeck[decksLastCard]);
            AIhandIndex++;
            P1handIndex++;
            decksFirstCard++;
            decksLastCard--;

        }
        String[] addCartColor={"Blue","Yellow","Red","Green"," "};
        int[] addCartValue={1,2,3,4,5,6,7,8,9,10,0};
        String[] addPositivity={"-","+","%","2x"};


        for (int i =0;i<3;i++){

            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            AIHand[AIhandIndex]= new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]);
            AIhandIndex++;
        }
        for (int i =0;i<2;i++){
            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            int random=r.nextInt(5);
            if(random==0){
               int random2=r.nextInt(2);
               if (random2==0){
                   AIHand[AIhandIndex]=new Card(addCartColor[4],addPositivity[2],addCartValue[10]);
                   AIhandIndex++;

               } else if (random2==1) {
                   AIHand[AIhandIndex]=new Card(addCartColor[4],addPositivity[3],addCartValue[10]);
                   AIhandIndex++;
               }

            }else {
                AIHand[AIhandIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            AIhandIndex++;
            }
        }


        for (int i =0;i<3;i++){

            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            P1Hand[P1handIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            P1handIndex++;
        }for (int i =0;i<2;i++){
            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            int random=r.nextInt(5);
            if(random==0){
                int random2=r.nextInt(2);
                if (random2==0){
                    P1Hand[P1handIndex]=new Card(addCartColor[4],addPositivity[2],addCartValue[10]);;
                    P1handIndex++;

                } else if (random2==1) {
                    P1Hand[P1handIndex]=new Card(addCartColor[4],addPositivity[3],addCartValue[10]);
                    P1handIndex++;
                }

            }else {
                P1Hand[P1handIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            P1handIndex++;
            }
        }

        for (int i =0;i<AIhandIndex;i++){
            System.out.println("AI Hand: "+AIHand[i]);
        }
        System.out.println(stars);
        for (int i =0;i<P1handIndex;i++){
            System.out.println("P1 Hand: "+P1Hand[i]);
        }





    }
}
