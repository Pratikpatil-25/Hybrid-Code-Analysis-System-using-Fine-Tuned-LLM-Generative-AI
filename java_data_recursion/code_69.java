public class Pr5_2		{
	public static void main(String[] args)
	{
		double numerator = 1;
		double sum = 0;
		for (double firstDenominator = 1; firstDenominator <= 100; firstDenominator++) {
			double secondDenominator = firstDenominator;
			double term = 1 / (secondDenominator * firstDenominator);
			sum = sum + term;
		}
		IBIO.output(sum);
	}
}