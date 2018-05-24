package iconAlgorithm;

public class MidArray {
	//array's rows and columns
	private static int rows;	
	private static int col;
	
	//mid point of rows and columns
	private static double midRow; 
	private static double midCol;
	
	public MidArray()
	{
		
	}
	
	/**
	 * Finds the middle coordinates of the row and col 
	 * of a two dimensional array
	 * @param array[][]
	 */
	public MidArray(int array[][]) 
	{
		rows = array.length;
		col = array[0].length;
		
		midRow = midPoint(rows);
		midCol = midPoint(col);
	}
	
	public static boolean isOdd(double x)
	{
		boolean odd;
		
		if(x % 2 != 0)
			odd = true;
		else
			odd = false;
		return odd;
	}
	
	
	/**
	 * Finds the middle point of a given number
	 * @param row
	 * @return
	 */
	public static double midPoint(double number)
	{
		double mid;
		
		mid = (number/2.0);
		
		return mid;
	}
	
	
	public String toString()
	{
		String coordinates = "Center is at coordinates: ";
		
		return coordinates + "[" +midRow+"]" + "[" +midCol+ "]";
	}
}
