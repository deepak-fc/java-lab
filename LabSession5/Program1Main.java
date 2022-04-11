import java.io.*;

class Program1Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        File f = new File(filePath);

        if (f.isDirectory()) {
            displayDirectoryContents(filePath);
            System.out.println("\n=> Number of files: " + numberOfFilesInDirectory(filePath));
            displayFileswithExtension(filePath, ".txt");
        } else if (f.isFile()) {
            displayFileAttributes(f);
        } else {
            System.out.println(">Invalid file name or path.");
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayDirectoryContents(String filePath) throws IOException {
        File dir = new File(filePath);
        File[] contents = dir.listFiles();
        System.out.println("\n=> Contents");
        for (File file : contents)
            System.out.println(">" + file.getCanonicalPath());
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static int numberOfFilesInDirectory(String filePath) {
        File dir = new File(filePath);
        File[] contents = dir.listFiles();
        int numberOfFiles = 0;
        for (File file : contents)
            if (file.isFile())
                numberOfFiles++;
        return numberOfFiles;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayFileswithExtension(String filePath, String extension) {
        File dir = new File(filePath);

        FilenameFilter fileFilter = (d, s) -> s.endsWith(extension);
        String[] filteredFilesNames = dir.list(fileFilter);

        System.out.println("\n=> Files with '" + extension + "' extesnion");
        for (String file : filteredFilesNames)
            System.out.println(">" + file);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayFileAttributes(File f) {
        System.out.println("\n=> File attributes");
        System.out.println(">File name: " + f.getName());
        System.out.println(">Path: " + f.getPath());
        System.out.println(">Absolute Path: " + f.getAbsolutePath());
        System.out.println(">Size: " + f.length() + "\n\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}