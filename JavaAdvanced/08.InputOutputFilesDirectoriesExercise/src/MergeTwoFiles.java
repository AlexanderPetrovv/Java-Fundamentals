import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputOne = "./resources/inputOne.txt";
        String inputTwo = "./resources/inputTwo.txt";
        String outputMerge = "./resources/outputMergeTwoFiles.txt";

        try (BufferedReader inputOneReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputOne)));
        BufferedReader inputTwoReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputTwo)));
             PrintWriter mergeWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputMerge)))) {
            String line = "";
            while ((line = inputOneReader.readLine()) != null) {
                mergeWriter.println(line);
            }
            while ((line = inputTwoReader.readLine()) != null) {
                mergeWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
