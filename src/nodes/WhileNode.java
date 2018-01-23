package nodes;


public class WhileNode extends Node {

	@Override
	public Object run(Context c) {
		
		while((boolean)children.get(0).run(c))
			children.get(1).run(c);
		
		return null;
	}

}
