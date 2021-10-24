package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class matrixManager {
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
        String matrixType = findMatrixType(matrixElements);
    }

    public String findMatrixType(ArrayList<ArrayList<Integer>> matrixElements) {
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
                if (i==j){
                    if (matrixElem!=1){
                        isIdentity = false;
                    }
                    if (matrixElem != diagElem){
                        isScalar= false;
                    }
                }
                else{
                    if (matrixElem!=0){
                        isIdentity= false;
                        isScalar=false;
                        isDiagonal = false;
                    }
                    if (i>j){
                        if (matrixElem !=0){
                            isUpperTriangle= false;
                        }
                    }
                    else{
                        if (matrixElem !=0){
                            isLowerTriangle = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int matrixElem = matrixElements.get(i).get(j);
                if (i==j){
                    if (matrixElem!= 0){
                        isSkewSymmetric = false;
                    }
                }
                else{
                    int checkElem = matrixElements.get(j).get(i);
                    if (checkElem != matrixElem){
                        isSymmetric = false;
                    }
                    if (checkElem != -1*matrixElem){
                        isSkewSymmetric=false;
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
                return ("One Matrix");
            } else if (allZero) {
                return ("Null Matrix");
            } else if (row == 1 && column > row) {
                return ("Row Matrix");
            } else if (column == 1 && row > column) {
                return ("Column Matrix");
            } else {
                return ("Rectangular Matrix");
            }
        } else {
            if (row == 1) {
                return ("Singleton Matrix");
            } else if (allOne) {
                return ("One Matrix");
            } else if (allZero) {
                return ("Null Matrix");
            } else if (isIdentity){
                return("Identity Matrix");
            }
            else if(isScalar){
                return("Scalar Matrix");
            }
            else if (isDiagonal){
                return ("Diagonal Matrix");
            }
            else if(isLowerTriangle){
                return("Lower Triangular Matrix");
            }
            else if(isUpperTriangle){
                return ("Upper Triangular Matrix");
            }
            else if(isSkewSymmetric){
                return("Skew Symmetric Matrix");
            }
            else if (isSymmetric){
                return("Symmetric Matrix");
            }
            else{
                return("Square Matrix");
            }
        }

    }
}
