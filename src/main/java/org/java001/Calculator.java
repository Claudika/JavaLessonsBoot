package org.java001;

public class  Calculator {
    public static int add(int a,int b){
        System.out.println("Addition of A and B: "+ (a+b));
        return a+b;
}
    public static int sub(int a,int b){
        System.out.println("Substraction of A and B is: "+ a/b);
        return a-b;
}
    public static int div(int a,int b) {
        System.out.println("Division if A and B: " +(a/b) );
        return a/b;
    }
    public static int mult(int a,int b) {
        System.out.println("Multiplication of A and B: " + (a * b));
        return a*b;
    }
    public static int mod(int a,int b) {
        System.out.println("Module of A and B: " + (a % b));
        return a % b;
    }
}
