package nodes;


public class ScopeNode extends Node {

	@Override
	public Object run(Context c) {
		for(Node child : children)
			child.run(c);
		return null;
	}

}
