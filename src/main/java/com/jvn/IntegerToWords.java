package com.jvn;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Converts integers to the English equivalent
 */
public class IntegerToWords {

  private static final BigInteger THOUSAND = BigInteger.valueOf(1000);
  private static final BigInteger ZERO = BigInteger.ZERO;

  private IntegerToWords(){}

  public static String toWords(int integer) {
    return toWords(new BigInteger(Integer.toString(integer)));
  }

  /**
   * Converts an integer to its English equivalent.
   * @param integer The integer.
   * @return The English equivalent.
   */
  public static String toWords(BigInteger integer) {
    BigInteger absoluteInteger = integer.abs();
    Map<Integer, BigInteger> splitNumber = new TreeMap<>();

    for (int i=0; !absoluteInteger.equals(ZERO); i++) {
      splitNumber.put(i, absoluteInteger.mod(THOUSAND));
      absoluteInteger = absoluteInteger.divide(THOUSAND);
    }

    Deque<String> deque = new ArrayDeque<>();
    int splitNumLength = splitNumber.size();
    for (int i=0; i<splitNumLength; i++) {
      int digits = splitNumber.get(i).intValue();

      // Lets get the place
      if (digits != 0) {
        String placeWord = toWordPlace(i);
        updateDeque(deque, placeWord);
      }

      // Lets see if we can take care of the tens and ones at once
      int tensNumber = digits % 100;
      String tensWord = toWordBase(tensNumber);

      if (tensWord != null) {
        updateDeque(deque, tensWord);
      } else {

        // Now for the ones
        int onesDigit = digits % 10;
        String onesWord = toWordBase(onesDigit);
        updateDeque(deque, onesWord);

        // Lets get the second one and remove the remainder
        int tensNumberNoRemainder = (digits % 100) / 10 * 10;
        String tensWordNoRemainder = toWordBase(tensNumberNoRemainder);
        updateDeque(deque, tensWordNoRemainder);

      }

      // Lets get the first digit
      int hundredsDigit = digits / 100;
      String hundredsWord = toWordBase(hundredsDigit);
      if (!"".equals(hundredsWord)) updateDeque(deque, "hundred");
      updateDeque(deque, hundredsWord);
    }

    if (integer.compareTo(ZERO) < 0) updateDeque(deque, "negative");

    String dequeString = dequeToString(deque);
    return dequeString.isEmpty() ? "zero" : dequeString;
  }

  /**
   * Converts words to string base.
   * @param number The number to be converted.
   * @return The converted number.
   */
  private static String toWordBase(int number) {
    int min = 0;
    int max = 99;
    if (number < min || number > max)
      throw new IllegalArgumentException(String.format("Input argument number must be in range [%d, %d].", min, max));

    Map<Integer, String> base = new HashMap<>();
    base.put(0, "");
    base.put(1, "one");
    base.put(2, "two");
    base.put(3, "three");
    base.put(4, "four");
    base.put(5, "five");
    base.put(6, "six");
    base.put(7, "seven");
    base.put(8, "eight");
    base.put(9, "nine");
    base.put(10, "ten");
    base.put(11, "eleven");
    base.put(12, "twelve");
    base.put(13, "thirteen");
    base.put(14, "fourteen");
    base.put(15, "fifteen");
    base.put(16, "sixteen");
    base.put(17, "seventeen");
    base.put(18, "eighteen");
    base.put(19, "nineteen");
    base.put(20, "twenty");
    base.put(30, "thirty");
    base.put(40, "forty");
    base.put(50, "fifty");
    base.put(60, "sixty");
    base.put(70, "seventy");
    base.put(80, "eighty");
    base.put(90, "ninety");

    return base.get(number);
  }

  /**
   * Converts words to string place.
   * @param number The number to be converted.
   * @return The converted number.
   */
  private static String toWordPlace(int number) {
    int min = 0;
    int max = 9;
    if (number < min || number > max)
      throw new IllegalArgumentException(String.format("Input argument number must be in range [%d, %d].", min, max));

    Map<Integer, String> place = new HashMap<>();
    place.put(0, "");
    place.put(1, "thousand");
    place.put(2, "million");
    place.put(3, "billion");
    place.put(4, "trillion");
    place.put(5, "quadrillion");
    place.put(6, "quintillion");
    place.put(7, "sextillion");
    place.put(8, "septillion");
    place.put(9, "octillion");

    return place.get(number);
  }

  /**
   * Converts a deque to a readable number string.
   * @param deque The deque.
   * @return The readable string.
   */
  private static String dequeToString(Deque<String> deque) {
    StringBuilder string = new StringBuilder();

    Iterator<String> it = deque.iterator();
    while (it.hasNext()) {
      string.append(it.next());
      if (it.hasNext()) string.append(" ");
    }

    return string.toString();
  }

  /**
   * Updates a deque but ignores all the empty string and null string.
   * @param deque The deque.
   * @param elem The element to be updated.
   */
  private static void updateDeque(Deque<String> deque, String elem) {
    if (elem != null && !elem.isEmpty()) deque.push(elem);
  }

}
