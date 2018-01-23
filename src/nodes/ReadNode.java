package nodes;


import java.util.Scanner;

public class ReadNode extends Node {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object run(Context c) {
		Scanner s = new Scanner(System.in);
		double d = s.nextDouble();
		c.getVariables().put(variable, d);
		return null;
	}

}
