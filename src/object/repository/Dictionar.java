package object.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import object.domain.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class Dictionar.
 */
@SuppressWarnings({ "unused", "serial" })
public class Dictionar<K extends Comparable<K>, V> implements IDictionar <K,V>, Serializable{

	/**
	 * The Class Pereche.
	 */
	@SuppressWarnings({ "hiding" })
	public class Pereche<K extends Comparable<K>, V> implements Serializable {
		/** The cheie. */
		public K cheie;
		/** The valoare. */
		public V valoare;
		/**
		 * Instantiates a new pereche.
		 *
		 * @param cheie the cheie
		 * @param valoare the valoare
		 */
		public Pereche(K cheie, V valoare){
			this.cheie = cheie;
			this.valoare = valoare;	
		}
		/**
		 * Compare to.
		 *
		 * @param o the o
		 * @return the int
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public int compareTo(Pereche o) {
			return this.cheie.compareTo((K) o.cheie);
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList<Pereche> myList = new LinkedList<Pereche>();
	
	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	ArrayList<V> getList() {
		ArrayList<V> myArray = new ArrayList<V>();
		Iterator<Pereche> itr = myList.iterator();
		while(itr.hasNext()) {
			myArray.add((V) itr.next().valoare);
		}
		
		return myArray;
	}
	/**
	 * Gets the iterator.
	 *
	 * @return the iterator
	 */
	@SuppressWarnings("rawtypes")
	public Iterator<Pereche> getIterator(){
		return myList.iterator();
	}
	
	/* (non-Javadoc)
	 * @see object.repository.IDictionar#add(java.lang.Comparable, java.lang.Object)
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean add(K key, V valoare) {
		Pereche p = new Pereche(key, valoare);
		int i=0;
		for(i=0; i<myList.size(); i++)
			if (myList.get(i).compareTo(p) > 0)	break;
		myList.add(i, p);
		return true;
	}

	/* (non-Javadoc)
	 * @see object.repository.IDictionar#update(java.lang.Comparable, java.lang.V)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean update(K key, V valoare) {
		Pereche p = new Pereche(key, valoare);
		Iterator<Pereche> iterator = myList.iterator();
		int position = -1;
		while(iterator.hasNext()) {
			position++;
			if(iterator.next().cheie.compareTo(key) == 0)		break;
		}
		myList.set(position, p);
		return true;
	}

	/* (non-Javadoc)
	 * @see object.repository.IDictionar#remove(java.lang.Comparable)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean remove(K key) {
		Iterator<Pereche> iterator = myList.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().cheie.compareTo(key) == 0) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see object.repository.IDictionar#find(java.lang.Comparable)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V find(K key) {
		Iterator<Pereche> iterator = myList.iterator();
		while(iterator.hasNext()) {
			Pereche o = iterator.next();
			if(o.cheie.compareTo(key) == 0) {
				return (V) o.valoare;
			}
		}
		return null;
	}
}