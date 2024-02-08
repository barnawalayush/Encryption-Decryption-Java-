package ShiftingAlgorithms;

public class ShiftingFactory {

    public ShiftingAlgorithms.Shifting newInstance(String mode, String text, int key) {
        ShiftingAlgorithms.Shifting shifting = null;
        if (mode.equals("shift")) {
            shifting = new AlphabetsShifts(text, key);
        } else if (mode.equals("unicode")) {
            shifting = new UnicodeShifts(text, key);
        }

        return shifting;
    }
}
