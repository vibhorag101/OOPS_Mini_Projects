package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int matrixChoose(matrixManager m){
        Scanner scn = new Scanner(System.in);
        m.displayMatrixList();
        System.out.println("Enter your matrix choice");
        return scn.nextInt();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        matrixManager m = new matrixManager();
        System.out.println("Enter 1 for adding a matrix");
        System.out.println("Enter 4 for getting the matrix labels");
        System.out.println("Enter 5 for addition, subtraction and multiplication");
        System.out.println("Enter 6 for element wise operations");
        System.out.println("Enter 7 for transpose");
        System.out.println("Enter 8 for inverse");
        System.out.println("Enter 9 for computing the means");
        System.out.println("Enter 10 for computing determinant");
        System.out.println("Enter 11 for singleton matrix as scalar");
        System.out.println("Enter 12 A+A transpose");
        System.out.println("Enter 13 for eigen vectors and values");
        System.out.println("Enter 14 for soling linear equations");
        System.out.println("Enter 15 to get all matrices of a given label");
        System.out.println("Enter 16 from the program");
        ArrayList<matrix> al = matrixManager.matrixArrayList;
        while (true){
            System.out.println("Enter your choice");
            int choice = scn.nextInt();
            switch (choice){
                case 1:
                    m.addMatrix();
                    break;
                case 4:
                    al.get(matrixChoose(m)).printMatrixLabelList();
                    break;
                case 5:
                    m.displayMatrixList();
                    System.out.println("Enter first matrix");
                    break;

                case 7:
                    al.get(matrixChoose(m)).printTranspose();
                    break;

                case 8:
                    al.get(matrixChoose(m)).printMatrixInverse();
                    break;

                case 9:
                    System.out.println("Enter 0 for row wise mean");
                    System.out.println("Enter 1 for column wise mean");
                    System.out.println("Enter 2 for mean of all elements");
                    int meanChoice = scn.nextInt();
                    switch (meanChoice) {
                        case 0:
                            al.get(matrixChoose(m)).getRowMean();
                        case 1:
                            al.get(matrixChoose(m)).getColumnMean();
                        case 2:
                            al.get(matrixChoose(m)).getMean();
                    }

                case 10:
                    al.get(matrixChoose(m)).printDeterminants();
                    break;
                case 11:
                    int firstMatrix = matrixChoose(m);
                    System.out.println("Choose the singleton matrix");
                    int secondMatrix = matrixChoose(m);
                    System.out.println("Enter 0 for multiply");
                    System.out.println("Enter 1 for division");
                    int singletonChoice = scn.nextInt();
                    al.get(firstMatrix).singletonScalar(al.get(secondMatrix), singletonChoice);
                    break;

                case 12:
                    al.get(matrixChoose(m)).addTranspose();
                    break;

                case 15:
                    System.out.println("Enter the matrix type label");
                    m.matrixWithLabels(scn.next());
                    break;

                case 16:
                    break;



            }
        }
    }
}
