package iconAlgorithm;

import java.util.Scanner;

public class ArrayShape {
	//length of row and col of which we need to find the middle point
	public static double longestRowLength;
	public static double longestColLength;
	
	//middle points of row and col
	public static double rowMid;
	public static double colMid;
	
	//coordinates of where to place the icon
	public static double row_coordinates;
	public static double col_coordinates;
	
	
	public ArrayShape() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes rowLength, colLength, rowMid and colMid
	 * @param arr[][]
	 */
	public ArrayShape(int arr[][])
	{
		Scanner kb = new Scanner(System.in);
		int input;
		int[][] array = new int[arr.length][arr[0].length];
		
		do {
			System.out.println("To define screen grid shape, enter 1 whenever the cell \n"
					+ "is part of the subwall you are targettinh, and 0 when its not \n");
	
			for (int row = 0; row < arr.length; row++) 
			{
				for (int col = 0; col < arr[0].length; col++) 
				{
					System.out.print("Cell [" +row+ "][" +col+ "]: ");
					array[row][col] = kb.nextInt();
				}
			}
			
			displayArray(array);
			
			System.out.println("Is this correct? (1 = yes/0 = no)");
			input = kb.nextInt();
			
		} while(input == 0);
		
		longestRowLength = getLongestRowLength(array);
		longestColLength = getLongestColLength(array);
		
		rowMid = MidArray.midPoint(longestRowLength);
		colMid = MidArray.midPoint(longestColLength);
		
		if(longestRowLength !=  longestColLength)
		{
			if(longestRowLength > longestColLength)
			{
				row_coordinates = getRowCoordinates();
				col_coordinates = rowMid;
			}
			
			else if(longestColLength > longestRowLength)
			{
				row_coordinates = colMid;
				col_coordinates = getColCoordinates();
			}
		}
		
		else
		{
			row_coordinates = (getRowCoordinates() );
			col_coordinates = (getColCoordinates());
		}
	}
	
	/**
	 * displays all variables for debugging purposes
	 */
	public static void test()
	{
		System.out.println("\nTEST \nLongest row len: " +longestRowLength+ 
							" longest col len: " +longestColLength);
		System.out.println("rowMid: "+rowMid + " colMid: " +colMid+ " row_coord: "+
							row_coordinates+ " col_coord: " +col_coordinates);
	}
	
	public static double getRowCoordinates()
	{
		return (row_coordinates + .5);	//.5 added for centering
	}
	
	public static double getColCoordinates()
	{
		return (col_coordinates + .5);
	}
	
	public static void displayArray(int array[][])
	{
		System.out.println("--- Youre grid ---");
		
		for (int row = 0; row < array.length; row++) 
		{
			System.out.print("\t");
			
			for (int col = 0; col < array[0].length; col++) 
			{
				System.out.print(array[row][col]+ " ");
			}
			System.out.print("\n");
		}
	}
	/**
	 * Returns longest row length in array
	 * @param arr[][]
	 * @return max
	 */
	public static int getLongestRowLength(int arr[][])
	{
		int counter = 0;
		int length = 0;
		
		for (int row = 0; row < arr.length; row++) 
		{
			for (int col = 0; col < arr[0].length; col++) 
			{
				if(arr[row][col] == 1)
					counter++;
				if(counter > length)
				{
					length = counter;
					row_coordinates = row;
				}
			}
			counter = 0; //reset counter
		}
		
		return (length);
	}
	
	/**
	 * Returns longest col in array
	 * @param arr[][]
	 * @return max
	 */
	public static int getLongestColLength(int arr[][])
	{
		int counter = 0;
		int length = 0;
		
		for (int col = 0; col < arr[0].length; col++) 
		{
			for (int row = 0; row < arr.length; row++)
			{
				if(arr[row][col] == 1)
					counter++;
				if(counter > length)
				{
					length = counter;
					col_coordinates = col;
				}
			}
			counter = 0; //reset counter
		}
		
		return (length);
	}
	
	public String toString()
	{
		return ("Center is at coordinates : [" +(row_coordinates)+ "][" +(col_coordinates)+ "]");
	}
	
}
