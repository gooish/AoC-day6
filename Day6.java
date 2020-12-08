import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Day6
 */
public class Day6 {

    public static void main(String[] args) {
        String raaka = readFile("data.txt");
        List<String> rivit = Arrays.asList(raaka.split("\n"));
        int montakoYhteensä = 0;

        for (String str : rivit) {
            String allUniques = "";
            int nmbOfPpl = howMany(str, '|');
            str = str.replaceAll("|", "");
            for (char a = 'a'; a <= 'z'; a++) {
                if (howMany(str, a) == nmbOfPpl) {
                    allUniques = allUniques + a;
                }
            }
            montakoYhteensä = montakoYhteensä + allUniques.length();
        }

        System.out.println("combined, the yes answers equal " + montakoYhteensä);

    }




    public static String readFile (String fName) {
        String whereTo = "";
        
        File file = new File(fName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String toAdd = input.nextLine();
                if (toAdd.isBlank()) {
                    whereTo = whereTo + "\n";
                }
                else {
                    whereTo = whereTo + toAdd + "|";
                }
                
            }
            return whereTo; 
        } catch (FileNotFoundException e) {
            System.out.println("file not found!!");
            System.exit(1);
        }
        return whereTo;
    }

    public static int howMany (String countings, char search) {
        int out = 0;
        for (int i = 0; i < countings.length(); i++) {
            if (countings.charAt(i) == search) {
                out++;
            }
        }
        return out;
    }


}