public class GaussSolver {    
    public static double[] gaussSolver(double[][] A, double[] b) {
        for (int k = 0; k < A.length - 1; k++) {
            double max = Math.abs(A[k][k]);
            int maxIndex = k;            
            for (int i = k + 1; i < A.length; i++) {
                if (max < Math.abs(A[i][k])) {
                    max = Math.abs(A[i][k]);
                    maxIndex = i;
                }
            }
            if (maxIndex != k) {
                for (int j = 0; j < A.length; j++) {
                    double temp = A[k][j];
                    A[k][j] = A[maxIndex][j];
                    A[maxIndex][j] = temp;
                }
                double temp = b[k];
                b[k] = b[maxIndex];
                b[maxIndex] = temp;
            }           
            if (A[k][k] == 0) {
                return null;
            } else {
                
                for (int m = k + 1; m < A.length; m++) {
                    double F = -A[m][k] / A[k][k];
                    A[m][k] = 0; 
                    b[m] = b[m] + F * b[k];
                    for (int l = k + 1; l < A.length; l++) {
                        A[m][l] = A[m][l] + F * A[k][l];
                    }
                }
            }
        }
        double[] X = new double[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            X[i] = b[i];
            for (int j = i + 1; j < A.length; j++) {
                X[i] = X[i] - X[j] * A[i][j];
            }
            X[i] = X[i] / A[i][i];
        }
        return X;
    }
    
    public static void main(String args[]) {
        double A[][] = {{2, 1, -1}, {1, 2, 1}, {1, 1, 1}};
        double b[] = {-3, 3, 2};
        double[] x = gaussSolver(A, b);
        System.out.printf("x1 = %f\nx2 = %f\nx3 = %f\n", x[0], x[1], x[2]);

        double A2[][] = {{1, 1, 1}, {-2, 1, 1}, {1, 3, 1}};
        double b2[] = {2, 5, 4};
        x = gaussSolver(A2, b2);
        System.out.printf("\nx1 = %f\nx2 = %f\nx3 = %f\n", x[0], x[1], x[2]);
        
        double A3[][] = {{3, 2, -1}, {2, -2, 4}, {-1, 0.5, -1}};
        double b3[] = {1, -2, 0};
        x = gaussSolver(A3, b3);
        System.out.printf("\nx1 = %f\nx2 = %f\nx3 = %f\n", x[0], x[1], x[2]);
        
        double A4[][] = {{2,3}, {4,9}};
        double b4[] = {6,15};
        x = gaussSolver(A4, b4);
        System.out.printf("\nx1 = %f\nx2 = %f\n", x[0], x[1]);

        double A5[][] = {{4, 1, 2, -3}, {-3, 3, -1, 4}, {-1, 2, 5, 1}, {5, 4, 3, -1}};
        double b5[] = {-16, 20, -4, -10};
        x = gaussSolver(A5, b5);
        System.out.printf("\nx1 = %f\nx2 = %f\nx3 = %f\nx4 = %f\n", x[0], x[1], x[2], x[3]);

        double A6[][] = {{4, 1, 2, -3, 5}, {-3, 3, -1, 4, -2}, {-1, 2, 5, 1, 3}, {5, 4, 3, -1, 2}, {1, -2, 3, -4, 5}};
        double b6[] = {-16, 20, -4, -10, 3};
        x = gaussSolver(A6, b6);
        System.out.printf("\nx1 = %f\nx2 = %f\nx3 = %f\nx4 = %f\nx5 = %f\n", x[0], x[1], x[2], x[3], x[4]);
    }
}
