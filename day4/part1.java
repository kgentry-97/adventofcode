package com.mypackage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File myFile = new File("testset.txt");
        Scanner scanner = new Scanner(myFile);
        int total = 0;

        while (scanner.hasNextLine()) {
            String testLine = scanner.nextLine();
            Pattern digitRegex = Pattern.compile("(:.*\\|)(.*)");
            Matcher digitMatcher = digitRegex.matcher(testLine);

            while (digitMatcher.find()) {
                String[] winningNums = digitMatcher.group(1).split("\\s+");
                String[] userNums = digitMatcher.group(2).split("\\s+");
                int winningMachtes  = 0;

                for (int i = 1; i < winningNums.length - 1 ; i++) {
                    String winNub = winningNums[i];
                    for (String usrcheck: userNums){
                        if(usrcheck.equals(winNub)){
                            winningMachtes += 1;
                        }
                    }
                }

                if (winningMachtes > 0){
                    int tempTotal = 1;
                   for(int i = 1; i< winningMachtes;i++){
                       tempTotal = tempTotal * 2;
                   }

                   total += tempTotal;
                }
            }
        }

        System.out.println( total);

    }
}
