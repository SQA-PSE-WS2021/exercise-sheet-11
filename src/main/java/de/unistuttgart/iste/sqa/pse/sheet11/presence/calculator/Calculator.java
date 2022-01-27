package de.unistuttgart.iste.sqa.pse.sheet11.presence.calculator;

/**
 * A Calculator that provides a variety of mathematical operations.
 */
public interface Calculator {

	/*@
	 @ ensures summand1 + summand2 <= INTEGER.MAX_VALUE & summand1 + summand2 >=
	 @ INTEGER.MIN_VALUE ==> \result == summand1 + summand2;
	 @
	 @ ensures summand1 + summand2 > INTEGER.MAX_VALUE ==> \result ==
	 @ INTEGER.MIN_VALUE + (summand1 + summand2 - INTEGER.MAX_VALUE) - 1;
	 @
	 @ ensures summand1 + summand2 < INTEGER.MIN_VALUE ==> \result ==
	 @ INTEGER.MAX_VALUE + (summand1 + summand2 - INTEGER.MIN_VALUE) + 1;
	 @*/
	/**
	 * calculate the sum of two integer values.
	 * 
	 * if the sum is greater than {@linkplain Integer#MAX_VALUE INTEGER.MAX_VALUE}
	 * or smaller than {@linkplain Integer#MIN_VALUE INTEGER.MIN_VALUE} an overflow
	 * happens
	 * 
	 * @param summand1 first summand
	 * @param summand2 second summand
	 * @return the sum
	 */
	public int /*@ pure @*/ add(final int summand1, final int summand2);

	/*@
	 @ requires (divisor != INTEGER.MIN_VALUE && divisor != 0) && (dividend != INTEGER.MIN_VALUE);
	 @
	 @ ensures divisor != 0 ==> \result == correctly rounded quotient;
	 @
	 @*/
	/**
	 * Calculates the quotient of two integer values.
	 * 
	 * The result is correctly rounded. That is, the result is rounded up for
	 * decimals greater than or equal to 0.5 and rounded down for decimal smaller
	 * than 0.5. For negative numbers 'down' means towards zero and 'up' means away
	 * from zero. E.g a result of -42,1 is rounded down to -42 and a result of -42,8
	 * is rounded up to -43.
	 *
	 * @param dividend number to be divided
	 * @param divisor  number to divide by
	 * @return the quotient
	 * @throws ArithmeticException      if {@code divisor} is zero
	 * @throws IllegalArgumentException if {@code divisor} or {@code dividend} is
	 *                                  {@linkplain Integer#MIN_VALUE
	 *                                  INTEGER.MIN_VALUE}
	 */
	public int /*@ pure @*/ divide(final int dividend, final int divisor);

	/*
	 * Operations for exercise 2
	 */

	/*@
	 @ requires (summand1 + summand2 >= INTEGER.MIN_VALUE)
	 @ && (summand1 + summand2 <= INTEGER.MAX_VALUE);
	 @
	 @ ensures summand1 + summand2 <= INTEGER.MAX_VALUE && summand1 + summand2 >=
	 @ INTEGER.MIN_VALUE ==> \result == summand1 + summand2;
	 @
	 @*/
	/**
	 * 
	 * calculates the sum of two integer values
	 * 
	 * If the sum is greater than the integer range an ArithmeticException is thrown
	 * with an Error Message, which indicates that an Integer Overflow occured.
	 * 
	 * If the sum is lesser than the integer range an ArithmeticException is thrown
	 * with an Error Message. Which indicates that an Integer Underflow occured
	 * 
	 * @param summand1 first summand
	 * @param summand2 second summand
	 * @throws ArithmeticException if summand1 + summand2 are greater than
	 *                             INTEGER.MAX_VALUE or summand1 + summand2 are
	 *                             smaller than INTEGER.MIN_VALUE
	 * 
	 * @return sum of summand1 and summand2
	 * 
	 */
	public int /*@ pure @*/ addExact(final int summand1, final int summand2);

	/*@
	 @ requires value != INTEGER.MIN_VALUE;
	 @
	 @ ensures (value >= 0 ==> \result == value)
	 @ && (value < 0 ==> \result == -1 * value);
	 @*/
	/**
	 * calculates absolute value of a given integer value
	 * 
	 * if the value is equal to minimal Integer Value a Arithmetic Exception is
	 * thrown because INTEGER.MIN_VALUE is not displayable as a positive number
	 *
	 * @return absolute value, that is |value-0|.
	 * @throws ArithmeticException if value is equal to INTEGER.MIN_VALUE
	 */
	public int /*@ pure @*/ abs(final int value);

}
