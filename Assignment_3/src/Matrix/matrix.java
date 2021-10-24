package Matrix;

import java.util.ArrayList;

public class matrix {
    private final int row;
    private final int column;
    private String MatrixType;
    private final String id;
    private final ArrayList<ArrayList<Integer>> matrixElements;
    matrix(ArrayList<ArrayList<Integer>> matrixElements, String id){
        this.matrixElements= matrixElements;
        this.row = matrixElements.size();
        this.column = matrixElements.get(0).size();
        this.id = id;
    }

    void displayMatrix(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrixElements.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
