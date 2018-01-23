package nodes;


public class IfNode extends Node {

	@Override
	public Object run(Context c) {
		
		if ((boolean)children.get(0).run(c))
			children.get(1).run(c);
		else if (children.size() > 2)
			children.get(2).run(c);
		
		return null;
	}

}
