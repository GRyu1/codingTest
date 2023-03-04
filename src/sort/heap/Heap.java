package sort.heap;

import java.util.Comparator;

public class Heap<E>{
	public final Comparator<? super E> comparator;
	public final int DEFAULT_SIZE = 10;
	
	public int size;
	
	public Object[] array;
	
	public Heap() {
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.array=new Object[DEFAULT_SIZE];
		this.size=0;
		this.comparator=comparator;
	}
	
	
	public Object getValue(int idx) {
		
		return array[idx];
	}
	public int getParent(int index) {
		return index/2;
	}
	public int getLeftChild(int index) {
		return index*2;
	}
	public int getRightChilde(int index) {
		return index*2+1;
	}
	
	
	public void resize(int newCapacity) {
		
		Object[] newArray = new Object[newCapacity];
		
		for(int i=1;i<=size;i++) {
			newArray[i]=array[i];
		}
		
		this.array = null;
		this.array = newArray;
	}
	public void add(E value) {
		if(size+1>=array.length) {
			resize(array.length*2);
		}
		siftUp(size+1, value);
		size++;
	}
	
	public void siftUp(int idx, E target) {	
		if(comparator != null) {
			siftUpComparator(idx, target, comparator);
		}
		else {
			siftUpComparable(idx, target);
		}
	}
	public void siftUpComparable(int idx, E target) {
		Comparable<? super E> comp = (Comparable<? super E>) target;
		
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
				
			if(comp.compareTo((E)parentVal) >= 0) {
				break;
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = comp;
		
	}
	public void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
		while(idx > 1) {
			int parent = getParent(idx);	
			Object parentVal = array[parent];
			
			if(comp.compare(target, (E) parentVal) >= 0) {
				break;
			}				
			array[idx] = parentVal;
			idx = parent;
		}
			
		array[idx] = target;
	}
	
	
}


