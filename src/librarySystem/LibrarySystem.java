package librarySystem;
import java.util.Scanner;

public class LibrarySystem {
	private Book theBook = new Book();
	private Admin theAdmin = new Admin("Ahmed Basiony");
	private User theUser = new User();
	
	private void menu() {
		System.out.println("Library menu");
		System.out.println("1) add_book");
		System.out.println("2) search_for_book_by_perfix");
		System.out.println("3) print_who_borrowed_book_by_name");
		System.out.println("4) print_library_by_id");
		System.out.println("5) print_library_by_name");
		System.out.println("6) add_user");
		System.out.println("7) user_borrow_book");
		System.out.println("8) user_return_book");
		System.out.println("9) print_users");
		System.out.println("10) Exit");

	}
	
	
	public void run() {
		menu();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\nEnter you menu choice [1 - 10]");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if(choice == 1) {
				System.out.print("Enter book ID: ");
				int ID = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter book Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter book quanity: ");
				int Q = scanner.nextInt();
				theBook.add_book(ID,name,Q);
			} else if(choice == 2) {
				System.out.print("Enter a perfix: ");
				String perfix = scanner.nextLine();
				theBook.search_by_perfix(perfix);
			} else if(choice == 3) {
				theAdmin.printBorrowers(theUser);
			} else if(choice == 4) {
				theAdmin.printLibraryById(theBook);
			} else if(choice == 5) {
				theAdmin.printLibraryByName(theBook);
			} else if(choice == 6) {
				System.out.print("Enter user ID: ");
				int ID = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter user name: ");
				String name = scanner.nextLine();
				theUser.setUser_id_and_name(ID,name);
			} else if(choice == 7) {
				System.out.print("Enter a user name: ");
				String userName = scanner.nextLine();
				System.out.print("Enter a book name: ");
				String bookName = scanner.nextLine();
				theUser.borrowABook(theBook, userName, bookName);
			} else if(choice == 8) {
				System.out.print("Enter your name: ");
				String userName = scanner.nextLine();
				System.out.print("Enter book name: ");
				String bookName = scanner.nextLine();
				theUser.returnAbook(theBook, userName, bookName);
			} else if(choice == 9) {
				theAdmin.printUsersList(theUser);
			} else {
				System.out.println("programm is terminated");
				break;
			}
		}
		scanner.close();
	}
}
