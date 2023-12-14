public class Card {

    private String Positivity;
    private String Color;
    private int Value;

    Card(String Color,String Positivity, int Value){

        this.Color=Color;
        this.Positivity=Positivity;
        this.Value=Value;
    }


    public String getColor() {
        return Color;
    }

    public int P1getValue() {
        if (Positivity.equals("-")){
            Value=Value*-1;
        }
        if (Positivity.equals("%")){
            Value = Value + 2*((-1) * (P1lastCardOnTheFloor().Value));

        }
        if (Positivity.equals("2x")){
            Value = Value + (P1lastCardOnTheFloor().Value);
        }

        return Value;
    }

    public int AIgetValue(){
        if (Positivity.equals("-")){
            Value=Value*-1;
        }
        if (Positivity.equals("%")){
            Value = Value + 2*((-1) * (AIlastCardOnTheFloor().Value));

        }
        if (Positivity.equals("2x")){
            Value = Value + (AIlastCardOnTheFloor().Value);
        }

        return Value;
    }

    public Card P1lastCardOnTheFloor(){
        return Main.P1Board[Main.P1index];
    }
    public Card AIlastCardOnTheFloor(){
        return Main.AIBoard[Main.AIindex];
    }

    public String toString(){
        if (Color.equals(" ")){
            return Positivity;
        }

        return  Color+" "+Positivity+" "+ Value;
    }
}
