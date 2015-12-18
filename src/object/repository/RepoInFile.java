package object.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import object.domain.IDObject;
import object.domain.Student;

public class RepoInFile<T extends IDObject> extends Repository<T> {
	
	private String fileName;
	
	public RepoInFile(String fileName) {
		super();
		this.fileName = fileName;
		loadFromFile();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void loadFromFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(fileName)));
			try {
				String line ;
				while ((line = br.readLine()) != null) {
					String[] lines = line.split(";");
					Student s = new Student(Integer.parseInt(lines[0]), lines[1], Double.parseDouble(lines[2]));
					add((T) s);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void saveFromFile() {
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(new File(fileName)));
			for(T s : getAll()) {
				br.write(((Student) s).toString() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}








