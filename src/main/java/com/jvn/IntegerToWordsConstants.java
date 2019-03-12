package com.jvn;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWordsConstants {

  public static final Map<Integer, String> BASE_MAP = getBaseMap();
  public static final Map<Integer, String> PLACE_MAP = getPlaceMap();

  private static Map<Integer, String> getBaseMap() {
    final Map<Integer, String> base = new HashMap<>();
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
    return base;
  }

  private static Map<Integer, String> getPlaceMap() {
    final Map<Integer, String> place = new HashMap<>();
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
    place.put(10, "nonillion");
    place.put(11, "decillion");
    return place;
  }

}
