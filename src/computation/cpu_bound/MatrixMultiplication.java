package computation.cpu_bound;

public class MatrixMultiplication {

    // Multiply two square matrices of size n x n
    public static double[][] multiply(double[][] a, double[][] b) {
        int n = a.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Generate a random square matrix
    public static double[][] generateMatrix(int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.random();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int size = 500; // Adjust for heavier CPU load
        double[][] matrixA = generateMatrix(size);
        double[][] matrixB = generateMatrix(size);

        long startTime = System.currentTimeMillis();
        double[][] product = multiply(matrixA, matrixB);
        long endTime = System.currentTimeMillis();

        System.out.println("Matrix multiplication completed in " + (endTime - startTime) + " ms");

        long maxHeap = Runtime.getRuntime().maxMemory();
        System.out.println("Max JVM heap: " + (maxHeap / (1024 * 1024)) + " MB");
    }
}