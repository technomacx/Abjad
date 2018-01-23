package nodes;


public class ComparisionNode extends Node {

	String operation;
	
	
	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	@Override
	public Object run(Context c) {
		double d1 = (double)children.get(0).run(c);
		double d2 = (double)children.get(1).run(c);
		switch(operation)
		{
		case ">":
			return d1 > d2;
		case "<":
			return d1 < d2;
		case ">=":
			return d1 >= d2;
		case "<=":
			return d1 <= d2;
		case "!=":
		case "<>":
			return d1 != d2;
		case "=":
			return d1 == d2;
		default:
			return false;
		}
	}

}
