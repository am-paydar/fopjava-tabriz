import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int firstMatrixRow, firstMatrixColumn,
                secondMatrixRow, secondMatrixColumn, temp = 0;
        Scanner scanner = new Scanner(System.in);
        firstMatrixRow = scanner.nextInt();
        firstMatrixColumn = scanner.nextInt();
        secondMatrixRow = scanner.nextInt();
        secondMatrixColumn = scanner.nextInt();


        if (firstMatrixRow <= 0 || firstMatrixColumn <= 0
                || secondMatrixRow <= 0 || secondMatrixColumn <= 0) {
            System.out.println("invalid matrix size");
            return;
        }
        if (!(firstMatrixColumn == secondMatrixRow)) {
            System.out.println("impossible to multiply");
            return;
        }

        int[][] firstMatrix = new int[firstMatrixRow][firstMatrixColumn];
        int[][] secondMatrix = new int[secondMatrixRow][secondMatrixColumn];
        int[][] multiplyMatrix = new int[firstMatrixRow][secondMatrixColumn];

        for (int i = 0; i < firstMatrixRow; i++) {
            for (int j = 0; j < firstMatrixColumn; j++) {
                firstMatrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < secondMatrixRow; i++) {
            for (int j = 0; j < secondMatrixColumn; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < firstMatrixRow; i++) {
            for (int j = 0; j < secondMatrixColumn; j++) {
                for (int k = 0; k < firstMatrixColumn; k++) {
                    temp += firstMatrix[i][k] * secondMatrix[k][j];
                }
                multiplyMatrix[i][j] = temp;
                temp = 0;
            }

        }
        for (int i = 0; i < firstMatrixRow; i++) {
            for (int j = 0; j < secondMatrixColumn; j++) {
                System.out.print(multiplyMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}

