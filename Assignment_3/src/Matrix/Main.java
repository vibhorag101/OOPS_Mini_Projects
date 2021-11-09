package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("Enter 2 for creating a matrix default");
        System.out.println("Enter 3 for changing the matrix elements");
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

                case 2:
                    System.out.println("Enter 1 for Rectangular Matrix");
                    System.out.println("Enter 2 for Row Matrix");
                    System.out.println("Enter 3 for Column Matrix");
                    System.out.println("Enter 4 for Sqaure Matrix");
                    System.out.println("Enter 5 for Symmetric Matrix");
                    System.out.println("Enter 6 for Skew-Symmetric Matrix");
                    System.out.println("Enter 7 for Upper Triangular ");
                    System.out.println("Enter 8 for lower Triangular Matrix");
                    System.out.println("Enter 9 for singular matrix");
                    System.out.println("Enter 10 for Diagonal Matrix");
                    System.out.println("Enter 11 for Scalar Matrix");
                    System.out.println("Enter 12 for Identity Matrix");
                    System.out.println("Enter 13 for Singleton Matrix");
                    System.out.println("Enter 14 for one matrix");
                    System.out.println("Enter 15 for Null Matrix");
                    int choice1 = scn.nextInt();
                    switch (choice1) {
                        case 1:
                            ArrayList<ArrayList<Integer>> temp1 = new ArrayList<>();
                            temp1.add(new ArrayList<>());
                            temp1.add(new ArrayList<>());
                            temp1.get(0).add(1);
                            temp1.get(0).add(2);
                            temp1.get(0).add(3);
                            temp1.get(1).add(4);
                            temp1.get(1).add(5);
                            temp1.get(1).add(6);

                            m.addMatrixFromList(temp1);
                            break;

                        case 2:
                            ArrayList<ArrayList<Integer>> temp2 = new ArrayList<>();
                            temp2.add(new ArrayList<>());
                            temp2.get(0).add(1);
                            temp2.get(0).add(2);
                            temp2.get(0).add(3);
                            m.addMatrixFromList(temp2);
                            break;

                        case 3:
                            ArrayList<ArrayList<Integer>> temp3 = new ArrayList<>();
                            temp3.add(new ArrayList<>());
                            temp3.add(new ArrayList<>());
                            temp3.add(new ArrayList<>());
                            temp3.get(0).add(1);
                            temp3.get(1).add(2);
                            temp3.get(2).add(3);
                            m.addMatrixFromList(temp3);
                            break;

                        case 4:
                            ArrayList<ArrayList<Integer>> temp4 = new ArrayList<>();
                            temp4.add(new ArrayList<>());
                            temp4.add(new ArrayList<>());
                            temp4.get(0).add(1);
                            temp4.get(0).add(2);
                            temp4.get(1).add(3);
                            temp4.get(1).add(4);
                            m.addMatrixFromList(temp4);
                            break;

                        case 5:
                            ArrayList<ArrayList<Integer>> temp5 = new ArrayList<>();
                            temp5.add(new ArrayList<>());
                            temp5.add(new ArrayList<>());
                            temp5.get(0).add(1);
                            temp5.get(0).add(2);
                            temp5.get(1).add(2);
                            temp5.get(1).add(10);
                            m.addMatrixFromList(temp5);
                            break;

                        case 6:
                            ArrayList<ArrayList<Integer>> temp6 = new ArrayList<>();
                            temp6.add(new ArrayList<>());
                            temp6.add(new ArrayList<>());
                            temp6.get(0).add(0);
                            temp6.get(0).add(2);
                            temp6.get(1).add(-2);
                            temp6.get(1).add(0);
                            m.addMatrixFromList(temp6);
                            break;

                        case 7:
                            ArrayList<ArrayList<Integer>> temp7 = new ArrayList<>();
                            temp7.add(new ArrayList<>());
                            temp7.add(new ArrayList<>());
                            temp7.get(0).add(3);
                            temp7.get(0).add(2);
                            temp7.get(1).add(0);
                            temp7.get(1).add(4);
                            m.addMatrixFromList(temp7);
                            break;

                        case 8:
                            ArrayList<ArrayList<Integer>> temp8 = new ArrayList<>();
                            temp8.add(new ArrayList<>());
                            temp8.add(new ArrayList<>());
                            temp8.get(0).add(3);
                            temp8.get(0).add(0);
                            temp8.get(1).add(2);
                            temp8.get(1).add(4);
                            m.addMatrixFromList(temp8);
                            break;
                        case 9:
                            ArrayList<ArrayList<Integer>> temp9 = new ArrayList<>();
                            temp9.add(new ArrayList<>());
                            temp9.add(new ArrayList<>());
                            temp9.get(0).add(2);
                            temp9.get(0).add(3);
                            temp9.get(1).add(4);
                            temp9.get(1).add(6);
                            m.addMatrixFromList(temp9);
                            break;

                        case 10:
                            ArrayList<ArrayList<Integer>> temp10 = new ArrayList<>();
                            temp10.add(new ArrayList<>());
                            temp10.add(new ArrayList<>());
                            temp10.get(0).add(2);
                            temp10.get(0).add(0);
                            temp10.get(1).add(0);
                            temp10.get(1).add(3);
                            m.addMatrixFromList(temp10);
                            break;

                        case 11:
                            ArrayList<ArrayList<Integer>> temp11 = new ArrayList<>();
                            temp11.add(new ArrayList<>());
                            temp11.add(new ArrayList<>());
                            temp11.get(0).add(6);
                            temp11.get(0).add(0);
                            temp11.get(1).add(0);
                            temp11.get(1).add(6);
                            m.addMatrixFromList(temp11);
                            break;

                        case 12:
                            ArrayList<ArrayList<Integer>> temp12 = new ArrayList<>();
                            temp12.add(new ArrayList<>());
                            temp12.add(new ArrayList<>());
                            temp12.get(0).add(1);
                            temp12.get(0).add(0);
                            temp12.get(1).add(0);
                            temp12.get(1).add(1);
                            m.addMatrixFromList(temp12);
                            break;

                        case 13:
                            ArrayList<ArrayList<Integer>> temp13 = new ArrayList<>();
                            temp13.add(new ArrayList<>());
                            temp13.get(0).add(5);
                            m.addMatrixFromList(temp13);
                            break;

                        case 14:
                            ArrayList<ArrayList<Integer>> temp14 = new ArrayList<>();
                            temp14.add(new ArrayList<>());
                            temp14.add(new ArrayList<>());
                            temp14.get(0).add(1);
                            temp14.get(0).add(1);
                            temp14.get(1).add(1);
                            temp14.get(1).add(1);
                            m.addMatrixFromList(temp14);
                            break;

                        case 15:
                            ArrayList<ArrayList<Integer>> temp15 = new ArrayList<>();
                            temp15.add(new ArrayList<>());
                            temp15.add(new ArrayList<>());
                            temp15.get(0).add(0);
                            temp15.get(0).add(0);
                            temp15.get(1).add(0);
                            temp15.get(1).add(0);
                            m.addMatrixFromList(temp15);
                            break;

                    }

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
                        } else if (matrix2.getMatrixStoreType().equals("Identity Matrix")) {
                            System.out.println("Dividing by Identity Matrix is matrix itself");
                            matrix1.displayMatrix();
                        } else {
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

                case 13:
                    al.get(matrixChoose(m)).findEigen();
                    break;
                case 14:
                    System.out.println("Choose the matrix A");
                    matrix matrixA = al.get(matrixChoose(m));
                    System.out.println("Choose the matrix B with same rows as B");
                    matrix matrixB = al.get(matrixChoose(m));
                    matrixA.solveLinearEquation(matrixB);


                case 15:
                    System.out.println("Enter 1 for Rectangular Matrix");
                    System.out.println("Enter 2 for Row Matrix");
                    System.out.println("Enter 3 for Column Matrix");
                    System.out.println("Enter 4 for Sqaure Matrix");
                    System.out.println("Enter 5 for Symmetric Matrix");
                    System.out.println("Enter 6 for Skew-Symmetric Matrix");
                    System.out.println("Enter 7 for Upper Triangular ");
                    System.out.println("Enter 8 for lower Triangular Matrix");
                    System.out.println("Enter 9 for singular matrix");
                    System.out.println("Enter 10 for Diagonal Matrix");
                    System.out.println("Enter 11 for Scalar Matrix");
                    System.out.println("Enter 12 for Identity Matrix");
                    System.out.println("Enter 13 for Singleton Matrix");
                    System.out.println("Enter 14 for one matrix");
                    System.out.println("Enter 15 for Null Matrix");
                    int choice15 = scn.nextInt();
                    switch (choice15) {
                        case 1:
                            m.findMatrixWithLabels("Rectangular Matrix");
                            break;

                        case 2:
                            m.findMatrixWithLabels("Row Matrix");
                            break;

                        case 3:
                            m.findMatrixWithLabels("Column Matrix");
                            break;

                        case 4:
                            m.findMatrixWithLabels("Square Matrix");
                            break;

                        case 5:
                            m.findMatrixWithLabels("Symmetric Matrix");
                            break;

                        case 6:
                            m.findMatrixWithLabels("Skew Symmetric Matrix");
                            break;

                        case 7:
                            m.findMatrixWithLabels("Upper Triangular Matrix");
                            break;

                        case 8:
                            m.findMatrixWithLabels("Lower Triangular Matrix");
                            break;
                        case 9:
                            m.findMatrixWithLabels("Singular Matrix");
                            break;

                        case 10:
                            m.findMatrixWithLabels("Diagonal Matrix");
                            break;

                        case 11:
                            m.findMatrixWithLabels("Scalar Matrix");
                            break;

                        case 12:
                            m.findMatrixWithLabels("Identity Matrix");
                            break;

                        case 13:
                            m.findMatrixWithLabels("Singleton Matrix");
                            break;

                        case 14:
                            m.findMatrixWithLabels("One Matrix");
                            break;

                        case 15:
                            m.findMatrixWithLabels("Null Matrix");
                            break;
                    }
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
