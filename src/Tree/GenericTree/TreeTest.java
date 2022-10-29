package Tree.GenericTree;

public class TreeTest {
	
	public static int numberOfNodes(TreeNode<Integer> root)
	{
		int count=1;
		for(int i=0;i<root.children.size();i++)
		{
			int childCount=numberOfNodes(root.children.get(i));
			count+=childCount;
		}
		return count;
	}
	
	public static void printTree(TreeNode<Integer> root) {
		
		
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + ": "); // print yrself (root)
		
		for(int i=0;i<root.children.size();i++)
		{
			System.out.print(root.children.get(i).data+ " ");
		}
		System.out.println();
		//how it will call to each sub trees one by one now 
		for(int i=0;i<root.children.size();i++)  //4 has 2,3,1 
		{
			TreeNode<Integer> child=root.children.get(i);
			printTree(child);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root=new TreeNode<>(4);
		TreeNode<Integer> root1=new TreeNode<>(2);
		TreeNode<Integer> root2=new TreeNode<>(3);
		
		TreeNode<Integer> root3=new TreeNode<>(1);
		
		TreeNode<Integer> root4=new TreeNode<>(5);
		
		TreeNode<Integer> root5=new TreeNode<>(6);
		root.children.add(root1);
		root.children.add(root2);
		root.children.add(root3);
		
		root2.children.add(root4);
		root2.children.add(root5);
		
		printTree(root);
		
		System.out.println("Number of Nodes : "+numberOfNodes(root));
		
		
	}

}
