package nodes;


import java.util.ArrayList;

public abstract class Node {

	protected ArrayList<Node> children = new ArrayList<>();
	
	public void addChild(Node child)
	{
		children.add(child);
	}
	
	public abstract Object run(Context c);
	
}
