package object.repository;

import java.util.ArrayList;

import object.domain.IDObject;

public class Repository<T extends IDObject> {
	
	protected Dictionar<Integer, T> myDictionary = new Dictionar<Integer, T>();
	
	public boolean add(T o) {
		return myDictionary.add(o.getID(), o);
	}
	public boolean update(T o) {
		return myDictionary.update(o.getID(), o);
	}
	public boolean remove(int nrmatricol) {
		return myDictionary.remove(nrmatricol);
	}
	public T find(int nrmatricol) {
		return myDictionary.find(nrmatricol);
	}
	public ArrayList<T> getAll(){
		return  myDictionary.getList();
	}
}
