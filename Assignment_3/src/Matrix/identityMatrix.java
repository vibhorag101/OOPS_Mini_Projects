package Matrix;

import java.util.ArrayList;

public class identityMatrix extends diagonalMatrix{
    identityMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public void printDeterminants(){
        System.out.println("Determinant is "+1);
    }
}
