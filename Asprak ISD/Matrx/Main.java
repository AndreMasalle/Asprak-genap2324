package Matrx;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Contoh Penggunaan
        ArrayList<ArrayList<Double>> dataA = new ArrayList<>();
        dataA.add(new ArrayList<>(List.of(1.0, 2.0, 3.0)));
        dataA.add(new ArrayList<>(List.of(4.0, 5.0, 6.0)));
        dataA.add(new ArrayList<>(List.of(7.0, 8.0, 9.0)));
        Matrix<Double> matrixA = new Matrix<>(dataA);

        System.out.println("\nMatrix A: ");
        matrixA.printMatrix();
        

        ArrayList<ArrayList<Double>> dataB = new ArrayList<>();
        dataB.add(new ArrayList<>(List.of(9.0, 8.0, 7.0)));
        dataB.add(new ArrayList<>(List.of(6.0, 5.0, 4.0))); // Menambahkan elemen yang kurang
        dataB.add(new ArrayList<>(List.of(3.0, 2.0, 1.0))); // Menambahkan elemen yang kurang
        Matrix<Double> matrixB = new Matrix<>(dataB);
        System.out.println("\nMatrix B: ");
        matrixB.printMatrix();

        // Operasi Matriks
        MatrixOperation<Double> matrixOperation = new MatrixOperation<>();

        // Penjumlahan Matriks
        Matrix<Double> sumResult = matrixOperation.add(matrixA, matrixB);
        System.out.println("\nHasil Penjumlahan Matriks A dan B:");
        sumResult.printMatrix();

        // Pengurangan Matriks
        Matrix<Double> subtractResult = matrixOperation.subtract(matrixA, matrixB);
        System.out.println("\nHasil Pengurangan Matriks A dan B:");
        subtractResult.printMatrix();

        // Perkalian Matriks
        Matrix<Double> multiplyResult = matrixOperation.multiply(matrixA, matrixB);
        System.out.println("\nHasil Perkalian Matriks A dan B:");
        multiplyResult.printMatrix();

        // Determinan Matriks
        double determinantResult = matrixOperation.determinant(matrixA);
        System.out.println("\nDeterminan Matriks A: " + determinantResult);

    }
}


