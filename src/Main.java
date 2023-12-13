import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random r = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static String stars ="********************";
    public static Deck deck = new Deck();

    public static Card[] gameDeck = deck.getShuffledGameDeck();
    public static Card [] P1Deck = new Card[10];
    public static Card [] AIDeck = new Card[10];
    public static Card [] P1Hand = new Card[4];
    public static Card [] AIHand = new Card[4];
    public static Card [] P1Board = new Card[9];
    public static Card [] AIBoard = new Card[9];
    public static String []AIClosedHand = {"X","X","X","X"};
    public static int winRoundAI=0;
    public static int winRoundP1=0;

    public static int P1Score=0;
    public static int P1index=0;
    public static int AIScore=0;
    public static int AIindex=0;
    public static String turnP1="take card";
    public static boolean finish=false;
    public static int decksLastCard=39;
    public static int decksFirstCard=0;
    public static int AIhandIndex=0;
    public static int P1handIndex=0;
    public static String[] addCartColor={"Blue","Yellow","Red","Green"," "};
    public static int[] addCartValue={1,2,3,4,5,6,7,8,9,10,0};
    public static String[] addPositivity={"-","+","%","2x"};






    public static void main(String[] args) {
        printShuffeledDeck();
        dealDeck();
        showDeck();
        choose4toHand();
        showHand();
        showEmptyBoard();
        game();

        System.out.println("!!!END OF MAİN!!!");

    }
    public static void isRoundFinished(){

        if (P1Score>20&&AIScore<21){
        System.out.println(stars);
        System.out.println("P1 Bust!!!");
        System.out.println("AI takes the round");
        System.out.println(stars);
        winRoundAI++;
        turnP1="take card";

    }
        if (AIScore>20&&P1Score<21){
            System.out.println(stars);
            System.out.println("AI Bust!!!");
            System.out.println("P1 takes the round");
            System.out.println(stars);
            winRoundP1++;
            turnP1="take card";
        }
        if (AIScore>20&&P1Score>20){
            System.out.println(stars);
            System.out.println("Tie!!");
            System.out.println("No one wins!");
            System.out.println(stars);
            turnP1="take card";
        }
    }
    public static void isGameFinished(){
        if (winRoundAI>2){
            System.out.println(stars);
            System.out.println("AI Wins the game!");
            System.out.println(stars);
            finish=true;
        }

        if (winRoundP1>2){
            System.out.println(stars);
            System.out.println("AI Wins the game!");
            System.out.println(stars);
            finish=true;
        }

    }
    public static void printShuffeledDeck(){
        System.out.println("Do you want to see the deck?");
        String a =sc.nextLine();
        if (a.equals("yes")){
            for (int i =0;i<gameDeck.length;i++){
                System.out.println(gameDeck[i]);
            }
        }
    }

    public static void dealDeck(){
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

    }
    public static void choose4toHand(){
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

    }

    public static void showDeck(){
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

    }
    public static void showHand(){
        System.out.println("Do you want to see the  AI's hand?");
        String c =sc.nextLine();
        if (c.equals("yes")){
            System.out.println(stars);

            for (int i =0;i<4;i++){
                System.out.println("AI Hand: "+AIHand[i]);
            }
            System.out.println(stars);
        }

    }

    public static void showEmptyBoard(){

        System.out.println(stars);
        System.out.println("Game is Starting");
        System.out.println(stars);




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
    }
        public static void game(){
            while (finish==false){

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

                    for (int i = P1index;i>-1;i--){
                        if (i==P1index){
                            System.out.print("P1 Board: ");
                        }
                        System.out.print(P1Board[i]+" , ");
                    }
                    System.out.println();
                    System.out.println("P1 Score: "+P1Score);

                    System.out.println(stars);
                    for (int i =0;i<4;i++) {
                        System.out.println((i + 1) + ") " + "P1 Hand: " + P1Hand[i]);
                    }

                }

                //Win round conditions
                isRoundFinished();
                //game finishing conditions
                isGameFinished();

                System.out.println(stars);
                System.out.println("Do you want to take card, stand or play");
                turnP1 = sc.nextLine();

            }

        }
}
