package events;

import java.util.Arrays;

import network.BiPolarUtil;
import network.HopfieldNetwork;
import network.Matrix;
import network.MatrixMath;;

public class Test {

	public static void main(String[] args){
		hopfieldNetworkTest();
//		testTanspose();
//		basicTest();
//		booleanProduct();
	}
	
	private static void testTanspose(){
		boolean[][] one = {{true, false, true},{false, true, false}};
		Matrix m = new Matrix(BiPolarUtil.boolean2double(one));
		System.out.println("The transposition of\n " + m +" is\n"+MatrixMath.transpose(m));
	}
	
	private static void hopfieldNetworkTest() {
		HopfieldNetwork fiveValues = new HopfieldNetwork(5);
		boolean[] pattern1 = {true, false, false, false, false};
		boolean[] pattern2 = {false, true, false, true, true};

			fiveValues.train(pattern1);
			fiveValues.train(pattern2);

		System.out.println("HopfieldNetwork is:\n"+fiveValues);
		boolean[][] presents = {
				{true, true, false, false, false},//1
				{true, false, true , false, false},//2
				{false, true, false, false, true},//3 *
				{false, false, false, false, false},//4
				{false, true, false, false, false},//5
				{true, true, true, false, false},//6
				{false, true, true, false, false},//7
				{true,false, false, false, false}//8 star
		};
		int count = 1;
		for(boolean[] test: presents){
			System.out.println("Presented HopfieldNetwork with:\n      "+count+") "+Arrays.toString(test)+"\nresult = "+Arrays.toString(fiveValues.present(test)));
			count++;
		}
	}
	
	public static void booleanProduct(){
		boolean[] pattern = {false, true, true, false, false};
		Matrix m1 = Matrix.createRowMatrix(BiPolarUtil.boolean2double(pattern));
		Matrix m2 = Matrix.createColumnMatrix(BiPolarUtil.boolean2double(pattern));
		System.out.println("The product of \n" + m1+"\n and \n"+m2+"\nis:\n"+MatrixMath.multiply(m2, m1));
	}

	public static void basicTest(){
		boolean[][] booleanData2 = {{true, false},{false,true}};
		Matrix matrix2 = new Matrix(BiPolarUtil.boolean2double(booleanData2));
		System.out.println(matrix2);
		double[][] one = {{1,2,3},{4,5,6}};
		Matrix dp1 = new Matrix(one);
		double[][] two = {{1,2},{3,4},{5,6}};
		Matrix dp2 = new Matrix(two);
		System.out.println("The product of \n" + dp1+"\n and \n"+dp2+"\nis:\n"+MatrixMath.multiply(dp1, dp2));
	}

}
