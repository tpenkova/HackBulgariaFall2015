package wordGame;

public class Tests {

	static void testHorizontalSearch() {
		int occurence = Search.horizontalSearch("ivan", 2, 5, new char[][] {
				{ 'a', 'b', 'c', 'd', 'e' }, { 'a', 'b', 'c', 'd', 'e' } });
		System.out.println("Should be 0: " + occurence);

		occurence = Search.horizontalSearch("ivan", 1, 5, new char[][] { { 'i',
				'v', 'a', 'n', 'i' } });
		System.out.println("Should be 1: " + occurence);

		occurence = Search.horizontalSearch("ivan", 1, 8, new char[][] { { 'a',
				'i', 'v', 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 1: " + occurence);

		occurence = Search.horizontalSearch("ivan", 2, 5, new char[][] {
				{ 'i', 'v', 'a', 'n', 'i' }, { 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 2: " + occurence);

		occurence = Search.horizontalSearch("ivan", 1, 10, new char[][] { {
				'i', 'v', 'a', 'n', 'i', 'i', 'v', 'a', 'n', 'i' } });
		System.out.println("Should be 2: " + occurence);

		occurence = Search.horizontalSearch("ivan", 1, 3, new char[][] { { 'i',
				'v', 'a' } });
		System.out.println("Should be 0: " + occurence);

		occurence = Search.horizontalSearch("ivan", 1, 4, new char[][] { { 'i',
				'v', 'a', 'n' } });
		System.out.println("Should be 1: " + occurence);
	}

	static void testVerticalSearch() {
		int occurence = Search.verticalSearch("ivan", 5, 2, new char[][] {
				{ 'i', 'v' }, { 'v', 'i' }, { 'a', 'v' }, { 'n', 'a' },
				{ 'i', 'n' } });
		System.out.println("Should be 2: " + occurence);

		occurence = Search.verticalSearch("ivan", 3, 1, new char[][] {
				{ 'i', 'v' }, { 'v', 'i' }, { 'a', 'v' } });
		System.out.println("Should be 0: " + occurence);
	}

	static void testMainDiagonalSearch() {
		char[][] array = new char[][] { { 'i', 'i', 'i', 'i', 'i' },
				{ 'i', 'v', 'v', 'v', 'v' }, { 'i', 'v', 'a', 'a', 'a' },
				{ 'i', 'v', 'a', 'n', 'n' }, { 'i', 'v', 'a', 'n', 'i' } };
		int occurence = Search.mainDiagonalSearch("ivan", 5, 5, array);
		System.out.println("Should be 3: " + occurence);
	}

	static void testSecodaryDiagonalSearch() {
		char[][] array = new char[][] { { 'i', 'i', 'i', 'i', 'i' },
				{ 'i', 'v', 'v', 'v', 'v' }, { 'i', 'v', 'a', 'a', 'a' },
				{ 'i', 'v', 'a', 'n', 'n' }, { 'i', 'v', 'a', 'n', 'i' } };
		int occurence = Search.secondaryDiagonalSearch("ivav", 5, 5, array);
		System.out.println("Should be 1: " + occurence);

		occurence = Search.secondaryDiagonalSearch("iv", 5, 5, array);
		System.out.println("Should be 3: " + occurence);
	}

}
