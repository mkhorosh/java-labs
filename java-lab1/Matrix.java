package com.company;

public class Matrix {
    //    m*n - matrix size
    private int m;
    private int n;
    private Complex[][] matrix;

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public Complex[][] getMatrix() {
        return matrix;
    }

    public Matrix(int m, int n, Complex[][] reference) {
        this.m = m;
        this.n = n;
        matrix = new Complex[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Complex();
                matrix[i][j] = reference[i][j];
            }
        }
    }

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        matrix = new Complex[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Complex();
            }
        }
    }

    public Matrix(Complex[][] reference) {
        this(reference.length, reference[0].length, reference);
    }

    public Matrix() {
        // basic matrix size is 5
        this(5, 5);
    }

    public void readMatrix() {
        System.out.print("\n");
        System.out.println("Enter matrix");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("element[" + i + "][" + j + "]");
                matrix[i][j].readComplex();
            }
        }
    }

    public void printMatrix() {
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j].printComplex();
                    System.out.print("\t");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        } catch (NullPointerException e) {
            throw new NullPointerException("can't print matrix");
        }
    }

    public Matrix multNumber(double number) {
        Complex multiplier = new Complex(number);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j].multComplex(multiplier);
            }
        }
        return this;
    }

    public Matrix addMatrix(Matrix second) {
        if (!(m == second.m && n == second.n)) {
            throw new ArithmeticException("different size matrixes can't be calculated");
        }
        Matrix answer = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer.matrix[i][j] = matrix[i][j].addComplex(second.matrix[i][j]);
            }
        }
        return answer;
    }

    public Matrix subMatrix(Matrix second) {
        return addMatrix(second.multNumber(-1));
    }

    public Matrix multMatrix(Matrix second) {
        if (!(m == second.m && n == second.n)) {
            throw new ArithmeticException("different size matrixes can't be calculated");
        }
        Matrix answer = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer.matrix[i][j] = matrix[i][j].subComplex(second.matrix[i][j]);
            }
        }
        return answer;
    }

    public Matrix transponateMatrix() {
        Matrix answer = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer.matrix[j][i] = matrix[i][j];
            }
        }
        return answer;
    }
}
