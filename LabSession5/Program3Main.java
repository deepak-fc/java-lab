import java.io.*;

class Program3Main {
    public static void main(String[] args) throws IOException {

        String filePath = args[0];
        String line;

        int currentLineNumber = 0;

        char input;

        BufferedReader inputTextFileReader = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileReader inputTextFile = null;

        FileWriter evenTextFile = null;
        FileWriter oddTextFile = null;

        System.out.println("\n=>Program started...");
        try {
            inputTextFile = new FileReader(filePath);
            inputTextFileReader = new BufferedReader(inputTextFile);

            if (new File("even.txt").isFile()) {
                System.out.println("\n>File 'even.txt' already exists.");

                while (true) {
                    System.out.print(">Do you want to overwrite it? [y/n]: ");
                    input = (char) br.read();
                    if (input == 'y' || input == 'Y') {
                        evenTextFile = new FileWriter("even.txt");
                        break;
                    } else if (input == 'n' || input == 'N') {
                        evenTextFile = new FileWriter("even.txt", true);
                        break;
                    } else {
                        System.out.println(">Invalid option. Please enter again.");
                    }
                }

            } else {
                System.out.println(">'even.txt' does not exixt. Creating new file...");
                File f = new File("even.txt");
                f.createNewFile();
                evenTextFile = new FileWriter("even.txt");
            }

            if (new File("odd.txt").isFile()) {
                System.out.println(">File 'odd.txt' already exists.");

                while (true) {
                    System.out.println(">Do you want to overwrite it? [y/n]: ");
                    input = (char) br.read();
                    if (input == 'y' || input == 'Y') {
                        oddTextFile = new FileWriter("odd.txt");
                        break;
                    } else if (input == 'n' || input == 'N') {
                        oddTextFile = new FileWriter("odd.txt", true);
                        break;
                    } else {
                        System.out.println(">Invalid option. Please enter again.");
                    }
                }

            } else {
                System.out.println(">'odd.txt' does not exixt. Creating new file...");
                File f = new File("odd.txt");
                f.createNewFile();
                oddTextFile = new FileWriter("odd.txt");
            }

            System.out.println("=> Copying data to respective files...");

            while ((line = inputTextFileReader.readLine()) != null) {
                currentLineNumber++;
                if (currentLineNumber % 2 == 0)
                    evenTextFile.write(line + "\n");
                else
                    oddTextFile.write(line + "\n");
            }
        
            System.out.println("=> Program ended...");
        
        } catch (FileNotFoundException e) {
            System.out.println(">Error. Please provide correct path for 'input.txt'.");
        } finally {
            if (inputTextFileReader != null)
                inputTextFileReader.close();

            if (inputTextFile != null)
                inputTextFile.close();
            
            if(br != null)
                br.close();
            
            if (evenTextFile != null)
                evenTextFile.close();

            if (evenTextFile != null)
                evenTextFile.close();
        }
    }
}