public class Pos {
    @Override
    public String toString() {
        return "pos{" +
                "pos='" + pos + '\'' +
                '}';
    }

    private String pos;

    public Pos(String pos) {
        this.pos = pos;
    }
    public String getPosS(){
        return pos;
    }
}
