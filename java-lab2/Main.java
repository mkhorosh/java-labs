package com.company;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path of a file:");
        String fileName = in.nextLine();
        // example file path - C:\Users\Marina\my_file.txt
        File file = new File(fileName);
        if(!file.exists()){
            throw new Exception("file do not exist :(");
        }
        if(!file.canRead()){
            throw new Exception("can not read :(");
        }
        Scanner sc = new Scanner(file);
        HashMap<Character, Integer> alphabet = new HashMap<>();
        String all = new String("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
        // create pairs
        for(int i=0;i<all.length();i++){
            alphabet.put(all.charAt(i),0);
        }
        while (sc.hasNextLine()){
            String s = new String(sc.nextLine());
            for(int i=0;i<s.length();i++){
                if(alphabet.containsKey(s.charAt(i))){
                    alphabet.put(s.charAt(i),alphabet.get(s.charAt(i))+1);
                }
            }
        }
        // write results into new file
        String answerPath = "C:\\Users\\Marina\\result.txt";
        File answerFile = new File(answerPath);
        if (!answerFile.exists()) {
            if(!answerFile.createNewFile()){  // create file and check
                throw new Exception("creating is noе successful :(");
            }
        }
        if(!answerFile.canWrite()){
            throw new Exception("can not write :(");
        }
        FileWriter writer = new FileWriter(answerFile.getAbsoluteFile());
        BufferedWriter buffer = new BufferedWriter(writer);
        for (HashMap.Entry<Character, Integer> entry : alphabet.entrySet()) {
            if(entry.getValue()!=0) {  // write if meet the character at least ones
                buffer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        }
        buffer.close();
    }
}
