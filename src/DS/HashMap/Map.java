package DS.HashMap;

import java.util.ArrayList;

public class Map<K,V>{
	
	//Map- (key,value) - Implementing through separate chaining
	//Internally Map will maintain an array and every element of an array is actually an linked list
	//And every node in linked list will have key value pairs.
	//We cannot create an generic array but we maintain an generic arraylist
	
	  
      ArrayList<MapNode<K,V>> buckets;
      
      int count;
      int numOfBuckets;
      
      public Map() {
    	  
    	  buckets=new ArrayList<>();
    	  numOfBuckets=20; //by default we have the arraylist size as 20
    	  for(int i=0;i<numOfBuckets;i++)
    	  {
    		  buckets.add(null);
    		  //Initially we are making the arraylist of all the index value as null
    	  }
      }
    	  
    	  //first we need to get the index to story in the arraylist..
    	  
    	  private int getBucketIndex(K key)
    	  {
    		  int hc=key.hashCode(); // here we will get the hashcode after getting we need to compressed.
    		  int index=hc%numOfBuckets; // here we compressed and we will index of the key 
    		  return index;
    	  }
    	  
    	  public int size()
    	  {
    		//no. of element in an hashmap..
    		  return count;
    		  
    	  }
    	  public V removeKey(K key)
    	  {
    		  int bucketIndex=getBucketIndex(key); 
    		  MapNode<K,V> head=buckets.get(bucketIndex);
    		  MapNode<K,V> prev=null;
    		  while(head!=null) 
    		  {
    			  if(head.key.equals(key)) 				  
    			  {
    				  prev.next=head.next; // so the previous node of the particular key node will connect to next node.
    				  
    			  }else {
    				  buckets.set(bucketIndex, head.next);
    			  }
    			  prev=head;
    			  head=head.next;
    			  
    		  }
    		  return null;
    		   
    	  }
    	  
    	  public V getValue(K key)
    	  {
    		  //to get the value the first task to get the bucket index
    		  int bucketIndex=getBucketIndex(key); 
    		  MapNode<K,V> head=buckets.get(bucketIndex);
    		  
    		  while(head!=null) 
    		  {
    			  if(head.key.equals(key)) 				  
    			  {
    				  return head.value;
    			  }
    			  
    			  head=head.next;
    			  
    		  }
    		  return null;
    		  
    	  }
    	  //Now we need to insert
    	  
    	  public void insert(K key, V value)
    	  {
    		  int bucketIndex=getBucketIndex(key); // whenever we try to insert first we will get the key 
    		                                       // from the bucketIndex menthod.
    		  //So now there might be already a linkedlist there or may not be there
    		  //And First we need to check if already same key is there or not if it is there, we need to
    		   //update the value of the key. if is not there we will insert.
    		  
    		  //after getting the index to need to get the head so that we can traverse the linked list one by one
    		  
    		  MapNode<K,V> head=buckets.get(bucketIndex);
    		  while(head!=null) // till head is not null we will traverse
    		  {
    			  if(head.key.equals(key)) // every node has key and value , we are checking if the key we want to insert is already there or not.				  
    			  {
    				  head.value=value;
    				  return;
    			  }
    			  
    			  head=head.next;
    			  
    		  }
    		  
    		//while traversing above line of code head must become null if it doesn't find the same key.
			//we need to previous head, so
    		  
    		  head=buckets.get(bucketIndex);
    		  //so for insertion first task is create a new node so that we can insert...
    		  MapNode<K,V> newNode=new MapNode<>(key,value);
    		  //now we need to do the connection of the node, first connect to the previous head node
    		  newNode.next=head;
    		  buckets.set(bucketIndex, newNode); // And we have connected the bucket index to need node.
    		  //So first node will be the new which we have inserted.
    		  count++;
    		  
    		  
    		  
    	  }
    	  
    	  
      
	

}
