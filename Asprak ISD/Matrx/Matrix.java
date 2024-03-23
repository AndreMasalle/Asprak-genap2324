package Matrx;

import java.util.ArrayList;

public class Matrix<T> {
    private ArrayList<ArrayList<T>> data;
    private int rows;
    private int cols;

    // Konstruktor untuk membuat matriks
    public Matrix(ArrayList<ArrayList<T>> data) {
        this.data = data;
        this.rows = data.size();
        this.cols = data.get(0).size();
    }

    public ArrayList<ArrayList<T>> getData() {
        return data;
    }

    // Getter untuk mendapatkan elemen matriks pada baris dan kolom tertentu
    public T getElement(int row, int col) {
        return data.get(row).get(col);
    }

    // Getter untuk mendapatkan jumlah baris
    public int getRows() {
        return rows;
    }

    // Getter untuk mendapatkan jumlah kolom
    public int getCols() {
        return cols;
    }

    // Metode untuk menampilkan matriks
    public void printMatrix() {
        for (ArrayList<T> row : data) {
            for (T element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

