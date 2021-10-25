package Matrix;

import java.util.ArrayList;

public class IdentityMatrix extends diagonalMatrix{
    IdentityMatrix(ArrayList<ArrayList<Integer>> matrixElements, int id){
        super(matrixElements,id);
    }
    @Override
    public void printDeterminants(){
        System.out.println("Determinant is "+1);
    }
}
