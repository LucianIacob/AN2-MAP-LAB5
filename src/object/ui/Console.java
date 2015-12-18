package object.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import object.domain.Student;
import object.repository.*;
// TODO: Auto-generated Javadoc
/**
 * The Class Console.
 */
public class Console {
	
	/** The my dictionar. */
	private Repository<Student> myRepo;
	
	/**
	 * Run.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	public void run() throws IOException {
		String command;
		int cmd=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("1. In memory.");
			System.out.println("2. In text file.");
			System.out.println("3. In binary file.");
			System.out.print(" ---Dati optiunea: ");
			command = br.readLine();
			try {
				cmd = Integer.parseInt(command);
			}catch(NumberFormatException err) {
				System.out.println(" @ Invalid input!");
			};
			
			if(cmd == 1) {
				myRepo = new Repository<Student>();
				myRepo.add(new Student(11474, "Guranda Bogdan", 9.6));
				myRepo.add(new Student(11574, "Tiperciuc Corvin", 9.5));
				myRepo.add(new Student(11434, "Galea Ronaldo", 7.0));
				myRepo.add(new Student(17474, "Iacob Lucian", 6.54));
				myRepo.add(new Student(14742, "Trif George", 5.20));
				break;
			}
			else if(cmd == 2) {
				myRepo = new RepoInFile<Student>("data.txt");
				break;
			}
			else if(cmd == 3) {
				myRepo = new RepoInBinary<Student>("data.bin");
				break;
			}
		}
		
		while(true) {
			System.out.println("");
			System.out.println("---MENIU PRINCIPAL---");
			System.out.println("1. Adaug student.");
			System.out.println("2. Cauta student.");
			System.out.println("3. Editeaza student.");
			System.out.println("4. Elimina student.");
			System.out.println("5. Afiseaza studentii.");
			System.out.println("0. Iesire.");
			System.out.print(" ---Dati optiunea: ");
			
			command = br.readLine();
			try {
				cmd = Integer.parseInt(command);
			}catch(NumberFormatException err) {
				System.out.println(" @ Invalid input!");
			};
			
			if (cmd == 0) {
				if(myRepo instanceof RepoInFile<?>)
					((RepoInFile<Student>)myRepo).saveFromFile();
				else if(myRepo instanceof RepoInBinary<?>)
					((RepoInBinary<Student>)myRepo).saveFromFile();
				break;
			}
			else if(cmd == 1) {
				int nrmatricol=0;
				double media=0;
				System.out.print("Dati numarul matricol: ");
				try {
					nrmatricol = Integer.parseInt(br.readLine());
					if(myRepo.find(nrmatricol) != null)
						System.out.println(" @ Studentul exista deja!");
					else {
					System.out.print("Dati numele studentului: ");
					String nume = br.readLine();
					
					System.out.print("Dati media: ");
					media = Double.parseDouble(br.readLine());
					
					System.out.println(" @ " + myRepo.add(new Student(nrmatricol, nume, media)));
					}
				} catch(NumberFormatException err) {
					System.out.println(" @ Invalid input!");
				}
			}
			
			else if(cmd == 2) {
				int nrmatricol=0;
				System.out.print("Dati numarul matricol: ");
				try {
					nrmatricol = Integer.parseInt(br.readLine());
					Student o = myRepo.find(nrmatricol);
					if(o != null)	System.out.println(" @ " + o.toString());
					else
						System.out.println(" @ Studentul nu exista!");
				} catch(NumberFormatException err) {
					System.out.println(" @ Invalid input!");
				}
			}
			
			else if(cmd == 3) {
				int nrmatricol=0;
				System.out.print("Dati numarul matricol al studentului: ");
				try {
					nrmatricol = Integer.parseInt(br.readLine());
					Student o = myRepo.find(nrmatricol);
					if(o == null)	
						System.out.println(" @ Studentul nu exista!");
					else {
						String nume = o.getNume();
						System.out.print("Dati noua medie pentru acest student: ");
						double media = Double.parseDouble(br.readLine());
						System.out.println(" @ " + myRepo.update(new Student(nrmatricol, nume, media)));
					}
				} catch(NumberFormatException err) {
					System.out.println(" @ Invalid input!");
				}
			}
			
			else if(cmd == 4) {
				int nrmatricol = 0;
				System.out.print("Dati numarul matricol al studentului: ");
				try {
					nrmatricol = Integer.parseInt(br.readLine());
					Student o = myRepo.find(nrmatricol);
					if(o != null)	System.out.println(" @ " + myRepo.remove(nrmatricol));
					else
						System.out.println(" @ Ati introdus un numar matricol neexistent!");
				} catch(NumberFormatException err) {
					System.out.println(" @ Invalid input!");
				}
			}
			
			else if(cmd == 5) {
				int x=0;
				System.out.println();
				
				for(Student s : myRepo.getAll()) {
					System.out.println(s.toString());
					x++;
				}
				if (x == 0)	{
					System.out.println(" @ Nu exista studenti");
				}
			}
		}
	}
}
