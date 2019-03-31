package com.jvn;

import static com.jvn.IntegerToWordsFunctional.toWords;

import java.math.BigInteger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit tests for {@link IntegerToWordsFunctional}.
 */
public class IntegerToWordsFunctional_UnitTest extends AbstractIntegerToWordsBaseTest_UnitTest {

  @Test(dataProvider = "numbas")
  public void toWords_NonNegativeNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    if (nonNegativeNumber instanceof BigInteger) Assert.assertEquals(toWords((BigInteger) nonNegativeNumber), words);
    else Assert.assertEquals(toWords((Integer) nonNegativeNumber), words);
  }

  @Test(dataProvider = "numbas")
  public void toWords_NonPositiveNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    if (nonNegativeNumber instanceof BigInteger) {
      BigInteger nonNegativeNum = (BigInteger) nonNegativeNumber;
      BigInteger nonPositiveNum = nonNegativeNum.multiply(BigInteger.valueOf(-1));
      if (nonPositiveNum.equals(BigInteger.ZERO)) Assert.assertEquals(toWords(nonPositiveNum), words);
      else Assert.assertEquals(toWords(nonPositiveNum), "negative " + words);
    } else {
      int nonPositiveNumber = ((Integer) nonNegativeNumber) * -1;
      if (nonPositiveNumber == 0) Assert.assertEquals(toWords(nonPositiveNumber), words);
      else Assert.assertEquals(toWords(nonPositiveNumber), "negative " + words);
    }
  }

}
