package org.perscholas;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args){
        System.out.println("Enter the radius of a circle");
       Scanner scanner = new Scanner(System.in);

       double x = scanner.nextDouble();

       System.out.printf("The radius is %f \n ",  x);

       double area = x * x * 3.14159;

        System.out.printf("The area is %f ",  area);
    }
}
