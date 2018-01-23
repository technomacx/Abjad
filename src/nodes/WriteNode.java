package nodes;


public class WriteNode extends Node {

	ExpressionNode variable;
	
	public ExpressionNode getVariable() {
		return variable;
	}

	public void setVariable(ExpressionNode variable) {
		this.variable = variable;
	}
	
	@Override
	public String run(Context c) {
		System.out.println("ahmad");
		//children.get(0).run(c).toString();
		return null;
	}
}
