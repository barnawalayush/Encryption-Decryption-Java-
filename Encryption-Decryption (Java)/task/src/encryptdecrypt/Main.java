package encryptdecrypt;

public class Main {

    final static String mapping = "zyxwvutsrqponmlkjihgfedcba";

    public static void main(String[] args) {

        String original_text = "we found a treasure!";

        String encrypted_text = encrypt(original_text);

        System.out.println(encrypted_text);

    }

    public static String encrypt(String original_text){
        String encrypted_text = "";

        for(int i=0; i<original_text.length(); i++){
            if(original_text.charAt(i) >= 'a' && original_text.charAt(i) <= 'z'){
                encrypted_text += mapping.charAt(original_text.charAt(i) - 'a');
            }else encrypted_text += original_text.charAt(i);
        }

        return encrypted_text;
    }
}
