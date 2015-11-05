package wordGame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);

			System.out.print("Enter number of rows: ");
			int rows = input.nextInt();
			System.out.print("Enter number of columns: ");
			int columns = input.nextInt();

			char[][] array = new char[rows][columns];

			System.out.println("Enter word table.");
			for (int row = 0; row < rows; row++) {
				for (int column = 0; column < columns; column++) {
					array[row][column] = input.next().charAt(0);
				}
			}

			System.out.println("Enter searched word: ");
			String word = input.next();

			input.close();

			int result = WordGame.solve(word, array);
			System.out.println(result);
	}

}
