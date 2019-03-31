package com.jvn;

import java.math.BigInteger;

public class IntegerToWordsObjectOriented {

  private BigInteger integer;

  public IntegerToWordsObjectOriented(int integer) {
    this(BigInteger.valueOf(integer));
  }

  public IntegerToWordsObjectOriented(BigInteger integer) {
    this.setInteger(integer);
  }

  public BigInteger getInteger() {
    return integer;
  }

  public void setInteger(BigInteger integer) {
    this.integer = integer;
  }

  public String toWords() {
    return IntegerToWordsFunctional.toWords(integer);
  }

}
