package object.repository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import object.domain.IDObject;

public class RepoInBinary<T extends IDObject> extends Repository<T>{

	private String fileName;
	public RepoInBinary(String fileName) {
		super();
		this.fileName = fileName;
		loadFromFile();
	}
	
	@SuppressWarnings("unchecked")
	public void loadFromFile() {
		ObjectInputStream fileReader = null;
		try {
			fileReader = new ObjectInputStream(new FileInputStream(fileName));
			try {
				myDictionary = (Dictionar<Integer, T>)fileReader.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void saveFromFile() {
		ObjectOutputStream fileWrite = null;
		try {
			fileWrite = new ObjectOutputStream(new FileOutputStream(fileName));
			fileWrite.writeObject(myDictionary);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fileWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
