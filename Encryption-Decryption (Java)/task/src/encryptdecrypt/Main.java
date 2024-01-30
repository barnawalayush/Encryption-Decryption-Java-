package encryptdecrypt;

import ShitingAlgorithms.Shifting;
import ShitingAlgorithms.ShiftingFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    final static String mapping = "zyxwvutsrqponmlkjihgfedcba";

    public static void main(String[] args) {

        String input_file = "";   // file from which we take input for (-in)
        String output_file = "";  // file to which we write text finally to (-out)
        String encrypted_text = "";
        String original_text = "";
        String operation = "enc";  //enc if we want to encrypt data,  dec if we want to decrypt data
        String algo_selected = "shift";  // algo name either shift or unicode
        int key = 0;

        boolean has_data = false;     // to check arguments have data or not
        boolean has_in_file = false;  // to check file from where we have to take data is given
        boolean has_out_file = false; // to check file to  which we have to print output data is given

        // Taking -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode as input command line arguments
        String data = "";
        for(int i=0; i<args.length; i=i+2){
            if(args[i].equals("-mode")){
                operation = args[i+1];
            }else if(args[i].equals("-key")){
                key = Integer.parseInt(args[i+1]);
            }else if(args[i].equals("-data")){
                data = args[i+1];
                has_data = true;
            }else if(args[i].equals("-in")){
                input_file = args[i+1];
                has_in_file = true;
            }else if(args[i].equals("-out")){
                output_file = args[i+1];
                has_out_file = true;
            }else if(args[i].equals("-alg")){
                algo_selected = args[i+1];
            }
        }

        /**
         * If there is no -out argument, the program must print -data argument to the standard output;
         * If there are both -data and -in arguments, your program should prefer -data over -in.
         */
        if(has_in_file){
            data = takeInputFromFile(input_file);
        }


        // Creating instance of ShiftingFactory class
        ShiftingFactory shiftingFactory = new ShiftingFactory();
        Shifting shifting = shiftingFactory.newInstance(algo_selected, data, key);

        if(operation.equals("enc")){
            encrypted_text = shifting.encryptViaShift(data, key);
            if(!has_out_file)System.out.println(encrypted_text);
            else{
                writeToFile(output_file, encrypted_text);
            }
        }else{
            original_text = shifting.decryptViaShift(data, key);
            if(!has_out_file)System.out.println(original_text);
            else writeToFile(output_file, original_text);
        }

    }


    // To write the encrypted or decrypted text to some file having path outputFile
    private static void writeToFile(String outputFile, String text) {
        File file = new File(outputFile);
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    // To copy the encrypted or decrypted text from file having path inputFile
    private static String takeInputFromFile(String inputFile) {

        String text = "";

        File file = new File(inputFile);
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNext()){
                text += sc.nextLine();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

        return text;
    }


    // a->z, b->y, c->x, d->w so on.... for all 26 alphabets
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
