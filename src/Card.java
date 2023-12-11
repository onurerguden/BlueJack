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
        return Value;
    }

    public String toString(){
        return  Color+" "+" "+ Positivity+" "+ Value;
    }
}
