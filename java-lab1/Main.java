package com.company;

public class Main {
    public static void main(String[] args) {
        // Complex demo
        Complex n0 = new Complex();
        n0.readComplex();
        Complex n1 = new Complex(1.3, 4.27);
        Complex n2 = new Complex(3);
        n1.addComplex(n2).printComplex();
        n2.subComplex(n1).printComplex();
        Complex n3 = new Complex();
        n3 = n1.subComplex(n2);
        n3.toTrig();
        n3.printComplex();
        n2.divComplex(n1).printComplex();

        // Matrix demo
        Complex[][] nn = new Complex[1][2];
        nn[0][0] = n1;
        nn[0][1] = n2;
        Matrix m0 = new Matrix(nn);
        Matrix m1 = new Matrix(2, 2);
        m1.readMatrix();
        Matrix m2 = new Matrix(2, 2);
        m2.readMatrix();
        m1.addMatrix(m2).printMatrix();
        m2.multNumber(2).printMatrix();
        m1.multMatrix(m2).printMatrix();
        m1.subMatrix(m2.transponateMatrix()).printMatrix();
    }
}
