package object.repository;

import java.util.Comparator;

import object.domain.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDictionar.
 */
@SuppressWarnings("unused")
public interface IDictionar <K extends Comparable<K>, V>{
	
	/**
	 * Adds the.
	 *
	 * @param key the key
	 * @param valoare the valoare
	 * @return the boolean
	 */
	Boolean add(K key, V valoare);
	
	/**
	 * Update.
	 *
	 * @param key the key
	 * @param val the val
	 * @return the boolean
	 */
	Boolean update(K key, V val);
	
	/**
	 * Removes the.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean remove(K id);
	
	/**
	 * Find.
	 *
	 * @param key the key
	 * @return the V
	 */
	V find(K key);

}
