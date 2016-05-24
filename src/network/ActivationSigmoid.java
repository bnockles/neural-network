package network;

public class ActivationSigmoid implements ActivationFunction {

	public ActivationSigmoid() {
	}

	@Override
	public double activationFunction(double input) {
		return 1.0 / (1 + Math.exp(-1.0 * input));
	}

	@Override
	public double derivativeFunction(double d) {
		return d*(1.0-d);
	}

}
