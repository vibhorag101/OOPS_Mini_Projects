package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int matrixChoose(matrixManager m) {
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
        System.out.println("Enter 14 for solving linear equations");
        System.out.println("Enter 15 to get all matrices of a given label");
        System.out.println("Enter 16 to exit from the program");
        ArrayList<matrix> al = matrixManager.matrixArrayList;
        while (true) {
            System.out.println("Enter your choice");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    m.addMatrix();
                    break;
                case 3:
                    int chosenMatrix = matrixChoose(m);
                    m.changeMatrixElements(al.get(chosenMatrix));
                case 4:
                    al.get(matrixChoose(m)).printMatrixLabelList();
                    break;
                case 5:
                    matrix matrix1 = al.get(matrixChoose(m));
                    matrix matrix2 = al.get(matrixChoose(m));
                    System.out.println("Enter 0 for addition");
                    System.out.println("Enter 1 for subtraction");
                    System.out.println("Enter 2 for multiplication");
                    System.out.println("Enter 3 for division");
                    int choiceforOp = scn.nextInt();
                    if (choiceforOp == 0) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.addMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.addMatrix(matrix1);
                        } else {
                            matrix1.addMatrix(matrix2);
                        }

                    } else if (choiceforOp == 1) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.subtractMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.subtractMatrix(matrix1);
                        } else {
                            matrix1.subtractMatrix(matrix2);
                        }

                    } else if (choiceforOp == 2) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.multiplyMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.multiplyMatrix(matrix1);
                        } else if (matrix1.getMatrixStoreType().equals("Identity Matrix")) {
                            matrix1.multiplyMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Identity Matrix")) {
                            matrix2.multiplyMatrix(matrix1);
                        } else {
                            matrix1.multiplyMatrix(matrix2);
                        }
                    } else if (choiceforOp == 3) {
                        if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            System.out.println("cannot divide by null matrix");
                        }
                        else if (matrix2.getMatrixStoreType().equals("Identity Matrix")){
                            System.out.println("Dividing by Identity Matrix is matrix itself");
                            matrix1.displayMatrix();
                        }
                            else {
                            matrix1.multiplyMatrix(matrix2.getMatrixInverse());
                        }
                    }
                    break;

                case 6:
                    matrix1 = al.get(matrixChoose(m));
                    matrix2 = al.get(matrixChoose(m));
                    System.out.println("Enter 0 for element-wise addition");
                    System.out.println("Enter 1 for element-wise subtraction");
                    System.out.println("Enter 2 for element-wise multiplication");
                    System.out.println("Enter 3 for element wise division");
                    choiceforOp = scn.nextInt();
                    if (choiceforOp == 0) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.addMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.addMatrix(matrix1);
                        } else {
                            matrix1.addMatrix(matrix2);
                        }

                    } else if (choiceforOp == 1) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.subtractMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.subtractMatrix(matrix1);
                        } else {
                            matrix1.subtractMatrix(matrix2);
                        }

                    } else if (choiceforOp == 2) {
                        if (matrix1.getMatrixStoreType().equals("Null Matrix")) {
                            matrix1.elementMultiplyMatrix(matrix2);
                        } else if (matrix2.getMatrixStoreType().equals("Null Matrix")) {
                            matrix2.elementMultiplyMatrix(matrix1);
                        } else {
                            matrix1.elementMultiplyMatrix(matrix2);
                        }
                    }
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
                            break;
                        case 1:
                            al.get(matrixChoose(m)).getColumnMean();
                            break;
                        case 2:
                            al.get(matrixChoose(m)).getMean();
                            break;
                    }
                    break;

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

                case 14:
                    System.out.println("Choose the matrix A");
                    matrix matrixA = al.get(matrixChoose(m));
                    System.out.println("Choose the matrix B with same rows as B");
                    matrix matrixB = al.get(matrixChoose(m));
                    matrixA.solveLinearEquation(matrixB);


                case 15:
                    scn.nextLine();
                    System.out.println("Enter the matrix type label");
                    m.findMatrixWithLabels(scn.nextLine());
                    break;

                case 16:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice");


            }
        }
    }
}
