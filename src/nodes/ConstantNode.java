package nodes;


public class ConstantNode extends ExpressionNode {

	double constant;
	
	public double getConstant() {
		return constant;
	}

	public void setConstant(double constant) {
		this.constant = constant;
	}

	public Object run(Context c) {
		return constant;
	}
	
}
