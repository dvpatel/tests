package tests;

public class LinkedList<T> {
	
	private Node<T> first ;
	private Node<T> current ;

	private class Node<T> {
		public T value ;
		public Node<T> next ;		
		public Node<T> previous ;		
	}

	public void add(T v) {
		Node<T> _t = new Node<T>() ;
		_t.value = v ;

		if (first == null) {
			first = _t ;
			current = _t ;
		} else {			
			current.next = _t ;
			_t.previous = current ;
			current = current.next ;					
		}		
	}
		
	/*
	 * Delete first found value ;
	 */
	public void deleteValue(T v) {
		
		Node<T> current = first ;
		while (current != null) {
			
			Node<T> prev = current.previous ;
			Node<T> nxt = current.next ;
			
			if (current.value == v) {				
				prev.next = nxt ;
			}			
			
			current = nxt ;
		}
		
	}
	
	public void print() {
		Node<T> s = first ;
		while (s != null) {
			System.out.print(" " + s.value) ;
			s = s.next ;
		}		
		System.out.println("");
	}

	public static void main(String[] args) {
		
		LinkedList<Integer> l = new LinkedList<Integer>() ;
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}

		l.print();		
		l.deleteValue(3);
		l.deleteValue(5);
		l.print();		
		
	}

}
