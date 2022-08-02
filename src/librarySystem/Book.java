package librarySystem;
// do a function for swapping

public class Book {
	private int[] id;
	private String[] name;
	private int[] quanity;
	private int[] total_borrowed;
	private int added = 0;

	public Book() {
		id = new int[1000];
		name = new String[1000];
		quanity = new int[1000];
		total_borrowed = new int[1000];
	}

	public void add_book(int id, String name, int quanity) {
		this.id[added] = id;
		this.name[added] = name;
		this.quanity[added] = quanity;
		added++;
	}

	public void search_by_perfix(String perfix) {
		int notExist = 0;
		for (int i = 0; i < added; i++) {
			int j = 0;
			int matchingChars = 0;
			while (j < perfix.length()) {
				if (perfix.charAt(j) == name[i].charAt(j)) {
					j++;
					matchingChars++;
				} else {
					break;
				}
			}
			if (matchingChars == perfix.length())
				System.out.println(name[i]);
			else
				notExist++;
		}
		if (notExist == added)
			System.out.println(perfix + " doesn't exist");
	}

	private void swap(int idx, int temp_idx, String[] name, int[] id, int[] quanity) {
		String temp_name;
		int temp_id;
		int temp_quanity;

		temp_name = name[idx];
		name[idx] = name[temp_idx];
		name[temp_idx] = temp_name;

		temp_id = id[idx];
		id[idx] = id[temp_idx];
		id[temp_idx] = temp_id;

		temp_quanity = quanity[idx];
		quanity[idx] = quanity[temp_idx];
		quanity[temp_idx] = temp_quanity;
	}

	public void setBookById() {
		int min = Integer.MIN_VALUE;

		int temp_idx = 0;
		for (int j = 0; j < (added - 1); j++) {
			min = id[j];

			int i = j + 1;
			while (i < added) {
				if (id[i] < min) {
					min = id[i];
					temp_idx = i;
				}
				i++;
			}
			if (id[j] != min)
				swap(j, temp_idx, name, id, quanity);
		}
	}

	public void setBookByName() {
		int temp_idx = Integer.MIN_VALUE;
		for (int i = 0; i < added - 1; i++) {
			int min = name[i].charAt(0);
			int j = i;
			while (j < added) {
				int letter = name[j].charAt(0);
				if (letter < min) {
					min = letter;
					temp_idx = j;
				}
				++j;
			}
			if (min != name[i].charAt(0))
				swap(i, temp_idx, name, id, quanity);
		}
	}

	public void handleSimilarNames() {
		for (int i = 0; i < getBookAdded() - 1; i++) {

			if (name[i].charAt(0) == name[i + 1].charAt(0)) {
				
				// imagine: abcde (5), and abcdef (6). where is charAt(6) in abcde?!
				int smallest = name[i].length();
				if (name[i + 1].length() < smallest) {
					smallest = name[i + 1].length();
					swap(i, i + 1, name, id, quanity);
				} else if (name[i + 1].length() == name[i].length()) {
					int j = 1;
					while (j < smallest) {
						if (name[i].charAt(j) != name[i + 1].charAt(j) && name[i].charAt(j) > name[i + 1].charAt(j)) {
							swap(i, i + 1, name, id, quanity);
							break;
						}
						j++;
					}
				}

			}
		}
	}

	public void setQuanity(int idx, int n) {
		this.quanity[idx] += n;
	}

	public void setTotalBorrowed(int idx, int n) {
		this.total_borrowed[idx] += n;
	}

	public int getId(int idx) {
		return id[idx];
	}

	public String getName(int idx) {
		return name[idx];
	}

	public int getQuanity(int idx) {
		return quanity[idx];
	}

	public int getTotalBorrowed(int idx) {
		return total_borrowed[idx];
	}

	public int getBookAdded() {
		return added;
	}

}
