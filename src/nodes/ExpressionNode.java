package nodes;


public class ExpressionNode extends Node {

	
String operation;
double result=8;
	
	public String getOperation() {
		return operation;
	}

	public double getResult() {
		return result;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setResult(double result) {
		this.result = result ;
	}
	
	@Override
	public Object run(Context c) {
		System.out.println("ahmad");
		double d1 = (double)children.get(0).run(c);
		double d2 = (double)children.get(1).run(c);
		System.out.println("ahmad");
		switch(operation)
		{
		case "+":{
			setResult(d1 + d2);
			return d1 + d2;}
		case "-":
			setResult(d1 - d2);
			return d1 - d2;
		case "*":
			setResult(d1 * d2);
			return d1 * d2;
		case "/":
			setResult(d1 / d2);
			return d1 / d2;
		case "^":
			setResult(Math.pow(d1,d2));
			return Math.pow(d1,d2);
		default:
			return 0;
		}
	}

}
