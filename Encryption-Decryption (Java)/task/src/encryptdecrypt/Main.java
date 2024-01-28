package encryptdecrypt;

import java.util.Scanner;

public class Main {

    final static String mapping = "zyxwvutsrqponmlkjihgfedcba";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String original_text = sc.nextLine();
        int shift = sc.nextInt();

        String encrypted_text = encryptViaShift(original_text, shift);
        //String encrypted_text = encrypt(original_text);

        System.out.println(encrypted_text);

    }

    private static String encryptViaShift(String originalText, int key) {
        StringBuilder encrypted_text = new StringBuilder("");

        for(int i=0; i<originalText.length(); i++){
            char ch = originalText.charAt(i);
            if(ch>='a' && ch<='z')
                encrypted_text.append((char)('a' + ((originalText.charAt(i) - 'a' + key) % 26)));
            else encrypted_text.append(" ");
        }

        return encrypted_text.toString();
    }

    public static String encrypt(String original_text){   // a->z, b->y, c->x....
        String encrypted_text = "";

        for(int i=0; i<original_text.length(); i++){
            if(original_text.charAt(i) >= 'a' && original_text.charAt(i) <= 'z'){
                encrypted_text += mapping.charAt(original_text.charAt(i) - 'a');
            }else encrypted_text += original_text.charAt(i);
        }

        return encrypted_text;
    }
}
