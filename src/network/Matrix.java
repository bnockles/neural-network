package network;

import java.util.Arrays;

public class Matrix {

	private double[][] matrix;
	
	public static Matrix createRowMatrix(int length){
		return new Matrix(length, 1);
	}
	
	public static Matrix createColumnMatrix(int length){
		return new Matrix(length, 1);
	}
	
	public static Matrix createRowMatrix(final double[] data){
		Matrix row = new Matrix(1, data.length);
		for(int i = 0; i < data.length; i++){
			row.set(0,i,data[i]);
		}
		return row;
	}
	
	public static Matrix createColumnMatrix(final double[] data){
		Matrix col = new Matrix(data.length, 1);
		for(int i = 0; i < data.length; i++){
			col.set(i,0,data[i]);
		}
		return col;
	}
	
	public Matrix(int rows, int cols) {
		matrix = new double[rows][cols];
	}
	
	public Matrix(double[][] values){
		matrix = values;
	}

	public void add(double d){
		for(double[] row: matrix){
			for(int i = 0; i < row.length; i++){
				row[i]+=d;
			}
		}
	}
	
	public void set(int row, int col, double value){
			matrix[row][col]=value;

	}
	
	public int getHeight(){
		return matrix.length;
	}
	
	public int getWidth(){
		return matrix[0].length;
	}
	
	public void clear(){
		for(double[] row: matrix){
			for(int i = 0; i < row.length; i++){
				row[i]=0;
			}
		}
	}
	
	public double get(int row, int col){
		return matrix[row][col];
	}
	
	public Matrix getCol(int col){
		Matrix column = createColumnMatrix(matrix.length);
		
		for(int i = 0; i< matrix.length; i++){
			column.set(i, 0, matrix[i][col]);
		}
		return column;
	}
	
	public Matrix getCols(int colStart, int colEnd){
		Matrix columns = new Matrix(matrix.length, colEnd-colStart+1);
		int column = 0;
		for(int i = colStart; i<= colEnd; i++){
			for(int row = 0; row<matrix.length; row ++){
				columns.set(row, column, matrix[row][i]);
			}
			column++;
		}
		return columns;
	}
	
	public Matrix getRows(int rowStart, int rowEnd){
		Matrix rows = new Matrix(rowEnd - rowStart + 1, matrix[0].length);
		int row = 0;
		for(int i = rowStart; i <= rowEnd; i++){
			for(int j = 0; j< matrix[0].length; j++){
				rows.set(row, j, matrix[i][j]);	
			}
			row++;
		}
		return rows;
	}
	
	public Matrix clone(){
		Matrix m2 = new Matrix(matrix.length, matrix[0].length);
		for(int i = 0; i < matrix.length; i ++){
			for(int j = 0; j < matrix[i].length; j++){
				m2.set(i, j, matrix[i][j]);
			}
		}
		return m2;
	}
	
	public boolean equals(Matrix m, double tolerance){
		if(this.matrix.length != m.getHeight() || this.matrix[0].length != m.getWidth())return false;
		for(int r = 0; r < matrix.length; r++){
			for(int c = 0; c < matrix[0].length; c++){
				if(matrix[r][c] != m.get(r, c))return false;
			}
		}
		return true;
	}
	
	public boolean isVector(){
		return matrix.length == 1 || matrix[0].length ==1;
	}
	
	public boolean isZero(){
		for(double[] row: matrix){
			for(int i = 0; i < row.length; i++){
				if(row[i]!=0) return false;
			}
		}
		return true;
	}
	
	public double sum(){
		double sum = 0.0;
		for(double[] row: matrix){
			for(int i = 0; i < row.length; i++){
				sum += row[i];
			}
		}
		return sum;
	}
	
	public String toString(){
		String s = "";
		for(double[] row : matrix){
			s+= "[";	
			for(int i = 0; i < row.length-1; i ++){
				s+=row[i]+" ";
			}
			s+=row[row.length-1]+"]\n";
		}
		return s;
	}
	
	public double[] toPackedArray(){
		//TODO not sure what this does
		return null;
	}
	
}
