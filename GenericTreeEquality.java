import java.util.Stack;

// Tree implements the binary search tree property

class Tree<T extends Comparable<T>> {
	public Tree(T v) {
		value = v;
		left = null;
		right = null;
	}

	public void insert(T v) {
		if (value.compareTo(v) == 0)
			return;
		if (value.compareTo(v) > 0)
			if (left == null)
				left = new Tree<T>(v);
			else
				left.insert(v);
		else if (value.compareTo(v) < 0)
			if (right == null)
				right = new Tree<T>(v);
			else
				right.insert(v);
	}

	protected T value;
	protected Tree<T> left;
	protected Tree<T> right;
}

class Iter<T extends Comparable<T>> {

	Stack<T> mTreeStackNodes;
	public Iter(Tree<T> treeObj) {

		// TODO Auto-generated constructor stub
		mTreeStackNodes = new Stack<T>();
		this.populateStack(treeObj); 
		System.out.println(this.toString());
	}
	
	

	private void populateStack (Tree<T> subTree) {
		if (subTree == null) {
			System.out.println("Empty tree");
			return;
		}

		if (subTree.right != null) {
			populateStack(subTree.right);	
		}
		mTreeStackNodes.push(subTree.value);
		if (subTree.left != null) {
			populateStack(subTree.left);
		}
	}

	@Override
	public String toString() {
		return "Iter [mTreeStackNodes=" + mTreeStackNodes + "]";
	}

	// define here the external iterator operations, done and next
	public T next() {
		if (mTreeStackNodes.isEmpty()) {
			return null;
		}else{
			return mTreeStackNodes.pop();
		}
	}

	public boolean done() {
		return mTreeStackNodes.empty();	
	}
}

public class GenericTreeEquality {

	static <T extends Comparable<T>> boolean equals(Tree<T> tree1, Tree<T> tree2) {

		// define here the equality test
		Iter<T> iter1 = new Iter<T>(tree1);
		Iter<T> iter2 = new Iter<T>(tree2);
		while ((iter1.done()!= true) || (iter2.done() != true)) {
			if(!iter1.next().equals(iter2.next())) {
				return false;
			} 
		}
		if ((iter1.done()== true) && (iter2.done() == true)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		Tree<Integer> tree1 = new Tree<Integer>(50);
		tree1.insert(70);
		tree1.insert(80);	
		tree1.insert(90);
		tree1.insert(100);
		
		Tree<Integer> tree2 = new Tree<Integer>(90);
		tree2.insert(80);
		tree1.insert(100);
		tree2.insert(70);	
		tree2.insert(50);

		System.out.println(equals(tree1, tree2 ));
	}
}

