package network;

import java.util.Arrays;

public class HopfieldNetwork {

	Matrix weightMatrix;
	
	public HopfieldNetwork(int neurons) {
		weightMatrix = new Matrix(neurons,neurons);
	}

	public boolean[] present(final boolean[] pattern){
		final boolean output[] = new boolean[pattern.length];
		final Matrix inputMatrix = Matrix.createRowMatrix(BiPolarUtil.boolean2double(pattern));
		//for each number in the pattern...
		for(int col = 0; col < pattern.length; col++){
			//get the connections form each neuron to the neurons it is connected to...
			Matrix columnMatrix = this.weightMatrix.getCol(col);
//			columnMatrix = MatrixMath.transpose(columnMatrix);
//			System.out.print("Taking dot product of "+columnMatrix+ "and "+inputMatrix);
			final double dotProduct = MatrixMath.dotProduct(inputMatrix, columnMatrix);
//			System.out.println("to get "+dotProduct+"\n");
			if(dotProduct > 0){
				output[col] = true;
			}else{
				output[col] = false;
			}
		}
		return output;
	}
	
	public void train(final boolean[] pattern){
		final double[] bipolar = BiPolarUtil.boolean2double(pattern);
		Matrix p = MatrixMath.multiply(Matrix.createColumnMatrix(bipolar), Matrix.createRowMatrix(bipolar));
//		System.out.println("Multiplying "+Arrays.toString(bipolar)+ " yielded \n"+p);
		final Matrix identity = MatrixMath.identity(p.getHeight());
		weightMatrix = MatrixMath.add(weightMatrix, MatrixMath.subtract(p, identity));
		//set diagonal to zero:
//		for(int i = 0; i < weightMatrix.getHeight(); i++){
//			weightMatrix.set(i, i, 0);
//		}
	}
	
	public Matrix getMatrix(){
		return weightMatrix.clone();
	}
	
	public int getSize(){
		return weightMatrix.getHeight();
	}
	
	public String toString(){
		return weightMatrix.toString();
	}
	
}
