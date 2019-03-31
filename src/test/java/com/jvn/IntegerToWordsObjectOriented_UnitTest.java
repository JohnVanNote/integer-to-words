package com.jvn;

import java.math.BigInteger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerToWordsObjectOriented_UnitTest extends AbstractIntegerToWordsBaseTest_UnitTest {

  private IntegerToWordsObjectOriented integer;

  @Test(dataProvider = "numbas")
  public void toWords_NonNegativeNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    integer = new IntegerToWordsObjectOriented(nonNegativeNumber);
    Assert.assertEquals(integer.toWords(), words);
  }

  @Test(dataProvider = "numbas")
  public void toWords_NonPositiveNumbers_CreatesEquivalentWords(Object nonNegativeNumber, String words) {
    Object nonPositiveNumber;
    if (nonNegativeNumber instanceof BigInteger) {
      nonPositiveNumber = ((BigInteger) nonNegativeNumber).multiply(BigInteger.valueOf(-1));
    } else {
      nonPositiveNumber = ((Integer) nonNegativeNumber) * -1;
    }
    integer = new IntegerToWordsObjectOriented(nonPositiveNumber);
    if (nonNegativeNumber instanceof Integer && (Integer)nonNegativeNumber == 0) Assert.assertEquals(integer.toWords(), words);
    else Assert.assertEquals(integer.toWords(), "negative " + words);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void toWords_NonIntegerOrBigInteger_IllegalArgumentArgumentException() {
    integer = new IntegerToWordsObjectOriented("Se7en");
  }

}
