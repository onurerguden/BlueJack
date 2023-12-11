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

    public int getValue() {
        if (Positivity.equals("-")){
            Value=Value*-1;
        }
        return Value;
    }

    public String toString(){
        if (Color.equals(" ")){
            return Positivity;
        }

        return  Color+" "+Positivity+" "+ Value;
    }
}
