package com.jvn;

import java.math.BigInteger;

public class IntegerToWordsObjectOriented {

  private BigInteger integer;

  public IntegerToWordsObjectOriented(Object integer) {
    if (integer instanceof Integer) this.setInteger((Integer) integer);
    else if (integer instanceof BigInteger) this.setInteger((BigInteger) integer);
    else throw new IllegalArgumentException("Integer must be of type Integer of BigInteger.");
  }

  public void setInteger(int integer) {
    this.setInteger(BigInteger.valueOf(integer));
  }

  public void setInteger(BigInteger integer) {
    this.integer = integer;
  }

  public BigInteger getInteger() {
    return integer;
  }

  public String toWords() {
    return IntegerToWordsFunctional.toWords(integer);
  }

}
