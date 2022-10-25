package Trees;

public class BST {
	
	
	private BinaryTreeNode<Integer> root;
	private int size;
	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x)
	{
		if(node==null)
		{
			return false;
		}
		if(node.data==x)
		{
			return true;
		}
		if(x<node.data)
		{
			return isPresentHelper(node.left,x);
			//Call on left side
		} else {
			
			return isPresentHelper(node.right,x);
				  // call on right side
		}
	}
	
	public boolean isPresent(int x)
	{
		 return isPresentHelper(root,x);
		
	}
	
	public void insert(int x)
	{
		root=insert(root,x);
		size++;
		
	}
	private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
		
		if(root==null)
		{
			return new BSTDeleteReturn(null, false);
		}
		if(root.data<x) {
			
			BSTDeleteReturn outputRight=deleteDataHelper(root.right,x);
			root.right=outputRight.root;
			outputRight.root=root;
			
			return outputRight;
			
			
		}
		
		if(root.data>x) {
			
			BSTDeleteReturn outputLeft=deleteDataHelper(root.left,x);
			root.left=outputLeft.root;
			outputLeft.root=root;
			
			return outputLeft;
			
			
		}
		
		//0 children
		if(root.left==null && root.right==null)
		{
			return new BSTDeleteReturn(null, true);
		}
		//Only Left children
		if(root.left!=null && root.right==null)
		{
			return new BSTDeleteReturn(root.left, true);
		}
	
	   //Only right children
	    if(root.left==null && root.right!=null)
	    {
		return new BSTDeleteReturn(root.right, true);
	    }		
		
		//both children are present
	    //we have to find maximum on the right side-->
	    
	     int rightMin=minimum(root.right);
	     root.data=rightMin;
	     BSTDeleteReturn outputRight=deleteDataHelper(root.right, rightMin);
		 root.right=outputRight.root;
		 
		 return new BSTDeleteReturn(root, true);
	     
	     
	}
	
	 private static int minimum(BinaryTreeNode<Integer> root)
	 {
		 if(root==null) {
			 return Integer.MAX_VALUE;
		 }
		 int leftMin=minimum(root.left);
		 int rightMin=minimum(root.right);
		 
		 return Math.min(root.data, Math.min(leftMin, rightMin));
		 
	 }
	
	public boolean deleteData(int x)
	{
		BSTDeleteReturn output=deleteDataHelper(root,x);
		root=output.root;
		if(output.deleted)
		{
			size--;
		}
		return output.deleted;
	}
	 public int size() {
		 return size;
	 }
	 
	 
	 private static void printTreeHelper(BinaryTreeNode<Integer> node)
	 {
		 if(node==null)
			{
				return;
			}
			System.out.print(node.data + ": ");
			if(node.left!=null)
			{
				System.out.print("L" +node.left.data +" , ");
			}
			if(node.right!=null)
			{
				System.out.print("R" +node.right.data);
			}
			System.out.println();
			
			
			printTreeHelper(node.left);
			printTreeHelper(node.right);
		 
		 
	 }
	 public void printTree() {
		 
		 printTreeHelper(root);
		 
	 }
	 
	  private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x){
		 
		 if(node==null)
		 {
			 BinaryTreeNode<Integer> newRoot=new BinaryTreeNode<Integer>(x);
			 return newRoot;
		 }
		 
		 if(x>=node.data) {
			 node.right=insert(node.right,x);
		 } else {
			 node.left=insert(node.left, x);
		 }
		 return node;
	 }
	 

}
