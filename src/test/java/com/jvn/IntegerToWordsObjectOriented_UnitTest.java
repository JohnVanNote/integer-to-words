package com.jvn;

import java.math.BigInteger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerToWordsObjectOriented_UnitTest extends AbstractIntegerToWordsBaseTest_UnitTest {

  private IntegerToWordsObjectOriented integer;

  @Test(dataProvider = "numbas")
  public void toWords_NonNegativeNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    if (nonNegativeNumber instanceof BigInteger) integer = new IntegerToWordsObjectOriented((BigInteger) nonNegativeNumber);
    else integer = new IntegerToWordsObjectOriented((Integer) nonNegativeNumber);
    Assert.assertEquals(integer.toWords(), words);
  }

  @Test(dataProvider = "numbas")
  public void toWords_NonPositiveNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    if (nonNegativeNumber instanceof BigInteger) {
      BigInteger nonNegativeNum = (BigInteger) nonNegativeNumber;
      BigInteger nonPositiveNum = nonNegativeNum.multiply(BigInteger.valueOf(-1));
      integer = new IntegerToWordsObjectOriented((nonPositiveNum));
      Assert.assertEquals(integer.toWords(), "negative " + words);
    } else {
      int nonPositiveNumber = ((Integer) nonNegativeNumber) * -1;
      integer = new IntegerToWordsObjectOriented(nonPositiveNumber);
      if (nonPositiveNumber == 0) Assert.assertEquals(integer.toWords(), words);
      else Assert.assertEquals(integer.toWords(), "negative " + words);
    }
  }

}
