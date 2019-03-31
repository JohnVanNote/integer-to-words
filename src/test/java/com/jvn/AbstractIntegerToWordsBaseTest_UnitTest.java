package com.jvn;

import java.math.BigInteger;
import org.testng.annotations.DataProvider;

public class AbstractIntegerToWordsBaseTest_UnitTest {

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
        {new BigInteger("10000000000"), "ten billion"},
        {new BigInteger("100000000000"), "one hundred billion"},
        {new BigInteger("1000000000000"), "one trillion"},
        {new BigInteger("10000000000000"), "ten trillion"},
        {new BigInteger("100000000000000"), "one hundred trillion"},
        {new BigInteger("1000000000000000"), "one quadrillion"},
        {new BigInteger("10000000000000000"), "ten quadrillion"},
        {new BigInteger("100000000000000000"), "one hundred quadrillion"},
        {new BigInteger("1000000000000000000"), "one quintillion"},
        {new BigInteger("10000000000000000000"), "ten quintillion"},
        {new BigInteger("100000000000000000000"), "one hundred quintillion"},
        {new BigInteger("1000000000000000000000"), "one sextillion"},
        {new BigInteger("10000000000000000000000"), "ten sextillion"},
        {new BigInteger("100000000000000000000000"), "one hundred sextillion"},
        {new BigInteger("1000000000000000000000000"), "one septillion"},
        {new BigInteger("10000000000000000000000000"), "ten septillion"},
        {new BigInteger("100000000000000000000000000"), "one hundred septillion"},
        {new BigInteger("1000000000000000000000000000"), "one octillion"},
        {new BigInteger("10000000000000000000000000000"), "ten octillion"},
        {new BigInteger("100000000000000000000000000000"), "one hundred octillion"},
        {new BigInteger("1000000000000000000000000000000"), "one nonillion"},
        {new BigInteger("10000000000000000000000000000000"), "ten nonillion"},
        {new BigInteger("100000000000000000000000000000000"), "one hundred nonillion"},
        {new BigInteger("1000000000000000000000000000000000"), "one decillion"},
        {new BigInteger("10000000000000000000000000000000000"), "ten decillion"},
        {new BigInteger("100000000000000000000000000000000000"), "one hundred decillion"},
        {new BigInteger("123456789123456789123456789123456789"),
            ""
                + "one hundred twenty three decillion "
                + "four hundred fifty six nonillion "
                + "seven hundred eighty nine octillion "
                + "one hundred twenty three septillion "
                + "four hundred fifty six sextillion "
                + "seven hundred eighty nine quintillion "
                + "one hundred twenty three quadrillion "
                + "four hundred fifty six trillion "
                + "seven hundred eighty nine billion "
                + "one hundred twenty three million "
                + "four hundred fifty six thousand "
                + "seven hundred eighty nine"
        },
    };
  }

}
