
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<String> gameID = new ArrayList<>();
        ArrayList<String> colourBlocks = new ArrayList<>();
        ArrayList<String> fullInputArray = new ArrayList<>();
        ArrayList<Boolean> gameIdCheck = new ArrayList<>();

        // Input storage into arraylist
        try {
            Scanner lineRead = new Scanner(System.in).useDelimiter(":");
            File file = new File("C:\\Users\\tonyl\\Documents\\Coding inputs\\input.txt");
            lineRead = new Scanner(file);
            while (lineRead.hasNextLine())
                fullInputArray.add(lineRead.nextLine());
            lineRead.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Separate the game ID and colour blocks
        for(int i = 0; i < fullInputArray.size(); i++){
            int pos = fullInputArray.get(i).indexOf(":");
            gameID.add(fullInputArray.get(i).substring(5,pos));
            colourBlocks.add(fullInputArray.get(i).substring(pos + 2));
            colourBlocks.set(i, colourBlocks.get(i).replaceAll(",",""));
            colourBlocks.set(i, colourBlocks.get(i).replaceAll(";",""));
        }

        int posRed = 0, posGreen = 0, posBlue = 0, numRed = 0, numGreen = 0, numBlue = 0, total = 0;;
        String strRed = "", strBlue = "", strGreen = "";

        for(int j = 0; j < colourBlocks.size(); j++) {
            while(posRed < colourBlocks.get(j).length()) {
                gameIdCheck.add(true);

                posRed = colourBlocks.get(j).indexOf("red", posRed);
                if(posRed >= 0) {
                    if (posRed == 2)
                        posRed -= 2;
                    else
                        posRed -= 3;
                    strRed = colourBlocks.get(j).substring(posRed, posRed + 2);
                    numRed = Integer.parseInt(strRed.replaceAll(" ", ""));

                    //System.out.println(numRed);
                    if(numRed > 12)
                        gameIdCheck.set(j, false);

                    posRed += 6;
                }else{
                    posRed = colourBlocks.get(j).length();
                }
            }
            posRed = 0;

            while(posBlue < colourBlocks.get(j).length()) {
                posBlue = colourBlocks.get(j).indexOf("blue", posBlue);
                if(posBlue >= 0) {
                    if (posBlue == 2)
                        posBlue -= 2;
                    else
                        posBlue -= 3;
                    strBlue = colourBlocks.get(j).substring(posBlue, posBlue + 2);
                    numBlue = Integer.parseInt(strBlue.replaceAll(" ", ""));

                    if(numBlue > 14)
                        gameIdCheck.set(j, false);

                    posBlue += 7;
                }else{
                    posBlue = colourBlocks.get(j).length();
                }
            }
            posBlue = 0;

            while(posGreen < colourBlocks.get(j).length()) {
                posGreen = colourBlocks.get(j).indexOf("green", posGreen);
                if(posGreen >= 0) {
                    if (posGreen == 2)
                        posGreen -= 2;
                    else
                        posGreen -= 3;
                    strGreen = colourBlocks.get(j).substring(posGreen, posGreen + 2);
                    numGreen = Integer.parseInt(strGreen.replaceAll(" ", ""));

                    if(numGreen > 13)
                        gameIdCheck.set(j, false);

                    posGreen += 8;
                }else{
                    posGreen = colourBlocks.get(j).length();
                }
            }
            posGreen = 0;

            if(gameIdCheck.get(j))
                total += Integer.parseInt(gameID.get(j));
        }
        System.out.println(total);
    }
}