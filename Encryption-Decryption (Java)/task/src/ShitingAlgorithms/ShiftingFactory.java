package ShitingAlgorithms;

public class ShiftingFactory {

    public Shifting newInstance(String mode, String text, int key){
        Shifting shifting = null;
        if(mode.equals("shift")){
            shifting = new AlphabetsShifts(text, key);
        }else if(mode.equals("unicode")) {
            shifting = new UnicodeShifts(text, key);
        }

        return shifting;
    }
}
