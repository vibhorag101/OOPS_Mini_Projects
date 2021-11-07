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
    @Override
    public void addMatrix(matrix m){
        displayMatrixByList(m.getMatrixElements());
    }
    @Override
    public void subtractMatrix(matrix m){
        displayMatrixByList(m.getMatrixElements());
    }
    @Override
    public void elementMultiplyMatrix(matrix m){
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int row = m.getMatrixElements().size();
        int column = m.getMatrixElements().get(0).size();
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
}
