package Matrix;

import java.util.ArrayList;

public class matrix {
    private final int row;
    private final int column;
    private ArrayList<String> MatrixType;
    private final int id;
    private final ArrayList<ArrayList<Integer>> matrixElements;

    matrix(ArrayList<ArrayList<Integer>> matrixElements, int id) {
        this.matrixElements = matrixElements;
        this.row = matrixElements.size();
        this.column = matrixElements.get(0).size();
        this.id = id;
    }

    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrixElements.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void displayMatrixByList(ArrayList<ArrayList<Integer>> matrixElements) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrixElements.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> getMatrixType() {
        return MatrixType;
    }

    public void setMatrixType(ArrayList<String> matrixType) {
        MatrixType = matrixType;
    }

    public int getId() {
        return id;
    }

    public ArrayList<ArrayList<Integer>> getMatrixElements() {
        return matrixElements;
    }

    // matrix operations with single operand.
    public ArrayList<ArrayList<Integer>> transpose() {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            al.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                al.get(i).add(0);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(j).set(i, matrixElements.get(i).get(j));
            }
        }
        displayMatrixByList(al);
        return al;
    }

    public int getDeterminants() {
        if (row == 1) {
            return (matrixElements.get(0).get(0));
        } else if (row == 2) {
            int temp1 = matrixElements.get(0).get(0) * matrixElements.get(1).get(1);
            int temp2 = matrixElements.get(0).get(1) * matrixElements.get(1).get(0);
            return (temp1 - temp2);
        } else {
            int temp00 = matrixElements.get(0).get(0);
            int temp01 = matrixElements.get(0).get(1);
            int temp02 = matrixElements.get(0).get(2);
            int temp10 = matrixElements.get(1).get(0);
            int temp11 = matrixElements.get(1).get(1);
            int temp12 = matrixElements.get(1).get(2);
            int temp20 = matrixElements.get(2).get(0);
            int temp21 = matrixElements.get(2).get(1);
            int temp22 = matrixElements.get(2).get(2);
            int det = temp00 * (temp11 * temp22 - temp12 * temp21) - temp01 * (temp10 * temp22 - temp12 * temp20) + temp02 * (temp10 * temp21 - temp11 * temp20);
            System.out.println("the determinant of the matrix is " + det);
            return (det);
        }
    }

    public void getRowMean() {
        for (int i = 0; i < row; i++) {
            int mean = 0;
            for (int j = 0; j < column; j++) {
                mean += matrixElements.get(i).get(j);
            }
            mean = mean / row;
            System.out.println("The mean of row " + i + " is " + mean);
        }
    }
    public void getColumnMean() {
        for (int i = 0; i < column; i++) {
            int mean = 0;
            for (int j = 0; j < row; j++) {
                mean += matrixElements.get(i).get(j);
            }
            mean = mean / column;
            System.out.println("The mean of column " + i + " is " + mean);
        }
    }
    public void getMean(){
        int mean =0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mean= mean+ matrixElements.get(i).get(j);
            }
        }
        mean = mean/(row*column);
        System.out.println("The mean of all the elements is "+mean);
    }
    public void addTranspose(){
        ArrayList<ArrayList<Integer>> al = transpose();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(row).set(column,al.get(row).get(column)+ matrixElements.get(row).get(column));
            }
        }
        displayMatrixByList(al);
    }
    public void singletonScalar(matrix m,int flag){
        ArrayList<ArrayList<Integer>> s = m.getMatrixElements();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(matrixElements);
        int scalar = s.get(0).get(0);
        if (flag==0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    al.get(i).set(j, al.get(i).get(j) * 2);
                }
            }
        }
        else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    al.get(i).set(j, al.get(i).get(j)/2);
                }
            }
        }
        displayMatrixByList(al);
    }

    //operations with two arguments
    public void matrixOperate(matrix m, int flag){
        ArrayList<ArrayList<Integer>> secondMat = m.getMatrixElements();
        ArrayList<ArrayList<Integer>> firstMat = new ArrayList<>(matrixElements);
        if (flag==0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) + secondMat.get(i).get(j));
                }
            }
        }
        else if(flag ==1){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j) - secondMat.get(i).get(j));
                }
            }
        }
        else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    firstMat.get(i).set(i, firstMat.get(i).get(j)/secondMat.get(i).get(j));
                }
            }
        }
        displayMatrixByList(firstMat);
    }

}