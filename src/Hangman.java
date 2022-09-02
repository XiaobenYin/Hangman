import java.util.Arrays;

public class Hangman {
    private String word;
    private int length;
    private int correctguess;
    private int wrongguess;
    private String currentProgress;

    public Hangman() {}

    public String getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(String currentProgress) {
        this.currentProgress = currentProgress;
    }

    public int getWrongguess() {
        return wrongguess;
    }

    public void setWrongguess(int wrongguess) {
        this.wrongguess = wrongguess;
    }

    public int getCorrectguess() {
        return correctguess;
    }

    public void setCorrectguess(int correctguess) {
        this.correctguess = correctguess;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        word = word.toLowerCase();
        this.word = word;
    }

    public boolean guess(char[] x) {
        if (x.length == 1) {
            boolean found = false;
            char currchar = x[0];
            char[] cp = currentProgress.toCharArray();
            char[] wd = word.toCharArray();
            for (int i = 0; i < length; i++) {
                if (wd[i] == currchar) {
                    found = true;
                    cp[i] = currchar;
                }
            }
            if (found) {
                int currcg = correctguess;
                setCorrectguess(currcg+1);
                setCurrentProgress(String.valueOf(cp));
                return true;
            } else {
                int currwg = wrongguess;
                setWrongguess(currwg+1);
                return false;
            }
        } else if (x.length > 1) {
            String xstr = String.valueOf(x);
            System.out.println(xstr);
            if (xstr.equals(word)) {
                int currcg = correctguess;
                setCorrectguess(currcg+1);
                setCurrentProgress(word);
                return true;
            } else {
                int currwg = wrongguess;
                setWrongguess(currwg+length);
                return false;
            }
        } else {
            return false;
        }
    }
}
