package com.company;

import java.util.Scanner;

public class Complex {
    private boolean isAlg;
    //    algebraic parts
    private double re;
    private double im;
    //    trigonometry parts
    private double r;
    private double fi;  // in pi, not radians

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(double re) {
        this(re, 0);
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
        r = 0;
        fi = 0;
        isAlg = true;
    }

    public void toTrig() {
        if (isAlg) {
            isAlg = false;
            r = Math.sqrt(re * re + im * im);
            if (Math.abs(re) < 2 * Double.MIN_VALUE) {  // check if quite close to 0
                throw new ArithmeticException("divided by zero");
            }
            fi = Math.atan(im / re) * 180 / Math.PI;
        }
    }

    public void toAlg() {
        if (!isAlg) {
            isAlg = true;
        }
    }

    public Complex addComplex(Complex second) {
        toAlg();
        second.toAlg();
        return (new Complex(re + second.re, im + second.im));
    }

    public Complex subComplex(Complex second) {
        toAlg();
        second.toAlg();
        return (new Complex(re - second.re, im - second.im));
    }

    public Complex multComplex(Complex second) {
        toAlg();
        second.toAlg();
        double real = re * second.re - im * second.im;
        double imagine = re * second.im + im * second.re;
        return (new Complex(real, imagine));
    }

    private Complex reverseComplex() {
        double tmp = re * re + im * im;
        if (Math.abs(tmp) < 2 * Double.MIN_VALUE) {  // check if quite close to 0
            throw new ArithmeticException("divided by zero");
        }
        return (new Complex(re / tmp, -im / tmp));
    }

    public Complex divComplex(Complex second) {
        return this.multComplex(second.reverseComplex());
    }

    public void printComplex() {
        if (isAlg) {
            if (im > 0) {
                System.out.print(String.format("%.2f", re) + " + " + String.format("%.2f", im) + " i");
            } else if (im < 0) {
                System.out.print(String.format("%.2f", re) + " - " + String.format("%.2f", (-1) * im) + " i");
            } else {
                System.out.print(String.format("%.2f", re));
            }
        } else {
            System.out.print(String.format("%.2f", r) +
                    " * ( cos(" + String.format("%.2f", fi) + ") - sin(" + String.format("%.2f", fi) + ") i )");
        }
    }

    public void readComplex() {
        toAlg();
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("\n");
            System.out.print("Enter real part:");
            re = in.nextDouble();
            System.out.print("Enter imagine part:");
            im = in.nextDouble();
        } catch (Exception error) {
            System.out.println("Input error!");
            System.out.println("Try to use only digits and , instead of . in double format.");
            throw new IllegalArgumentException();
        }
    }
}
