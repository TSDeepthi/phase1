package P1;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DigiLocker {
	final static String appName = "LockedMe.com";

	public static void main(String[] args) {

		// Initialization of variables

		int ch;
		int opch;
		String str;
		boolean flag = true;
		boolean flag2 = false;

		Set<String> fileNames = new TreeSet<String>(new Mycomparator());

		CF curfile = new CF(fileNames);
		FileOp fileopt = new FileOp(fileNames);

		Scanner scanner = new Scanner(System.in);

		System.out.println("----------------------------- " + appName + " -------------------------------\n");
		System.out.println("--------------------------------------------------------------------------\n");
		System.out.println("Developer Details :");
		System.out.println("Name             : TS Deepthi");
		System.out.println("Contact          : deepti@gmail.com");
		System.out.println("Phone            : 8800632549");
		System.out.println("Education        : BE in Computer Science");
		System.out.println("Technical Skills : Java, Python, HTML, CSS, SQL");

		System.out.println("\n-----------------------------------------------------------\n");

		while (!flag2) {
			try {

				while (true) {

					System.out.println("\nOperations :\n");
					System.out.println(
							"1.Files Available\n2.File Operations (Add, Remove, Search)\n3.Exit Application\n");

					System.out.print("Enter your choice : ");
					ch = scanner.nextInt();
					switch (ch) {

					case 1:
						curfile.displayFN(fileNames);
						System.out.println("\n-----------------------------------------------------------\n");
						break;

					case 2:
						while (flag) {

							System.out.println("\n-----------------------------------------------------------\n");
							System.out.println("File Operations :");
							System.out.println("\n1.Add file\n2.Delete file\n3.Search file\n4.Back to main\n");
							System.out.print("Enter your choice : ");
							opch = scanner.nextInt();

							switch (opch) {

							case 1:
								System.out.print("\nEnter Filename to Add : ");
								str = scanner.next();
								fileopt.addFile(str);
								break;

							case 2:
								System.out.print("\nEnter Filename to Remove : ");
								str = scanner.next();
								fileopt.removeFile(str);
								break;

							case 3:
								System.out.print("\nEnter Filename to Search : ");
								str = scanner.next();
								fileopt.searchFile(str);
								break;

							case 4:
								flag = false;
								break;

							default:
								System.out.println("\nEnter Valid Choice\n");
								break;

							}
						}
						flag = true;
						break;

					case 3:
						System.out.println("\nApplication Closed");
						System.exit(0);

					default:
						System.out.println("\nEnter Valid Choice\n");
						System.out.println("\n-----------------------------------------------------------\n");
						break;

					}
					flag2 = false;
				}

			} catch (Exception e) {
				System.out.println("\nEnter a Valid Choice :\n");
				scanner.nextLine();
			}
		}
	}

}

class Mycomparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

}

class CF {

	private Set<String> fileNames;

	CF(Set<String> fileNames) {
		this.fileNames = fileNames;
	}

	public void displayFN(Set<String> fileNames) {

		if (fileNames.isEmpty()) {
			System.out.println("\nDirectory is empty.\n");
			return;
		}

		int num = fileNames.size();
		System.out.println("\nNumber of files present in the directory are : " + num + "\n");
		System.out.println("Files Available : ");
		for (String y : fileNames) {
			System.out.println("-> "+y + " ");
		}

	}
}


class FileOp{

	private Set<String> fileNames;

	FileOp(Set<String> fileNames) {
		this.fileNames = fileNames;
	}

	public void addFile(String newFile) {
		
		if (fileNames.contains(newFile)) {
			System.out.println("\nFile name already exists please change the name and try inserting again.\n");
		} else {

			fileNames.add(newFile);
			System.out.println("\nFile added to directory.\n");

		}
	}
	
	public void removeFile(String file) {
		if (fileNames.contains(file)) {
			fileNames.remove(file);
			System.out.println("\nFile removed successfully.\n");
		} else {
			System.out.println("\nFile not found.\n");
		}
	}
	
	public void searchFile(String file) {
		if (fileNames.contains(file)) {
			System.out.println("\nFile present in the directory.\n");
		} else {
			System.out.println("\nFile not found.\n");
		}
	}
}