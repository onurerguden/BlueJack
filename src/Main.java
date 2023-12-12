import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String stars ="********************";
        Deck deck = new Deck();

        Card[] gameDeck = deck.getShuffledGameDeck();
        Card [] P1Deck = new Card[10];
        Card [] AIDeck = new Card[10];
        Card [] P1Hand = new Card[4];
        Card [] AIHand = new Card[4];
        Card [] P1Board = new Card[9];
        Card [] AIBoard = new Card[9];
        String []AIClosedHand = {"X","X","X","X"};



        System.out.println("Do you want to see the deck?");
        String a =sc.nextLine();
        if (a.equals("yes")){
            for (int i =0;i<gameDeck.length;i++){
                System.out.println(gameDeck[i]);
            }
        }




        int decksLastCard=39;
        int decksFirstCard=0;
        int AIhandIndex=0;
        int P1handIndex=0;
        //Dealing the cards on by one (top,bottom)
        for (int i =0;i<5;i++){
            AIDeck[AIhandIndex]= (gameDeck[decksFirstCard]);
            gameDeck[decksFirstCard]=null;
            P1Deck[P1handIndex]= (gameDeck[decksLastCard]);
            gameDeck[decksLastCard]=null;
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
            AIDeck[AIhandIndex]= new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]);
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
                   AIDeck[AIhandIndex]=new Card(addCartColor[4],addPositivity[2],addCartValue[10]);
                   AIhandIndex++;

               } else if (random2==1) {
                   AIDeck[AIhandIndex]=new Card(addCartColor[4],addPositivity[3],addCartValue[10]);
                   AIhandIndex++;
               }

            }else {
                AIDeck[AIhandIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            AIhandIndex++;
            }
        }


        for (int i =0;i<3;i++){

            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            P1Deck[P1handIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            P1handIndex++;
        }for (int i =0;i<2;i++){
            int randomColor=r.nextInt(4);
            int randomNumber=r.nextInt(6);
            int randomPositivity=r.nextInt(2);
            int random=r.nextInt(5);
            if(random==0){
                int random2=r.nextInt(2);
                if (random2==0){
                    P1Deck[P1handIndex]=new Card(addCartColor[4],addPositivity[2],addCartValue[10]);
                    P1handIndex++;

                } else if (random2==1) {
                    P1Deck[P1handIndex]=new Card(addCartColor[4],addPositivity[3],addCartValue[10]);
                    P1handIndex++;
                }

            }else {
                P1Deck[P1handIndex]= (new Card(addCartColor[randomColor],addPositivity[randomPositivity],addCartValue[randomNumber]));
            P1handIndex++;
            }
        }



        System.out.println("Do you want to see the  players decks?");
        String b =sc.nextLine();
        if (b.equals("yes")){
            for (int i =0;i<AIhandIndex;i++){
                System.out.println("AI Deck: "+AIDeck[i]);
            }
            System.out.println(stars);
            for (int i =0;i<P1handIndex;i++){
                System.out.println("P1 Deck: "+P1Deck[i]);
            }
        }




        //Randomly choosing 4 cards and taking them to player's hands
        for (int i =0;i<P1Hand.length;i++){
            int random = r.nextInt(10);
            while (P1Deck[random]==null){
                random = r.nextInt(10);
            }
                P1Hand[i]=P1Deck[random];
                P1Deck[random]=null;
        }

        for (int i =0;i<AIHand.length;i++){
            int random = r.nextInt(10);
            while (AIDeck[random]==null){
                random = r.nextInt(10);
            }
                AIHand[i]=AIDeck[random];
                AIDeck[random]=null;

        }


        System.out.println("Do you want to see the  AI's hand?");
        String c =sc.nextLine();
        if (c.equals("yes")){
            System.out.println(stars);

            for (int i =0;i<4;i++){
                System.out.println("AI Hand: "+AIHand[i]);
            }
            System.out.println(stars);
        }


        System.out.println(stars);
        System.out.println("Game is Starting");
        System.out.println(stars);


        int P1Score=0;
        int P1index=0;
        int AIScore=0;
        int AIindex=0;




        //aı hand
        for (int i =0;i<AIClosedHand.length;i++){
            System.out.println( "AI Hand: "+AIClosedHand[i]);
        }
        System.out.println(stars);

//aı board
        for (int i = AIindex;i>-1;i--){
            if (i==AIindex){
                System.out.print("AI Board: ");
            }if (AIBoard[i]==null){
                System.out.print("Empty");

            }
            else {
                System.out.print(AIBoard[i]+" , ");
            }
        }
        System.out.println();
        System.out.println(stars);


        //player board
        for (int i = P1index;i>-1;i--){
            if (i==P1index){
                System.out.print("P1 Board: ");
            }
            //importante

            if (P1Board[i]==null){
                System.out.print("Empty");

            }
            else {
                System.out.print(P1Board[i]+" , ");
            }

        }
        System.out.println();
        System.out.println(stars);


        //player hand
        for (int i =0;i<4;i++){
            System.out.println((i+1) + ") "+ "P1 Hand: "+P1Hand[i]);
        }

        String turnP1="take card";

        while (true){



             if (turnP1.equals("play")) {
                System.out.println("Choose your card to play");
                System.out.println(stars);
                for (int i =0;i<4;i++){
                    System.out.println((i+1) + ") "+ "P1 Hand: "+P1Hand[i]);
                }
                System.out.println(stars);
                String playCard= sc.nextLine();
                if (playCard.equals("1")){
                    P1Board[P1index]=P1Hand[0];
                    P1Score=P1Score+P1Board[P1index].getValue();
                    P1Hand[0]=null;


                    for (int i = P1index;i>-1;i--){
                        if (i==P1index){
                            System.out.print("P1 Board: ");
                        }
                        System.out.print(P1Board[i]+" , ");
                    }
                    System.out.println();
                    System.out.println("P1 Score: "+P1Score);
                    P1index++;
                    break;


                }
                if (playCard.equals("2")){
                    P1Board[P1index]=P1Hand[1];
                    P1Score=P1Score+P1Board[P1index].getValue();
                    P1Hand[1]=null;


                    for (int i = P1index;i>-1;i--){
                        if (i==P1index){
                            System.out.print("P1 Board: ");
                        }
                        System.out.print(P1Board[i]+" , ");
                    }
                    System.out.println();
                    System.out.println("P1 Score: "+P1Score);
                    P1index++;
                    break;


                }if (playCard.equals("3")){
                    P1Board[P1index]=P1Hand[2];
                    P1Score=P1Score+P1Board[P1index].getValue();
                    P1Hand[2]=null;


                    for (int i = P1index;i>-1;i--){
                        if (i==P1index){
                            System.out.print("P1 Board: ");
                        }
                        System.out.print(P1Board[i]+" , ");
                    }
                    System.out.println();
                    System.out.println("P1 Score: "+P1Score);
                    P1index++;
                    break;


                }if (playCard.equals("4")){
                    P1Board[P1index]=P1Hand[3];
                    P1Score=P1Score+P1Board[P1index].getValue();
                    P1Hand[3]=null;


                    for (int i = P1index;i>-1;i--){
                        if (i==P1index){
                            System.out.print("P1 Board: ");
                        }
                        System.out.print(P1Board[i]+" , ");
                    }
                    System.out.println();
                    System.out.println("P1 Score: "+P1Score);
                    P1index++;
                    break;




                }

            }

//TAKİNG CARD AI
            System.out.println(stars);
            System.out.println("AI asks for a card!");
            AIBoard[AIindex]=gameDeck[decksFirstCard];
            AIScore=AIScore+AIBoard[AIindex].getValue();
            gameDeck[decksFirstCard]=null;



            //Printing hands
            System.out.println(stars);
            for (int i =0;i<AIClosedHand.length;i++){
                System.out.println( "AI Hand: "+AIClosedHand[i]);
            }
            System.out.println(stars);
            for (int i = AIindex;i>-1;i--){
                if (i==AIindex){
                    System.out.print("AI Board: ");
                }
                System.out.print(AIBoard[i]+" , ");
            }
            System.out.println();
            System.out.println("AI Score: "+AIScore);

            decksFirstCard++;
            AIindex++;

            System.out.println(stars);
            System.out.println("--------------------");

//TAKİNG CARD P1

            if (turnP1.equals("take card")){
                System.out.println("P1 asks for a card!");
                System.out.println(stars);
                P1Board[P1index]=gameDeck[decksFirstCard];
                P1Score=P1Score+P1Board[P1index].getValue();
                gameDeck[decksFirstCard]=null;

                for (int i = P1index;i>-1;i--){
                    if (i==P1index){
                        System.out.print("P1 Board: ");
                    }
                    System.out.print(P1Board[i]+" , ");
                }
                System.out.println();
                System.out.println("P1 Score: "+P1Score);

                decksFirstCard++;
                P1index++;
                System.out.println(stars);
                for (int i =0;i<4;i++){
                    System.out.println((i+1) + ") "+ "P1 Hand: "+P1Hand[i]);

                }


            }


            if (turnP1.equals("stand")) {

            }

            System.out.println(stars);
            System.out.println("Do you want to take card, stand or play");
            turnP1 = sc.nextLine();



        }

        System.out.println("while out");


    }

}
