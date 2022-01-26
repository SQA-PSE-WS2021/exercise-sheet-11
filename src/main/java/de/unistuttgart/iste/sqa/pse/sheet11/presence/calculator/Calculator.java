package de.unistuttgart.iste.sqa.pse.sheet11.presence.calculator;

/**
 * A Calculator that provides a variety of mathematical operations.
 */
public interface Calculator {

	/*@
	 @ ensures summand1 + summand2 <= Integer.MAX_VALUE & summand1 + summand2 >=
	 @ Integer.MIN_VALUE ==> \result == summand1 + summand2;
	 @
	 @ ensures summand1 + summand2 > Integer.MAX_VALUE ==> \result ==
	 @ Integer.MIN_VALUE + (summand1 + summand2 - Integer.MAX_VALUE) - 1;
	 @
	 @ ensures summand1 + summand2 < Integer.MIN_VALUE ==> \result ==
	 @ Integer.MAX_VALUE + (summand1 + summand2 - Integer.MIN_VALUE) + 1;
	 @*/
	/**
	 * calculate the sum of two integer values.
	 * 
	 * if the sum is greater than {@linkplain Integer#MAX_VALUE Integer.MAX_VALUE}
	 * or smaller than {@linkplain Integer#MIN_VALUE Integer.MIN_VALUE} an overflow
	 * happens
	 * 
	 * @param summand1 first summand
	 * @param summand2 second summand
	 * @return the sum
	 */
	public int add(final int summand1, final int summand2);

	/*@
	 @ requires divisor != Integer.MIN_VALUE;
	 @ requires divisor != 0;
	 @ requires dividend != Integer.MIN_VALUE;
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
	 *                                  Integer.MIN_VALUE}
	 */
	public int divide(final int dividend, final int divisor);

	/*
	 * Operations for exercise 3
	 */

	/*@
	 @ requires summand1 + summand2 >= Integer.MIN_Value;
	 @ requires summand1 + summand2 <= Integer.MAX_Value;
	 @
	 @ ensures summand1 + summand2 <= Integer.MAX_VALUE && summand1 + summand2 >=
	 @ Integer.MIN_VALUE ==> \result == summand1 + summand2;
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
	 *                             Integer.MAX_Value or summand1 + summand2 are
	 *                             smaller than Integer.MIN_Value
	 * 
	 * @return sum of summand1 and summand2
	 * 
	 */
	public int addExact(final int summand1, final int summand2);

	/*@
	 @ requires value != Integer.MIN_Value;
	 @
	 @ ensures value >= 0 ==> \result == value;
	 @ ensures value < 0 ==> \result == -1 * value;
	 @
	 @*/
	/**
	 * calculates absolute value of a given integer value
	 * 
	 * if the value is equal to minimal Integer Value a Arithmetic Exception is
	 * thrown because Integer.MIN_Value is not displayable as a positive number
	 * 
	 * @param value value
	 * @return absolute value
	 * @throws ArithmeticException if value is equal to Integer.MIN_Value
	 */
	public int abs(final int value);

}
