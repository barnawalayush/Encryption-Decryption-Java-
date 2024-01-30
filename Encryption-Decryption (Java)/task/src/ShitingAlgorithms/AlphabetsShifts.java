package ShitingAlgorithms;

public class AlphabetsShifts implements Shifting{

    private String text;
    private int key;

    public AlphabetsShifts(String text, int key){
        this.text = text;
        this.key = key;
    }


    // For Encryption of original text via shifting to certain value(key) implemented for only 26 alphabetic character to right side
    public String encryptViaShift(String text, int key){
        String original_text = text;
        StringBuilder encrypted_text = new StringBuilder("");

        for(int i=0; i<original_text.length(); i++){
            char ch = original_text.charAt(i);
            if(ch>='a' && ch<='z')
                encrypted_text.append((char)('a' + ((original_text.charAt(i) - 'a' + key) % 26)));
            else if(ch>='A' && ch<='B'){
                encrypted_text.append((char)('A' + ((original_text.charAt(i) - 'A' + key) % 26)));
            } else encrypted_text.append(" ");
        }

        return encrypted_text.toString();
    }


    // For Decryption of encrypted text via shifting to certain value(key) implemented for only 26 alphabetic character to left side
    public String decryptViaShift(String text, int shift){
        String encrypted_text = text;
        StringBuilder decrypted_text = new StringBuilder("");

        for(int i=0; i<encrypted_text.length(); i++){
            char ch = encrypted_text.charAt(i);
            if(ch>='a' && ch<='z')
                decrypted_text.append((char)('a' + ((encrypted_text.charAt(i) - 'a' + 26 - shift) % 26)));
            else if(ch>='A' && ch<='B'){
                decrypted_text.append((char)('A' + ((encrypted_text.charAt(i) - 'A' + 26 - shift) % 26)));
            }else decrypted_text.append(" ");
        }

        return decrypted_text.toString();
    }
}
