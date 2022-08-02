package librarySystem;

public class User {
	// each user has a name and id
	private String[] name;
	private int[] id;
	private int added; // to add in arrays name and id dynamically
	
	private String[][] listOfBorrowers;
	// to add in borrowers list dynamically
	private int added_i;
	private int added_j;
	
	public User() {
		id = new int[1000];
		name = new String[1000];
		listOfBorrowers = new String[1000][1000];
		added = 0;
		added_i = 0;
		added_j = 2;
	}

	public void setUser_id_and_name(int id, String name) {
		this.id[added] = id;
		this.name[added] = name;
		added++;
	}

	public void borrowABook(Book book, String userName, String bookName) {
		int temp_bookName_idx = Integer.MIN_VALUE;
		boolean isUserName_found = false;
		boolean isBookName_found = false;

		for (int i = 0; i < this.added; i++) {
			if (name[i].equals(userName)) {
				isUserName_found = true;
				break;
			}
		}
		if (isUserName_found) {

			for (int i = 0; i < book.getBookAdded(); i++) {

				if (book.getName(i).equals(bookName)) {
					isBookName_found = true;
					temp_bookName_idx = i;
					break;
				}
			}

			if (isBookName_found) {
				 setBorrower(userName);
				 String ID = String.valueOf(book.getId(temp_bookName_idx));
				 setBorrowedBooksId(userName, ID);
				if (book.getQuanity(temp_bookName_idx) > 0) {
					book.setQuanity(temp_bookName_idx, -1);
					book.setTotalBorrowed(temp_bookName_idx, 1);
				} else {
					System.out.println("Sorry, all version of " + bookName + " is run out!");
				}

			} else {
				System.out.println(bookName + " is not recorded in our system");
			}

		} else {
			System.out.println("You're not on the system yet, Please contact the admin fpr his approval");
		}

	}
	
	public void returnAbook(Book book, String userName, String bookName) {
		int temp_bookName_idx = Integer.MIN_VALUE;
		
		for (int i = 0; i < book.getBookAdded(); i++) {
			if (book.getName(i).equals(bookName)) {
				temp_bookName_idx = i;
				break;
			}
		}
		book.setQuanity(temp_bookName_idx, 1);
		book.setTotalBorrowed(temp_bookName_idx, -1);
		String ID = String.valueOf(book.getId(temp_bookName_idx));
		
		for(int i =0; i <getAdded_i(); i++) {
			// if user name exists
			if(userName.equals(listOfBorrowers[i][0])) {
				// remove the last occurrence first
				for(int j =getAdded_j(); j > 0; j--) {
					if(ID.equals(listOfBorrowers[i][j])) {
						// assign corresponding book ID to null
						listOfBorrowers[i][j] = null;
						// and in case the user didn't borrow but one book, remove him form the list of borrowers
						if(listOfBorrowers[i][1] == null) {
							listOfBorrowers[i][0] = null;
						}
						break;
					}
				}
				break;
			}
		}
	}

	public int getId(int idx) {
		return id[idx];
	}

	public String getName(int idx) {
		return name[idx];
	}

	private void setBorrower(String borrower) {
		boolean unique = true;
		for(int i =0; i < getAdded_i(); i++) {
			if(listOfBorrowers[i][0].equals(borrower)) {
				unique = false;
				break;
			}
			else {
				unique = true;
			}
		}
		if(unique) {
			listOfBorrowers[added_i][0] = borrower;
			added_i++;
		}
	}
	
	private void setBorrowedBooksId(String borrower, String ID) {
		for(int i = 0; i < added_i; i++) {
			if(listOfBorrowers[i][0].equals(borrower)) {
				for(int j = 1; j < added_j; j++) {
					if(listOfBorrowers[i][j] == null) {
						listOfBorrowers[i][j] = ID;
						if( (added_j - j) == 1) {
							added_j +=1;
						}
						break;	
					}
				}
				break;
			}
		
		}
	}
	
	
	public String getBorrowerName(int idx_i) {
		return listOfBorrowers[idx_i][0];
	}
	
	public String getBorrowedBooksId(int idx_i, int idx_j) {
		return listOfBorrowers[idx_i][idx_j];
	}
	
	public int getAdded() {
		return added;
	}
	
	public int getAdded_i() {
		return added_i;
	}
	
	public int getAdded_j() {
		return added_j;
	}
}
