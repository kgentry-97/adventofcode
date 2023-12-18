import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File myFile = new File("testset.txt");
        Scanner scanner = new Scanner(myFile);
        int total = 0;

        while (scanner.hasNextLine()) {
            List<String> integerList = new ArrayList<>();
            String testLine = scanner.nextLine();
            Pattern digitRegex = Pattern.compile("\\d");
            Matcher digitMatcher = digitRegex.matcher(testLine);
            while (digitMatcher.find()) {
                integerList.add(digitMatcher.group());
            }
            String tempInt = integerList.get(0);
            tempInt += integerList.get(integerList.size() - 1);
            total += Integer.parseInt(tempInt);
        }
        System.out.println("total value is = " + total);
    }
}
