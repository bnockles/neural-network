package network;

import java.util.Arrays;

public class BiPolarUtil {

	public static double boolean2double(boolean boo){
		return (boo)?1.0:-1.0;
	}

	public static boolean double2boolean(double d){
		return d>0;
	}
	
	public static double[] boolean2double(boolean[] b){
		double[] result = new double[b.length];
		for(int i = 0 ; i < result.length; i++){
				result[i] = boolean2double(b[i]);
		}
		return result;
	}

	public static double[][] boolean2double(boolean[][] b) {
		double[][] result = new double[b.length][b[0].length];
		for(int i = 0 ; i < result.length; i++){
			for(int j = 0; j < result[0].length; j++){
				result[i][j] = boolean2double(b[i][j]);
			}
		}
		return result;
	}
	
	public static boolean[][] double2boolean(double[][] b) {
		boolean[][] result = new boolean[b.length][b[0].length];
		for(int i = 0 ; i < result.length; i++){
			for(int j = 0; j < result[0].length; j++){
				result[i][j] = double2boolean(b[i][j]);
			}
		}
		return result;
	}

	
}
