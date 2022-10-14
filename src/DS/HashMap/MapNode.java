package DS.HashMap;

public class MapNode<K,V>{
	
	//linkedlist will have key and value and reference to link with the next node
	
	K key;
	V value;
	MapNode<K,V> next;
	public MapNode(K key,V value)
	{
		this.key=key;
		this.value=value;
		
	}

}
