package iconAlgorithm;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int subwalls;
		int height, width;
		Scanner kb = new Scanner(System.in);
		int input = 1;
		
		do {
		System.out.println("How many subwalls?");
		subwalls = kb.nextInt();
		
		System.out.println("Grid height");
		height = kb.nextInt();
		System.out.println("Grid width");
		width = kb.nextInt();
		
		int[][] grid = new int[height][width];
		
		switch (subwalls) 
		{
			case 1: 
				MidArray mid = new MidArray(grid);
				
				System.out.println(mid);
				break;
			case 2:
					ArrayShape shape = new ArrayShape(grid);
					System.out.println(shape);
					shape.test();
					break;
		}
		System.out.println("\nWould you like to try another grid? "
				+ "(1 = yes/0 = no)");
		input = kb.nextInt();
		} while(input == 1);

	}
}
