import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] sudokuTable = new int[9][9];

    static boolean checkSquare(int row, int column, int value) {
        int verticalNumber = row / 3;
        int horizontalNumber = column / 3;
        int hi, hj;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hi = verticalNumber * 3 + i;
                hj = horizontalNumber * 3 + j;
                if (hi != row && hj != column && sudokuTable[hi][hj] == value) {
                    return false;
                }

            }
        }
        return true;
    }

    static boolean checkColumn(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (i != row && sudokuTable[i][column] == value) {
                return false;
            }

        }
        return true;
    }

    static boolean checkRow(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (i != column && sudokuTable[row][i] == value) {
                return false;
            }

        }
        return true;
    }

    static boolean checkNumberRepetition(int row, int column, int value) {
        System.out.println(Arrays.deepToString(sudokuTable));
        System.out.println(checkRow(row, column, value) + " " + checkColumn(row, column, value)
                + checkSquare(row, column, value));
        if (checkRow(row, column, value) && checkColumn(row, column, value)
                && checkSquare(row, column, value)) {
            return true;

        }
        return false;


    }

    static boolean sudokuSolved(int row, int column) {
        for (int i = row; i < 9; i++) {
            for (int j = column; j < 9; j++) {
                if (sudokuTable[i][j] == 0) {
                    System.out.println("i: " + i + "j: " + j);

                    for (int k = 1; k <= 9; k++) {
                        sudokuTable[i][j] = k;


                        if (checkNumberRepetition(i, j, k) && sudokuSolved(i, j)) {
                            return true;
                        }
                        sudokuTable[i][j] = 0;

                    }
                    return false;
                }


            }
            column = 0;


        }
        return true;

    }

    public static void main(String[] args) {
        int n, row, column, value;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            row = scanner.nextInt();
            column = scanner.nextInt();
            value = scanner.nextInt();
            sudokuTable[row][column] = value;
        }
        System.out.println(Arrays.deepToString(sudokuTable));
        System.out.println("------------------------------");
        sudokuSolved(0, 0);
        System.out.println("------------------------------");
        System.out.println(Arrays.deepToString(sudokuTable));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuTable[i][j] + " ");

            }
            System.out.println();
        }


    }

}

