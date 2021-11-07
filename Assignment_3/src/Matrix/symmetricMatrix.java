package Matrix;

import java.util.ArrayList;

public class symmetricMatrix extends matrix{
    symmetricMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
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

}
