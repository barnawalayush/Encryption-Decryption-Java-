package ShiftingAlgorithms;

public class ShiftingFactory {

    public ShitingAlgorithms.Shifting newInstance(String mode, String text, int key){
        ShitingAlgorithms.Shifting shifting = null;
        if(mode.equals("shift")){
            shifting = new AlphabetsShifts(text, key);
        }else if(mode.equals("unicode")) {
            shifting = new UnicodeShifts(text, key);
        }

        return shifting;
    }
}
