import java.util.Arrays;

public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i : array2d[0]) {
            sum+=i;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int[] rows = new int[array2d.length];
        for (int i = 0; i < array2d.length; i++) {
            for (int j : array2d[i]) {
                rows[i] +=j;
            }
        }
        for (int x : rows) {
            if (x!=checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int[] cols = new int[array2d.length];
        for (int i = 0; i < array2d[0].length; i++) {
            for (int[] j : array2d) {
                cols[i] += j[i];
            }
        }
        for (int x : cols) {
            if (x!=checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int[] diags = new int[2];
        for (int i = 0; i < array2d.length; i++) {
            diags[0] += array2d[i][i];
        }
        for (int i = 0; i < array2d.length; i++) {
            diags[1] += array2d[i][array2d[0].length-i-1];
        }
        for (int x : diags) {
            if (x!=checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        return magicRows(array2d,calculateCheckSum(array2d))&&magicColumns(array2d,calculateCheckSum(array2d))&&magicDiagonals(array2d,calculateCheckSum(array2d));
    }

}
