package com.jvn;

import static com.jvn.IntegerToWords.toWords;

import java.math.BigInteger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit tests for {@link IntegerToWords}.
 */
public class IntegerToWords_UnitTest {

  @DataProvider
  public Object[][] numbas() {
    return new Object[][]{
        {0, "zero"},
        {1, "one"},
        {2, "two"},
        {3, "three"},
        {4, "four"},
        {5, "five"},
        {6, "six"},
        {7, "seven"},
        {8, "eight"},
        {9, "nine"},
        {10, "ten"},
        {11, "eleven"},
        {12, "twelve"},
        {13, "thirteen"},
        {14, "fourteen"},
        {15, "fifteen"},
        {16, "sixteen"},
        {17, "seventeen"},
        {18, "eighteen"},
        {19, "nineteen"},
        {20, "twenty"},
        {21, "twenty one"},
        {30, "thirty"},
        {32, "thirty two"},
        {40, "forty"},
        {43, "forty three"},
        {50, "fifty"},
        {54, "fifty four"},
        {60, "sixty"},
        {65, "sixty five"},
        {70, "seventy"},
        {76, "seventy six"},
        {80, "eighty"},
        {87, "eighty seven"},
        {90, "ninety"},
        {98, "ninety eight"},
        {100, "one hundred"},
        {101, "one hundred one"},
        {103, "one hundred three"},
        {107, "one hundred seven"},
        {109, "one hundred nine"},
        {113, "one hundred thirteen"},
        {127, "one hundred twenty seven"},
        {131, "one hundred thirty one"},
        {1000, "one thousand"},
        {2500, "two thousand five hundred"},
        {3750, "three thousand seven hundred fifty"},
        {4875, "four thousand eight hundred seventy five"},
        {10000, "ten thousand"},
        {100000, "one hundred thousand"},
        {1000000, "one million"},
        {10000000, "ten million"},
        {100000000, "one hundred million"},
        {1000000000, "one billion"},
        {new BigInteger("10000000000"), "ten billion"}
    };
  }

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
