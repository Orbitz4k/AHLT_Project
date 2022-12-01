import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class parser {

    private List<Word> Lexicon;
    private List<Pos> partsOfSpeech;
    private List<rule> ruleList;

    public parser() throws Exception {

        partsOfSpeech = new ArrayList<Pos>();
        ruleList = new ArrayList<rule>();
        Lexicon = new ArrayList<Word>();

        FileReader fr = new FileReader("src/rules.txt");
        FileReader fr2 = new FileReader("src/lexicon.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        BufferedReader br = new BufferedReader(fr);

        fillLexicon(br2);
        fillPos(br);
        fillRules(br);

        fr.close();
        fr2.close();
        br.close();
        br2.close();
    }

    public void fillLexicon(BufferedReader br) throws IOException {
        String line = "";
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ";");
            String word = st.nextToken();
            String pos = st.nextToken();
            String plural = st.nextToken();
            Word word2 = new Word(word, pos, plural);
            Lexicon.add(word2);
        }
    }

    public void fillPos(BufferedReader br) throws IOException {
        String line = "";
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            partsOfSpeech.add(new Pos(st.nextToken()));
        }
    }

    public void fillRules(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            rule rule = new rule();
            if ((line = st.nextToken()) != null) {
                rule.setRuleName(line);
                List<Pos> pos = new ArrayList<Pos>();
                while (st.hasMoreTokens()) {
                    pos.add(new Pos(st.nextToken()));
                }
                rule.setPos(pos);
            }
            ruleList.add(rule);
            line = br.readLine();
        }
    }

    public void applyRule(String s) {
        s = s.replaceAll("[^a-z A-Z]", "");
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String rule = st.nextToken();


        }
    }

    public void sentences(String s) {
        s = s.replaceAll("[^a-z A-Z]", "");
        StringTokenizer st = new StringTokenizer(s);
        List<String> dsentence = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            //Armando Ciobanu helped here
            for (int i = 0; i < Lexicon.size(); i++) {
                if (word.equals(((Word) Lexicon.get(i)).getWord())) {
                    dsentence.add(((Word) Lexicon.get(i)).getPos());
                    System.out.println(((Word) Lexicon.get(i)).getPos());
                }
            }
        }

        System.out.println("-------verb or noun phrase or adjective------");
        if ("DT".equals(dsentence.get(0))) {
            System.out.println("NP");
        } else if ("VB".equals(dsentence.get(0))) {
            System.out.println("VP");
        } else if ("VBZ".equals(dsentence.get(0))) {
            System.out.println("VP");
        } else if ("NN".equals(dsentence.get(0))) {
            System.out.println("NP");
        } else if ("JJ".equals(dsentence.get(0))) {
            System.out.println("ADJ");
        }

        System.out.println("------Valid sentence-----");
        if ("DT".equals(dsentence.get(0))) {
            System.out.println("Accepted");
        }
        if ("VBZ".equals(dsentence.get(0))) {
            System.out.println("Not Accepted");
        }
    }
}
