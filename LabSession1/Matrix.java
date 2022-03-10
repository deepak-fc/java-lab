import java.io.*;

class Matrix {

    /////////////////////////////////////////////////////////////////////////////
    // Main method to demonstrate class functionality
    /////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rowSize, colSize;
        int[][] firstMatrix, secondMatrix, resultMatrix;

        System.out.print("\nEnter row size: ");
        rowSize = Integer.parseInt(br.readLine());

        System.out.print("Enter column size: ");
        colSize = Integer.parseInt(br.readLine());

        firstMatrix = getUserInputMatrix(rowSize, colSize);
        secondMatrix = getUserInputMatrix(rowSize, colSize);

        displayMatrix(firstMatrix, rowSize, colSize);
        displayMatrix(secondMatrix, rowSize, colSize);

        resultMatrix = addMatrix(firstMatrix, secondMatrix, rowSize, colSize);

        displayMatrix(resultMatrix, rowSize, colSize);
        System.out.println("\n\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayMatrix(int[][] matrix, int rowSize, int colSize) {

        System.out.println("\n------DISPLAY MATRIX------");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static int[][] getUserInputMatrix(int rowSize, int colSize) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix;

        matrix = new int[rowSize][colSize];

        System.out.println("\n-------INPUT MATRIX-------");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print("Enter element [" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = Integer.parseInt(br.readLine());
            }
        }

        return matrix;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static int[][] addMatrix(int[][] firstMatrix, int[][] secondMatrix, int rowSize, int colSize) {

        int[][] resultMatrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return resultMatrix;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}