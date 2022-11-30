public class Word {
    public String getWord() {
        return word;
    }

    public String getPos() {
        return pos;
    }


    public String getPlural() {
        return plural;
    }

    public Word(String word, String pos, String plural) {
        this.word = word;
        this.pos = pos;
        this.plural = plural;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", pos='" + pos + '\'' +
                ", plural='" + plural + '\'' +
                '}';
    }

    private String word;
    private String pos;
    private String plural;
}
