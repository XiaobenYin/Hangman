public class HMView {
    public HMView() {}

    public static void main(String[] args) throws Exception {
        Hangman hm = new Hangman();
        String inputStr = "any";
        hm.setWord(inputStr);
        hm.setLength(inputStr.length());
        hm.setCorrectguess(0);
        hm.setWrongguess(0);
        hm.setCurrentProgress("_".repeat(inputStr.length()));
        HMController hmc = new HMController(hm);
        //hmc.makeGuess("any");
        hmc.makeGuess("an");
        hmc.makeGuess("a");
        hmc.makeGuess("n");
        hmc.makeGuess("y");
        //System.out.println(hmc.getChecked().toString());
    }
}
