package Matrix;

import java.util.ArrayList;

public class diagonalMatrix extends matrix{
    private final int matrixSingleElements;
    private final int size;

    diagonalMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
        this.matrixSingleElements = getMatrixElements().get(0).get(0);
        this.size = getMatrixElements().size();
    }
    @Override
    public ArrayList<ArrayList<Integer>> printTranspose() {
        displayMatrixByList(getMatrixElements());
        return(getMatrixElements());
    }
    @Override
    public void addTranspose(){
        ArrayList<ArrayList<Integer>> al = getMatrixElements();
        int row = al.size();
        int column = al.get(0).size();
        for (ArrayList<Integer> integers : al) {
            for (int j = 0; j < column; j++) {
                integers.set(j, 2 * integers.get(j));
            }
        }
        displayMatrixByList(al);
    }

    @Override
    public void printDeterminants(){
        System.out.println("The determinant is "+(Math.pow((double) matrixSingleElements,(double) size)));
    }
}
