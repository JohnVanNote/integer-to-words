package com.jvn;

import static com.jvn.IntegerToWords.toWords;

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
    };
  }

  @Test(dataProvider = "numbas")
  public void toWords_Numbers_Words(int n, String s) {
    Assert.assertEquals(toWords(n), s);
  }

}
