public class Player {

    private String name;
    private char marker;

    public Player(String name,char marker){
        this.marker = marker;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public char getMarker() {
        return marker;
    }
}
