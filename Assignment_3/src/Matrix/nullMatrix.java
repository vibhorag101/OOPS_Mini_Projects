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
    public void printMatrixInverse(){
        System.out.println("The inverse doesn't exist");
    }
}
