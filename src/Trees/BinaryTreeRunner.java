package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BinaryTreeRunner {
	
	
	 
	
	 public static void main(String[] args) {
		 
//		
//		 BinaryTreeNode<Integer> root=takeInputLevelWise();
//		 printDetailTree(root);
//		 System.out.println("Is Balanced " +isBalanced(root));
		 
		 int in[]= {1,2,3,4,5,6,7};
		 int pre[]= {4,2,1,3,6,5,7};
		 BinaryTreeNode<Integer> root=buildTreeFromPreIn(pre, in);
		 printDetailTree(root);
		 System.out.println(searchBST(root,3));
		 
	}
	 
	 public static boolean searchBST(BinaryTreeNode<Integer> root, int data)
	 {
		 if(root==null)
		 {
			 return false;
		 }
		 if(root.data==data)
		 {
			 return true;
		 }
		 if(data<root.data)
		 {
			 return searchBST(root.left,data);
		 }
		 return searchBST(root.right,data);
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
	 
	 public static void printLevelWise(BinaryTreeNode<Integer> root)
	 {
		 
		 if(root==null)
		 {
			 return;
		 }
		 
		 
	 }
	 
	 public static BinaryTreeNode<Integer> takeInputLevelWise()
	 {
		 Scanner s=new Scanner(System.in);
		 
		 System.out.println("Enter root Data");
		 int rootData =s.nextInt();
		 if(rootData==-1)
		 {
			 return null;
		 }
		 
		 BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		 
		 Queue<BinaryTreeNode<Integer>> pendingChildren =new LinkedList<BinaryTreeNode<Integer>>();	 
		 
		 pendingChildren.add(root);
		 
		 while(!pendingChildren.isEmpty()) {
			 BinaryTreeNode<Integer> front=pendingChildren.poll();
			 System.out.println("Enter Left Child of " +front.data);
			 
			 int left=s.nextInt();
			 if(left!=-1)
			 {
				 BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(left);
				 root.right=rightChild;
				 pendingChildren.add(rightChild);
				 
			 }
			 
			 System.out.println("Enter right child of " + front.data);
			 
			 int right=s.nextInt();
			 if(right!=-1)
			 {
				 BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(right);
				 root.right=rightChild;
				 pendingChildren.add(rightChild);
				 
			 }
			 
		 }
		 
		 return root;
		 
	 }
	 
	 public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int [] pre, int [] in, int siPre, int eiPre, int siIn, int eiIn){
		 
		 if(siPre>eiPre)
		 {
			 return null;
		 }
		 int rootData=pre[siPre];
		 
		 BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		 
		 int rootIndex=-1;
		 for(int i=siIn; i<=eiIn;i++) //To Find Root node in InOrder
		 {
			 if(in[i]==rootData)
			 {
				 rootIndex=i;
				 break;
				 
			 }
		 }
		 
		 int siPreLeft=siPre+1; //Second index of preOrder will be first left
		 int siInLeft=siIn; 
		 int eiPreLeft;
		 int eiInLeft=rootIndex-1;
		 //Above variables to build left sub tree
		//Below variables to build right sub tree
		 int siPreRight;
		 int siInRight=rootIndex+1;
		 int eiPreRight=eiPre;
		 int eiInRight=eiIn;
		 
		 //Remaining two we need to find..
		 
		 int leftsubtreeLength=eiInLeft-siInLeft+1;
		 eiPreLeft=siPreLeft+leftsubtreeLength-1;
		 siPreRight=eiPreLeft+1;
		 
		 
		 BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre,in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		 
		 BinaryTreeNode<Integer> right=buildTreeFromPreInHelper(pre,in, siPreRight, eiPreRight, siInRight, eiInRight);
		 
		 root.left=left;
		 root.right=right;
		 
		 return root;
		 
		 
		 
	 }
	 public static BinaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
		 
		 
		 
		 
		 BinaryTreeNode<Integer> root=buildTreeFromPreInHelper(pre,in,0,pre.length-1,0,in.length-1);
		 
		 
		 return root;
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
