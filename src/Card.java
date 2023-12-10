public class Card {

    private String Positivity;
    private String Color;
    private String Number;

    Card(String Color,String Positivity, String Number){

        this.Color=Color;
        this.Positivity=Positivity;
        this.Number=Number;
    }


    public String getColor() {
        return Color;
    }

    public String getNumber() {
        return Number;
    }

    public String toString(){
        return  Color+" "+" "+ Positivity+" "+ Number;
    }
}
