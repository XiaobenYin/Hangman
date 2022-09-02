import java.util.ArrayList;
import java.util.List;

public class HMSystem {
    private Hangman hm;
    private boolean over;
    private List<String> checked;

    public HMSystem(Hangman hm) {
        setHm(hm);
        this.over = false;
        setChecked(new ArrayList<String>());
    }

    public List<String> getChecked() {
        return checked;
    }

    public void setChecked(List<String> checked) {
        this.checked = checked;
    }

    public Hangman getHm() {
        return hm;
    }

    public void setHm(Hangman hm) {
        this.hm = hm;
    }

    public void makeGuess(String x) {
        if (over) return;
        if (x == null || x.isEmpty() || x.isBlank() || !x.matches("^[a-zA-Z]*$") || !(x.length() == 1 || x.length() == hm.getLength())) return;
        x = x.toLowerCase();
        if (checked.contains(x)) {
            return;
        } else {
            checked.add(x);
        }
        boolean guess = hm.guess(x.toCharArray());
        if ((guess && hm.getWord().equals(hm.getCurrentProgress())) || (!guess && hm.getWrongguess() >= 8)) this.over = true;
        System.out.println(roundLines());
    }

    public String roundLines() {
        if (hm.getWrongguess() >= 8) {
            return "You Lose! #Correct:"+hm.getCorrectguess()+", The Answer is:'"+hm.getWord()+"'.";
        } else if (hm.getCurrentProgress().equals(hm.getWord())) {
            return "You Win! #Correct:"+hm.getCorrectguess()+", #Wrong:"+hm.getWrongguess()+".";
        } else {
            return "Progress:"+hm.getCurrentProgress()+" #Correct:"+hm.getCorrectguess()+", #Wrong:"+hm.getWrongguess()+"/8.";
        }
    }

}
