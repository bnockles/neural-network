package network;

public class ActivationTANH implements ActivationFunction {

	public ActivationTANH() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double activationFunction(double d) {
		 final double result = (Math.exp(d*2.0)-1.0)/
                 (Math.exp(d*2.0)+1.0);
           return result;
	}

	@Override
	public double derivativeFunction(double d) {
		 return( 1.0-Math.pow(activationFunction(d), 2.0) );
	}

}
