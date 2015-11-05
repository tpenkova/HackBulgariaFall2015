package points;

import java.util.Scanner;

public class Points {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Starting point: ");
		int x = input.nextInt();
		int y = input.nextInt();

		String directions = input.next();

		input.close();

		int step = 1;
		char[] directionList = directions.toCharArray();

		for (int i = 0; i < directionList.length; i++) {
			switch (directionList[i]) {
			case '>':
				x += step;
				break;
			case '<':
				x -= step;
				break;
			case '^':
				y -= step;
				break;
			case 'v':
				y += step;
				break;
			case '~':
				step *= -1;
				break;
			}
		}
		System.out.print("(" + x + ", " + y + ")");
	}
}
