package com.jvn;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Converts integers to the English equivalent
 */
public class IntegerToWordsFunctional {

  private static final BigInteger THOUSAND = BigInteger.valueOf(1000);
  private static final BigInteger ZERO = BigInteger.ZERO;

  private IntegerToWordsFunctional(){}

  /**
   * Converts an integer to its English equivalent.
   * @param integer The integer.
   * @return The English equivalent.
   */
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
   * @param integer The number to be converted.
   * @return The converted number.
   */
  private static String toWordBase(int integer) {
    return IntegerToWordsConstants.BASE_MAP.get(integer);
  }

  /**
   * Converts words to string place.
   * @param integer The number to be converted.
   * @return The converted number.
   */
  private static String toWordPlace(int integer) {
    return IntegerToWordsConstants.PLACE_MAP.get(integer);
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
