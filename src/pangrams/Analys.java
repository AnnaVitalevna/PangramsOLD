package pangrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Analys {
    
    private Scanner scan = new Scanner(System.in);
    private String maxString = "";
    private int maxLength = 0;
    
    public void TheAnalysisOfSupply(){
        
        String FileName = "src\\doc\\" + scan.nextLine() + ".txt";
        ArrayList<String> alfabet = new ArrayList<>();

        try{
            FileInputStream stream = new FileInputStream(FileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                if(maxLength<alfabet.size()){
                    maxString = strLine;
                    maxLength = alfabet.size();
                }
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }
    
    public void ComparisonWithPangrams(){
        
        try{
            FileInputStream stream = new FileInputStream("src\\doc\\Pangrams.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            ArrayList<String> alfabet = new ArrayList<>();
            System.out.println("Предложение '" + maxString + "' из Текста существует, с " + maxLength + " уникальных символов.");
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                System.out.println("Панграмма '" + strLine + "' самое большое, с " + alfabet.size() + " уникальных символов." );
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }
}