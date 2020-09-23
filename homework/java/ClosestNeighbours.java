public class ClosestNeighbours
{
    public static void main(String[] args) {

	int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
	int[] result = findClosest(myArray);
	
	// print the elements of the resulting array
	for (int res : result)
	{
	    System.out.println(res);
	}
    }

    private static int[] findClosest(int[] numbers) {
	// hint: remember Math.abs();
	if (numbers.length <= 1) return numbers;

	int[] closestNeighbours = new int[2];

	for (int i = 0; i < numbers.length - 1; i++)
	{
	    if (i == 0 || Math.abs(numbers[i] - numbers[i+1]) < Math.abs(closestNeighbours[0] - closestNeighbours[1]))
	    {
		closestNeighbours[0] = numbers[i];
		closestNeighbours[1] = numbers[i+1];
	    }
	}

	return closestNeighbours;
    }
}
