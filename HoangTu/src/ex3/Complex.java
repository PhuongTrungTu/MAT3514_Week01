package ex3;

import java.util.List;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex other){
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex multiple(Complex other){
        return new Complex(this.real * other.real - this.imaginary * other.imaginary,
                           this.real * other.imaginary + this.imaginary * other.real);
    }

    public Complex sum(List<Complex> complexes){
        Complex result = new Complex(real, imaginary);
        for (Complex complex : complexes) {
            result = result.add(complex);
        }
        return result;
    }

    public Complex product(List<Complex> complexes){
        Complex result = new Complex(real, imaginary);
        for (Complex complex : complexes) {
            result = result.multiple(complex);
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if (real != 0){
            result.append(real).append(" ");
        }
        if (imaginary < 0){
            result.append("- ");
        } else if (imaginary > 0 && real != 0){
            result.append("+ ");
        }

        if (imaginary != 1 && imaginary != 0 && imaginary != -1){
            result.append(Math.abs(imaginary));
        }
        if (imaginary != 0){
            result.append("i");
        }

        return result.toString();
    }
    public static void main(String[] args) {
        Complex complex1 = new Complex(1,-1);
        System.out.println("ex3.Complex 1: " + complex1);
        Complex complex2 = new Complex(2,3);
        System.out.println("ex3.Complex 2: " + complex2);

        System.out.println("Sum of two complex: " + complex1.add(complex2));
        System.out.println("Product of two complex: " + complex1.multiple(complex2));
    }
}
