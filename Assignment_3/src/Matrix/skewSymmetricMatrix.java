package Matrix;

import java.util.ArrayList;

public class skewSymmetricMatrix extends matrix{
    skewSymmetricMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public ArrayList<ArrayList<Integer>> printTranspose() {
        ArrayList<ArrayList<Integer>> al = getMatrixElements();
        int row = al.size();
        int column = al.get(0).size();
        for (ArrayList<Integer> integers : al) {
            for (int j = 0; j < column; j++) {
                integers.set(j, -1 * integers.get(j));
            }
        }
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
                integers.set(j, 0);
            }
        }
        displayMatrixByList(al);
    }

}