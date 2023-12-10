public class Card {

    private String Color;
    private String Number;

    Card(String Color,String Number){

        this.Color=Color;
        this.Number=Number;
    }


    public String getColor() {
        return Color;
    }

    public String getNumber() {
        return Number;
    }

    public String toString(){
        return  Color+" "+Number;
    }
}
