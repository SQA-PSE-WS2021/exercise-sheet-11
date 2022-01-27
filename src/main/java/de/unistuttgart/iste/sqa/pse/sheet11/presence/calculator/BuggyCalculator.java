package de.unistuttgart.iste.sqa.pse.sheet11.presence.calculator;

/**
 * 
 * A Calculator. It has Bugs.
 *
 */
public final class BuggyCalculator implements Calculator {

	@Override
	public int add(final int summand1, final int summand2) {
		return summand1 + summand2;
	}

	@Override
	public int divide(final int dividend, final int divisor) {	
		if (dividend == Integer.MIN_VALUE || divisor == Integer.MIN_VALUE) {
			throw new IllegalArgumentException();
		}
		if (divisor == 0) {
			return 0;
		}
		int posDividend = Math.abs(dividend);
		int posDivisor = Math.abs(divisor);
		int posQuotient =  posDividend / posDivisor;
		int posResidual = posDividend % posDivisor;
		
		if (2 * posResidual > posDivisor || 2 * posResidual < 0) { 
			posQuotient++; 
		}
		
		return posQuotient * getResultSign(dividend, divisor);
	}
	
	/*@
	 @ ensures (dividend < 0 && divisor < 0 ==> \result == 1)
	 @ && (dividend > 0 && divisor > 0 ==> \result == 1)
	 @ && (dividend < 0 && divisor > 0 ==> \result == -1)
	 @ && (dividend > 0 && divisor < 0 ==> \result == -1);
	 @*/
	/**
	 * Calculates the sign of the result when dividing or multiplying to integer
	 * numbers
	 * 
	 * @param dividend the first number
	 * @param divisor the second number
	 * @return -1 if the result is smaller than 0, 1 otherwise
	 */
	private int getResultSign(final int dividend, final int divisor) {
		if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
			return 1;
		}
		return -1;
	}
	
	@Override
	public int addExact (int summand1, int summand2)  {
		return 0;
	}
	
	@Override
	public int abs (int value)  {
		return 0;
	}
	
	
}
