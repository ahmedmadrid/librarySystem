package librarySystem;

public class Admin {
	private String name;
	public Admin() {
		name = "Default name";
	}
	public Admin(String name) {
		this.name = name;
	}

	public void printLibraryById(Book book) {
		book.setBookById();
		for(int i =0; i < book.getBookAdded(); i++) {
			System.out.println("Book "+ book.getName(i) + " ID "+ book.getId(i) + " Quanity " + book.getQuanity(i) + " Total_Borrowed "+ book.getTotalBorrowed(i));
		}
	}
	
	public void printLibraryByName(Book book) {
		book.setBookByName();
		book.handleSimilarNames();
		for(int i =0; i < book.getBookAdded(); i++) {
			System.out.println("Book "+ book.getName(i) + " ID "+ book.getId(i) + " Quanity " + book.getQuanity(i) + " Total_Borrowed "+ book.getTotalBorrowed(i));
		}
	}
	
	public void printUsersList(User theUser) {
		for(int i = 0; i < theUser.getAdded(); i++) {
			System.out.println(theUser.getName(i) + " "+ theUser.getId(i));
		}
	}
	
	public void printBorrowers(User theUser) {
		for(int i = 0; i < theUser.getAdded_i(); i++) {
			if(theUser.getBorrowerName(i) != null)
				System.out.print(theUser.getBorrowerName(i) + " ID ");
			for(int j = 1; j < theUser.getAdded_j(); j++) {
				if(theUser.getBorrowedBooksId(i, j) != null)
					System.out.print(theUser.getBorrowedBooksId(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	public String getName() {
		return name;
	}
}
