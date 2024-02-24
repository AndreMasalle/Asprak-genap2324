package Matrx;

import java.util.ArrayList;

public class MatrixOperation<T extends Number> {
    
    // Metode untuk menambahkan dua matriks
@SuppressWarnings("unchecked")  // Untuk menghilangkan peringatan kompilasi
public Matrix<T> add(Matrix<T> matrixA, Matrix<T> matrixB) {
    if (matrixA.getRows() != matrixB.getRows() || matrixA.getCols() != matrixB.getCols()) {
        throw new IllegalArgumentException("Ukuran matriks tidak sesuai untuk penambahan.");
    }

    ArrayList<ArrayList<T>> resultData = new ArrayList<>();
    for (int i = 0; i < matrixA.getRows(); i++) {
        ArrayList<T> rowData = new ArrayList<>(); // Inisialisasi ArrayList untuk setiap baris hasil
        for (int j = 0; j < matrixA.getCols(); j++) {
            T sum = (T) Double.valueOf(matrixA.getElement(i, j).doubleValue() + matrixB.getElement(i, j).doubleValue());
            rowData.add(sum);  // Menambahkan elemen hasil penambahan ke dalam baris
        }
        resultData.add(rowData);  // Menambahkan baris ke dalam hasil
    }

    return new Matrix<>(resultData); // Membuat dan mengembalikan objek Matrix baru dari hasil penambahan
}

// Metode untuk mengurangkan dua matriks
@SuppressWarnings("unchecked") // Untuk menghilangkan peringatan kompilasi
public Matrix<T> subtract(Matrix<T> matrixA, Matrix<T> matrixB) {
    if (matrixA.getRows() != matrixB.getRows() || matrixA.getCols() != matrixB.getCols()) {
        throw new IllegalArgumentException("Ukuran matriks tidak sesuai untuk pengurangan.");
    }

    ArrayList<ArrayList<T>> resultData = new ArrayList<>();
    for (int i = 0; i < matrixA.getRows(); i++) {
        ArrayList<T> rowData = new ArrayList<>(); // Inisialisasi ArrayList untuk setiap baris hasil
        for (int j = 0; j < matrixA.getCols(); j++) {
            T diff = (T) Double.valueOf(matrixA.getElement(i, j).doubleValue() - matrixB.getElement(i, j).doubleValue()); // Menghitung selisih elemen
            rowData.add(diff);  // Menambahkan elemen hasil pengurangan ke dalam baris
        }
        resultData.add(rowData);  // Menambahkan baris ke dalam hasil
    }

    return new Matrix<>(resultData); // Membuat dan mengembalikan objek Matrix baru dari hasil pengurangan
}

// Metode untuk mengalikan dua matriks
@SuppressWarnings("unchecked")
public Matrix<T> multiply(Matrix<T> matrixA, Matrix<T> matrixB) {
    if (matrixA.getCols() != matrixB.getRows()) {
        throw new IllegalArgumentException("Ukuran matriks tidak sesuai untuk perkalian.");
    }

    ArrayList<ArrayList<T>> resultData = new ArrayList<>();
    for (int i = 0; i < matrixA.getRows(); i++) {
        ArrayList<T> rowData = new ArrayList<>(); // Inisialisasi ArrayList untuk setiap baris hasil
        for (int j = 0; j < matrixB.getCols(); j++) {
            T sum = (T) Double.valueOf(0); // Inisialisasi nilai hasil perkalian untuk setiap elemen
            for (int k = 0; k < matrixA.getCols(); k++) {
                sum = (T) Double.valueOf(sum.doubleValue() + matrixA.getElement(i, k).doubleValue() * matrixB.getElement(k, j).doubleValue()); // Menghitung hasil perkalian dan penambahan
            }
            rowData.add(sum);  // Menambahkan elemen hasil perkalian ke dalam baris
        }
        resultData.add(rowData);  // Menambahkan baris ke dalam hasil
    }

    return new Matrix<>(resultData); // Membuat dan mengembalikan objek Matrix baru dari hasil perkalian
}

// Metode untuk menghitung determinan matriks
public double determinant(Matrix<T> matrix) {
    // Implementasi untuk matriks persegi 2x2 dan 3x3, dapat diperluas untuk ordo yang lebih tinggi
    if (matrix.getRows() != matrix.getCols()) {
        throw new IllegalArgumentException("Determinan hanya dapat dihitung untuk matriks persegi.");
    }

    if (matrix.getRows() == 2 && matrix.getCols() == 2) {
        return (matrix.getElement(0, 0).doubleValue() * matrix.getElement(1, 1).doubleValue()) -
                (matrix.getElement(0, 1).doubleValue() * matrix.getElement(1, 0).doubleValue()); // Menghitung determinan untuk matriks 2x2
    } else if (matrix.getRows() == 3 && matrix.getCols() == 3) {
        return (matrix.getElement(0, 0).doubleValue() * matrix.getElement(1, 1).doubleValue() * matrix.getElement(2, 2).doubleValue()) +
                (matrix.getElement(0, 1).doubleValue() * matrix.getElement(1, 2).doubleValue() * matrix.getElement(2, 0).doubleValue()) +
                (matrix.getElement(0, 2).doubleValue() * matrix.getElement(1, 0).doubleValue() * matrix.getElement(2, 1).doubleValue()) -
                (matrix.getElement(0, 2).doubleValue() * matrix.getElement(1, 1).doubleValue() * matrix.getElement(2, 0).doubleValue()) -
                (matrix.getElement(0, 0).doubleValue() * matrix.getElement(1, 2).doubleValue() * matrix.getElement(2, 1).doubleValue()) -
                (matrix.getElement(0, 1).doubleValue() * matrix.getElement(1, 0).doubleValue() * matrix.getElement(2, 2).doubleValue()); // Menghitung determinan untuk matriks 3x3
    } else {
        throw new UnsupportedOperationException("Determinan matriks ordo lebih tinggi belum diimplementasikan.");
        }
    }

    }
