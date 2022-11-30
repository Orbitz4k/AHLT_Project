import java.util.ArrayList;
import java.util.List;

public class rule {

    public rule() {
        pos = new ArrayList<Pos>();
    }

    public String getRuleName() {
        return ruleName;
    }

    private String ruleName;

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setPos(List<Pos> pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "rule{" +
                "ruleName='" + ruleName + '\'' +
                ", pos=" + pos +
                '}';
    }

    public List<Pos> getPos() {
        return pos;
    }

    private List<Pos> pos;
}
