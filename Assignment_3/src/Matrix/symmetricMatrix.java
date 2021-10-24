package Matrix;

import java.util.ArrayList;

public class symmetricMatrix extends matrix{
    symmetricMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public ArrayList<ArrayList<Integer>> transpose() {
        displayMatrixByList(getMatrixElements());
        return(getMatrixElements());
    }
    @Override
    public void addTranspose(){
        ArrayList<ArrayList<Integer>> al = getMatrixElements();
        int row = al.size();
        int column = al.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                al.get(i).set(j,2*al.get(i).get(j));
            }
        }
        displayMatrixByList(al);
    }

}
