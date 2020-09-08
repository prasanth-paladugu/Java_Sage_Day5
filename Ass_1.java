//Using command line arguments accept data and convert into celsius to farhenheit
import java.lang.Math;
class Ass_1
{
	public static void main(String args[])
	{
		float x = Float.parseFloat(args[0]);
		System.out.println("Farhenheit value is : " + (x * (9f / 5) + 32));
	}
}