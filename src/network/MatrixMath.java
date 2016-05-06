package network;

public class MatrixMath {

	public static void multiplyScalar(Matrix m, double scalar){
		for(int r = 0; r < m.getHeight(); r++){
			for(int c = 0; c < m.getWidth(); c++){
				m.set(r, c, scalar*m.get(r, c));
			}
		}
	}

	public static void divide(Matrix m, double scalar){
		multiplyScalar(m, 1/scalar);
	}

	public static Matrix add(Matrix m1, Matrix m2){
		return addSubtract(m1, m2, 1);
	}

	public static Matrix subtract(Matrix m1, Matrix m2){
		return addSubtract(m1, m2, -1);
	}

	public static Matrix addSubtract(Matrix m1, Matrix m2, double posOrNeg){
		int rows = m1.getHeight();
		int cols = m1.getWidth();
		if(rows == m2.getHeight() && cols == m2.getWidth()){
			Matrix sum = new Matrix(rows, cols);
			for(int r = 0; r < rows; r++){
				for(int c = 0; c < cols; c++){
					sum.set(r, c, m1.get(r, c)+posOrNeg*m2.get(r, c));
				}
			}
			return sum;	
		}else return null;
	}


	public static Matrix transpose(Matrix m){
		Matrix transposed = new Matrix(m.getWidth(), m.getHeight());
		for(int i =m.getHeight()-1; i >=0; i--){
			for(int j = 0 ; j < m.getWidth(); j++){
				transposed.set(j, i, m.get(i, j));
			}
		}
		return transposed;
	}

	public double vectorLength(Matrix m){
		if(m.isVector()){
			double l = 0.0;
			//TODO write equation for vector length
			if(m.getWidth()==1 && m.getHeight() ==1)return m.get(0, 0);
			else if(m.getWidth() ==1){
				for(int row = 0; row < m.getHeight(); row++){
					l+=Math.pow(m.get(row, 0),2);
				}
				return Math.sqrt(l);
			}else{
				for(int col = 0; col < m.getWidth(); col++){
					l+=Math.pow(m.get(0, col),2);
				}
				return Math.sqrt(l);
			}
		}else return -1.0;
	}

	public static double dotProduct(Matrix m1, Matrix m2){
		if(m1.getWidth() == m2.getHeight()){
			double result = 0.0;
			for(int row = 0; row < m1.getHeight(); row ++){
				for(int col = 0; col < m2.getWidth(); col++){
					//get dot product
					for(int i = 0; i<m1.getWidth(); i++){
						result +=m1.get(row, i)*m2.get(i, col);
					}
				}
			}
			return result;
		}else return 0.0;
	}
	
	public static Matrix multiply(Matrix m1, Matrix m2){
			Matrix product = new Matrix(m1.getHeight(), m2.getWidth());
			for(int row = 0; row < m1.getHeight(); row ++){
				for(int col = 0; col < m2.getWidth(); col++){
//					//get dot product
					double result = 0.0;
					for(int i = 0; i<m1.getWidth(); i++){
						result +=m1.get(row, i)*m2.get(i, col);
					}
					product.set(row, col,result);
				}
			}
			return product;

	}

	public static Matrix identity(int rows){
		Matrix ident = new Matrix(rows,rows);
		for(int i = 0; i< rows; i++)ident.set(i, i, 1);
		return ident;
	}

}
