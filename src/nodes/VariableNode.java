package nodes;


public class VariableNode extends ExpressionNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public Object run(Context c) {
		return c.getVariables().get(variable);
	}	
	
}
