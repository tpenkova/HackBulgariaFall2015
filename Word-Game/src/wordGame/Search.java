package wordGame;

public class Search {
	
	static int horizontalSearch(String word, int rows, int columns,
			char[][] array) {

		int row, column;
		int count = 0;

		for (row = 0; row < rows; row++) {
			for (column = 0; column < columns; column++) {
				if (columns - column < word.length()) {
					break;
				}

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != array[row][column + i]) {
						break;
					}
					if (i == word.length() - 1) {
						count++;
					}
				}

			}
		}
		return count;
	}

	static int verticalSearch(String word, int rows, int columns,
			char[][] array) {
		int row, column;
		int count = 0;

		for (row = 0; row < rows; row++) {
			for (column = 0; column < columns; column++) {
				if (rows - row < word.length()) {
					break;
				}

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != array[row + i][column]) {
						break;
					}
					if (i == word.length() - 1) {
						count++;
					}
				}

			}
		}
		return count;
	}

	static int mainDiagonalSearch(String word, int rows, int columns,
			char[][] array) {
		int row, column;
		int count = 0;

		for (row = 0; row < rows; row++) {
			for (column = 0; column < columns; column++) {
				if (rows - row < word.length()
						|| columns - column < word.length()) {
					break;
				}

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != array[row + i][column + i]) {
						break;
					}
					if (i == word.length() - 1) {
						count++;
					}
				}

			}
		}
		return count;
	}

	static int secondaryDiagonalSearch(String word, int rows,
			int columns, char[][] array) {
		int row, column;
		int count = 0;

		for (row = 0; row < rows; row++) {
			for (column = 0; column < columns; column++) {
				if (rows - row < word.length()) {
					break;
				}

				if (column + 1 < word.length()) {
					continue;
				}

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != array[row + i][column - i]) {
						break;
					}
					if (i == word.length() - 1) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
