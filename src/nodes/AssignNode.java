package nodes;


public class AssignNode extends Node {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object run(Context c) {
		// TODO Auto-generated method stub
		double d = (double)children.get(0).run(c);
		c.getVariables().put(variable, d);
		return null;
	}

}
