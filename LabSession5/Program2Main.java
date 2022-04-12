import java.io.*;

class Program2Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        File f = new File(filePath);

        int numberOfLines = 0;
        int numberOfCharacters = 0;
        int numbersOfWords = 0;

        if (f.isDirectory()) {
            System.out.println(">Invalid argument. Please pass file name instead of directory.");

        } else if (f.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String[] words = {};
            String line;

            while ((line = br.readLine()) != null) {
                numberOfLines++;
                numberOfCharacters += line.length();

                if (!line.isEmpty()) {
                    words = line.trim().split(" ");
                    numbersOfWords += words.length;
                }
            }

            System.out.println("=> Total number of lines: " + numberOfLines);
            System.out.println("=> Total number of characters: " + numberOfCharacters);
            System.out.println("=> Total number of words: " + numbersOfWords);

            br.close();
        } else {
            System.out.println(">Invalid file path. Failed to read.");
        }
    }
}
