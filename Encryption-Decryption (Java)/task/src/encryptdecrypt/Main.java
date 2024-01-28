package encryptdecrypt;

import java.util.Scanner;

public class Main {

    final static String mapping = "zyxwvutsrqponmlkjihgfedcba";

    public static void main(String[] args) {

        String encrypted_text = "";
        String original_text = "";
        String operation = "enc";
        int shift = 0;

        // Taking -mode para1 -key para2 -data para3 as input command line arguments
        String data = "";
        for(int i=0; i<args.length; i=i+2){
            if(args[i].equals("-mode")){
                operation = args[i+1];
            }else if(args[i].equals("-key")){
                shift = Integer.parseInt(args[i+1]);
            }else if(args[i].equals("-data")){
                data = args[i+1];
            }
        }

        if(operation.equals("enc"))original_text = data;
        else encrypted_text = data;

//        Scanner sc = new Scanner(System.in);
//
//        operation = sc.nextLine();
//        if(operation.equals("enc")) original_text = sc.nextLine();
//        else encrypted_text = sc.nextLine();
//        shift = sc.nextInt();

        if(operation.equals("enc")){
            encrypted_text = encryptViaShift(original_text, shift);
            System.out.println(encrypted_text);
        }else{
            original_text = decryptViaShift(encrypted_text, shift);
            System.out.println(original_text);
        }

        //String encrypted_text = encrypt(original_text);

    }

    private static String encryptViaShift(String originalText, int key) {     //for all unicode character (total 95)
        StringBuilder encrypted_text = new StringBuilder("");

        for(int i=0; i<originalText.length(); i++){
            char ch = originalText.charAt(i);
            encrypted_text.append((char)(' ' + (originalText.charAt(i) - ' ' + key) % 95));
        }

        return encrypted_text.toString();
    }

    private static String decryptViaShift(String encrypted_text, int key) {    //for all unicode character (total 95)
        StringBuilder original_text = new StringBuilder("");

        for(int i=0; i<encrypted_text.length(); i++){
            char ch = encrypted_text.charAt(i);
            original_text.append((char)(' ' + ((encrypted_text.charAt(i) - ' ' + 95 - key) % 95)));
        }

        return original_text.toString();
    }

    private static String encryptViaShiftAlphabets(String originalText, int key) {   //shifting only for alphabets
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
