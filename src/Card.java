public class Card {
    private int no;
    private String Color;
    private String Number;

    Card(int no,String Color,String Number){
        this.no=no;
        this.Color=Color;
        this.Number=Number;
    }

    public int getNo() {
        return no;
    }

    public String getColor() {
        return Color;
    }

    public String getNumber() {
        return Number;
    }

    public String toString(){
        return Color+" "+Number;
    }
}
