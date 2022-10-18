package Trees;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BinaryTreeRunner {
	
	
	 
	
	 public static void main(String[] args) {
		
		 BinaryTreeNode<Integer> root=takeTreeInputBetter(true,0,true);
		 printDetailTree(root);
		 System.out.println("Is Balanced " +isBalanced(root));
		 
	}
	 
	 public static BalanceTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root)
	 {
		if(root==null)
		{
			int height=0;
			boolean isBal=true;
			BalanceTreeReturn ans=new BalanceTreeReturn();
			ans.height=height;
			ans.isBalanced=isBal;
			return ans;
			
		}
		
		BalanceTreeReturn leftOutput=isBalancedBetter(root.left);
		BalanceTreeReturn rightOutput=isBalancedBetter(root.right);
		
		boolean isBal=true;
		int height=1+Math.max(leftOutput.height,rightOutput.height);
		
		if(Math.abs(leftOutput.height = rightOutput.height)>1)
		{
			isBal=false;
		}
		
		if(!leftOutput.isBalanced || !rightOutput.isBalanced) 
		{
			isBal=false;
		}
		BalanceTreeReturn ans=new BalanceTreeReturn();
		ans.height=height;
		ans.isBalanced=isBal;
		
		return ans;
	 }
	 
	 public static BinaryTreeNode<Integer> takeInputLevelWise()
	 {
		 
		 
	 }

	private static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRootNode, int parentData, boolean isLeftNode) {
		// TODO Auto-generated method stub
		
		if(isRootNode)
		{
			System.out.println("Enter Root Node");
		} else if(isLeftNode)
		{
			System.out.println("Enter Left Child of  " +parentData);
		}else
		{
			System.out.println("Enter righ child of " +parentData);
		}
		
		Scanner scan=new Scanner(System.in);
		
		int rootData=scan.nextInt();
		
		if(rootData==-1)
		{
		
		return null;
		}
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		
		BinaryTreeNode<Integer> leftchild=takeTreeInputBetter(false,rootData,true);
		BinaryTreeNode<Integer> rightchild=takeTreeInputBetter(false,rootData,false);
		
		root.left=leftchild;
		root.right=rightchild;
		
		
		return root;
		
		
		
		
		
	}
	
	public static void printDetailTree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data + ": ");
		if(root.left!=null)
		{
			System.out.print("L" +root.left.data +" , ");
		}
		if(root.right!=null)
		{
			System.out.print("R" +root.right.data);
		}
		System.out.println();
		
		
		printDetailTree(root.left);
		printDetailTree(root.right);
		
		
		
	}
	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		
		return 1+Math.max(leftHeight, rightHeight);
		
		
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		
		if(root==null)
		{
			  return true;
		}
		int leftHeight=height(root.left);
		int rightHeight= height(root.right);
		
		if(Math.abs(leftHeight - rightHeight)> 1)
		{
			return false;
		}
		boolean isLeftBalanced=isBalanced(root.left);
		boolean isRightBalanced=isBalanced(root.right);
		
		return isRightBalanced && isLeftBalanced;
	}
	
	

}
