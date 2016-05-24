package network;

public class ActivationIDENT implements ActivationFunction {

	public ActivationIDENT() {
	}

	@Override
	public double activationFunction(double input) {
		return input;
	}

	@Override
	public double derivativeFunction(double d) {
		return 1;
	}

}
