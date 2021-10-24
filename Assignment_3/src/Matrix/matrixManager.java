package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class matrixManager {
    public static ArrayList<matrix> matrixArrayList = new ArrayList<>();
    int counter = 0;

    matrixManager() {
        this.counter = 0;
    }

    public void addMatrix() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of rows of matrix");
        int row = scn.nextInt();
        System.out.println("Enter the number of columns of matrix");
        int column = scn.nextInt();
        ArrayList<ArrayList<Integer>> matrixElements = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < row; i++) {
            matrixElements.add(new ArrayList<>());
        }
        System.out.println("Enter the elements");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = scn.nextInt();
                matrixElements.get(i).add(temp);
            }
        }
        matrix m = new matrix(matrixElements, counter);
        matrixArrayList.add(m);
        m.setMatrixType(findMatrixType(matrixElements));
        counter++;

    }

    public ArrayList<String> findMatrixType(ArrayList<ArrayList<Integer>> matrixElements) {
        ArrayList<String> s = new ArrayList<>();
        int row = matrixElements.size();
        int column = matrixElements.get(0).size();
        boolean allOne = true;
        boolean allZero = true;
        boolean isIdentity = true;
        boolean isScalar = true;
        boolean isDiagonal = true;
        boolean isLowerTriangle = true;
        boolean isUpperTriangle = true;
        boolean isSkewSymmetric = true;
        boolean isSymmetric = true;
        int diagElem = matrixElements.get(0).get(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int matrixElem = matrixElements.get(i).get(j);
                if (i == j) {
                    if (matrixElem != 1) {
                        isIdentity = false;
                    }
                    if (matrixElem != diagElem) {
                        isScalar = false;
                    }
                } else {
                    if (matrixElem != 0) {
                        isIdentity = false;
                        isScalar = false;
                        isDiagonal = false;
                    }
                    if (i > j) {
                        if (matrixElem != 0) {
                            isUpperTriangle = false;
                        }
                    } else {
                        if (matrixElem != 0) {
                            isLowerTriangle = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int matrixElem = matrixElements.get(i).get(j);
                if (i == j) {
                    if (matrixElem != 0) {
                        isSkewSymmetric = false;
                    }
                } else {
                    int checkElem = matrixElements.get(j).get(i);
                    if (checkElem != matrixElem) {
                        isSymmetric = false;
                    }
                    if (checkElem != -1 * matrixElem) {
                        isSkewSymmetric = false;
                    }
                }
            }
        }
        for (ArrayList<Integer> matrixElement : matrixElements) {
            for (int j = 0; j < column; j++) {
                if (matrixElement.get(j) != 1) {
                    allOne = false;
                }
                if (matrixElement.get(j) != 0) {
                    allZero = false;
                }
            }
        }
        if (row != column) {
            if (allOne) {
                s.add("One Matrix");
            }
            if (allZero) {
                s.add("Null Matrix");
            }
            if (row == 1 && column > row) {
                s.add("Row Matrix");
            }
            if (column == 1 && row > column) {
                s.add("Column Matrix");
            }
            s.add("Rectangular Matrix");
        } else {
            if (row == 1) {
                s.add("Singleton Matrix");
            }
            if (allOne) {
                s.add("One Matrix");
            }
            if (allZero) {
                s.add("Null Matrix");
            }
            if (isIdentity) {
                s.add("Identity Matrix");
            }
            if (isScalar) {
                s.add("Scalar Matrix");
            }
            if (isDiagonal) {
                s.add("Diagonal Matrix");
            }
            if (isLowerTriangle) {
                s.add("Lower Triangular Matrix");
            }
            if (isUpperTriangle) {
                s.add("Upper Triangular Matrix");
            }
            if (isSkewSymmetric) {
                s.add("Skew Symmetric Matrix");
            }
            if (isSymmetric) {
                s.add("Symmetric Matrix");
            }
            s.add("Square Matrix");
        }
        return s;
    }

}
