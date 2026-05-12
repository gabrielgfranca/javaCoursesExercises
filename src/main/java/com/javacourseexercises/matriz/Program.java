package com.javacourseexercises.matriz;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public void program() {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();
        sc.nextLine();

        int[][] matriz = new int[rows][columns];

        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Enter the value for position [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
                sc.nextLine();
            }
        }

        System.out.println();

        for (int i = 0; i < matriz.length; i++) {  
            for (int j = 0; j < matriz[i].length; j++) {  
                System.out.print(matriz[i][j] + " ");  
            }  
            System.out.println();  
        }

        System.out.println();

        System.out.print("Type a number of the matrix: ");
        int number = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < matriz.length; i++) {  
            for (int j = 0; j < matriz[i].length; j++) {  
                if (matriz[i][j] == number) {
                    System.out.println("Position: (" + i + ", " + j + ")");

                    Integer left  = j > 0                      ? matriz[i][j - 1] : null;
                    Integer right = j < matriz[i].length - 1   ? matriz[i][j + 1] : null;
                    Integer up    = i > 0                      ? matriz[i - 1][j] : null;
                    Integer down  = i < matriz.length - 1      ? matriz[i + 1][j] : null;

                    System.out.println("Left: "  + left);
                    System.out.println("Right: " + right);
                    System.out.println("Up: "    + up);
                    System.out.println("Down: "  + down);
                }
            }
        }

        sc.close();
    }
}
