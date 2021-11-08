package Matrix;

import java.util.ArrayList;

public class nullMatrix extends identityMatrix {
    nullMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id) {
        super(matrixElements, id);
    }

    @Override
    public void printDeterminants() {
        System.out.println("Determinant is " + 0);
    }

    @Override
    public void printMatrixInverse() {
        System.out.println("The inverse doesn't exist");
    }

    @Override
    public void addMatrix(matrix m) {
        displayMatrixByList(m.getMatrixElements());
    }

    @Override
    public void subtractMatrix(matrix m) {
        displayMatrixByList(m.getMatrixElements());
    }

    @Override
    public void elementMultiplyMatrix(matrix m) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int row = m.getRow();
        int column = m.getColumn();
        for (int i = 0; i < row; i++) {
            al.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(i).add(0);
            }
        }
        displayMatrixByList(al);

    }

    @Override
    public void multiplyMatrix(matrix m) {
        if (getColumn() == m.getRow() && getRow() == m.getColumn()) {
            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            int row = m.getRow();
            int column = m.getColumn();
            for (int i = 0; i < row; i++) {
                al.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    al.get(i).add(0);
                }
            }
            displayMatrixByList(al);
        } else {
            System.out.println("The matrix cannot be multiplied");
        }

    }

    @Override
    public void getRowMean() {
        System.out.println("The mean of all row's elements is " + 0);
    }

    @Override
    public void getColumnMean() {
        System.out.println("The mean of all column's the elements is " + 0);
    }

    @Override
    public void getMean() {
        System.out.println("The mean of all elements is " + 0);
    }

}
