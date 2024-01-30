package ShitingAlgorithms;

public class UnicodeShifts implements Shifting{

    private String text;
    private int key;

    public UnicodeShifts(String text, int key){
        this.text = text;
        this.key = key;
    }


    // For Encryption of original text via shifting to certain value(key) implemented for all unicode character (total 95) to right side
    public String encryptViaShift(String text, int key) {
        String originalText = text;
        StringBuilder encrypted_text = new StringBuilder("");

        for(int i=0; i<originalText.length(); i++){
            char ch = originalText.charAt(i);
            encrypted_text.append((char)(' ' + (originalText.charAt(i) - ' ' + key) % 95));
        }

        return encrypted_text.toString();
    }


    // For Decryption of encrypted text via shifting to certain value(key) implemented for all unicode character (total 95) to left side
    public String decryptViaShift(String text, int key) {    //for all unicode character (total 95)
        String encrypted_text = text;
        StringBuilder original_text = new StringBuilder("");

        for(int i=0; i<encrypted_text.length(); i++){
            char ch = encrypted_text.charAt(i);
            original_text.append((char)(' ' + ((encrypted_text.charAt(i) - ' ' + 95 - key) % 95)));
        }

        return original_text.toString();
    }
}
