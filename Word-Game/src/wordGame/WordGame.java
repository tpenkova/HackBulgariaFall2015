package wordGame;

public class WordGame {

	static int solve(String word, char[][] array) {
		int rows = array.length;
		int columns = array[0].length;
		String reversedWord = new StringBuilder(word).reverse().toString();

		int result = Search.horizontalSearch(word, rows, columns, array);
		result += Search.horizontalSearch(reversedWord, rows, columns, array);

		result += Search.verticalSearch(word, rows, columns, array);
		result += Search.verticalSearch(reversedWord, rows, columns, array);

		result += Search.mainDiagonalSearch(word, rows, columns, array);
		result += Search.mainDiagonalSearch(reversedWord, rows, columns, array);

		result += Search.secondaryDiagonalSearch(word, rows, columns, array);
		result += Search.secondaryDiagonalSearch(reversedWord, rows, columns, array);

		return result;
	}	
}
