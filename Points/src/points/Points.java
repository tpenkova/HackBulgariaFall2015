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

		int sign = 1;
		char[] directionList = directions.toCharArray();

		for (int i = 0; i < directionList.length; i++) {
			switch (directionList[i]) {
			case '>':
				x += sign;
				break;
			case '<':
				x -= sign;
				break;
			case '^':
				y -= sign;
				break;
			case 'v':
				y += sign;
				break;
			case '~':
				sign *= -1;
				break;
			}
		}
		System.out.print("(" + x + ", " + y + ")");
	}
}
