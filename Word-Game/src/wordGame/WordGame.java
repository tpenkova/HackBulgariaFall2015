package wordGame;

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Въведете желания брой редове: ");
		int rows = input.nextInt();
		System.out.print("Въведете желания брой колони: ");
		int columns = input.nextInt();

		char[][] array = new char[rows][columns];

		System.out.println("Въведете таблицата с букви.");
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				array[row][column] = input.next().charAt(0);
			}
		}

		System.out.println("Въведете търсената дума: ");
		String word = input.next();

		input.close();

		int result = solve(word, array);
		System.out.println(result);

	}

	public static int solve(String word, char[][] array) {
		int rows = array.length;
		int columns = array[0].length;
		String reversedWord = new StringBuilder(word).reverse().toString();

		int result = horizontalSearch(word, rows, columns, array);
		result += horizontalSearch(reversedWord, rows, columns, array);

		result += verticalSearch(word, rows, columns, array);
		result += verticalSearch(reversedWord, rows, columns, array);

		result += mainDiagonalSearch(word, rows, columns, array);
		result += mainDiagonalSearch(reversedWord, rows, columns, array);

		result += secondaryDiagonalSearch(word, rows, columns, array);
		result += secondaryDiagonalSearch(reversedWord, rows, columns, array);

		return result;
	}

	public static void viewTable(int rows, int columns, char array[][]) {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}

	public static int horizontalSearch(String word, int rows, int columns,
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

	public static int verticalSearch(String word, int rows, int columns,
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

	public static int mainDiagonalSearch(String word, int rows, int columns,
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

	public static int secondaryDiagonalSearch(String word, int rows,
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

	private static void testHorizontalSearch() {
		int occurence = horizontalSearch("ivan", 2, 5, new char[][] {
				{ 'a', 'b', 'c', 'd', 'e' }, { 'a', 'b', 'c', 'd', 'e' } });
		System.out.println("Should be 0: " + occurence);

		occurence = horizontalSearch("ivan", 1, 5, new char[][] { { 'i', 'v',
				'a', 'n', 'i' } });
		System.out.println("Should be 1: " + occurence);

		occurence = horizontalSearch("ivan", 1, 8, new char[][] { { 'a', 'i',
				'v', 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 1: " + occurence);

		occurence = horizontalSearch("ivan", 2, 5, new char[][] {
				{ 'i', 'v', 'a', 'n', 'i' }, { 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 2: " + occurence);

		occurence = horizontalSearch("ivan", 1, 10, new char[][] { { 'i', 'v',
				'a', 'n', 'i', 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 2: " + occurence);

		occurence = horizontalSearch("ivan", 1, 3, new char[][] { { 'i', 'v',
				'a' } });
		System.out.println("Should be 0: " + occurence);

		occurence = horizontalSearch("ivan", 1, 4, new char[][] { { 'i', 'v',
				'a', 'n' } });
		System.out.println("Should be 1: " + occurence);
	}

	private static void testVerticalSearch() {
		int occurence = verticalSearch("ivan", 5, 2, new char[][] {
				{ 'i', 'v' }, { 'v', 'i' }, { 'a', 'v' }, { 'n', 'a' },
				{ 'i', 'n' } });
		System.out.println("Should be 2: " + occurence);

		occurence = verticalSearch("ivan", 3, 1, new char[][] { { 'i', 'v' },
				{ 'v', 'i' }, { 'a', 'v' } });
		System.out.println("Should be 0: " + occurence);
	}

	private static void testMainDiagonalSearch() {
		char[][] array = new char[][] { { 'i', 'i', 'i', 'i', 'i' },
				{ 'i', 'v', 'v', 'v', 'v' }, { 'i', 'v', 'a', 'a', 'a' },
				{ 'i', 'v', 'a', 'n', 'n' }, { 'i', 'v', 'a', 'n', 'i' } };
		int occurence = mainDiagonalSearch("ivan", 5, 5, array);
		System.out.println("Should be 3: " + occurence);
	}

	private static void testSecodaryDiagonalSearch() {
		char[][] array = new char[][] { { 'i', 'i', 'i', 'i', 'i' },
				{ 'i', 'v', 'v', 'v', 'v' }, { 'i', 'v', 'a', 'a', 'a' },
				{ 'i', 'v', 'a', 'n', 'n' }, { 'i', 'v', 'a', 'n', 'i' } };
		int occurence = secondaryDiagonalSearch("ivav", 5, 5, array);
		System.out.println("Should be 1: " + occurence);

		occurence = secondaryDiagonalSearch("iv", 5, 5, array);
		System.out.println("Should be 3: " + occurence);
	}
}
