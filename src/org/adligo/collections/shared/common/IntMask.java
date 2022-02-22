package org.adligo.collections.shared.common;

import java.math.BigInteger;

/**
 * A collection of bit masks for BigIntegers for the sizes in int.
 * 
 * @author scott
 *
 * <pre><code>
 * ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code><pre>
 */
public class IntMask {
  public static final BigInteger ONE = new BigInteger("1",2);
  public static final BigInteger TWO = new BigInteger("11",2);
  public static final BigInteger THREE = new BigInteger("111",2);
  public static final BigInteger FOUR = new BigInteger("1111",2);
  public static final BigInteger FIVE = new BigInteger("11111",2);  
  public static final BigInteger SIX = new BigInteger("111111",2);
  public static final BigInteger SEVEN = new BigInteger("1111111",2);
  public static final BigInteger EIGHT = new BigInteger("11111111",2);
  public static final BigInteger NINE = new BigInteger("111111111",2);
  public static final BigInteger TEN = new BigInteger("1111111111",2);
  public static final BigInteger ELEVIN = new BigInteger("11111111111",2);
  public static final BigInteger TWELVE = new BigInteger("111111111111",2);
  public static final BigInteger THIRTEEN = new BigInteger("1111111111111",2);
  public static final BigInteger FOURTEEN = new BigInteger("11111111111111",2);
  public static final BigInteger FIFTEEN = new BigInteger("111111111111111",2);
  public static final BigInteger SIXTEEN = new BigInteger("1111111111111111",2);
  public static final BigInteger SEVENTEEN = new BigInteger("11111111111111111",2);
  public static final BigInteger EIGHTTEEN = new BigInteger("111111111111111111",2);
  public static final BigInteger NINETEEN = new BigInteger("1111111111111111111",2);
  public static final BigInteger TWENTY = new BigInteger("11111111111111111111",2);
  public static final BigInteger TWENTY_ONE = new BigInteger("111111111111111111111",2);
  public static final BigInteger TWENTY_TWO = new BigInteger("1111111111111111111111",2);
  public static final BigInteger TWENTY_THREE = new BigInteger("11111111111111111111111",2);
  public static final BigInteger TWENTY_FOUR = new BigInteger("111111111111111111111111",2);
  public static final BigInteger TWENTY_FIVE = new BigInteger("1111111111111111111111111",2);
  public static final BigInteger TWENTY_SIX = new BigInteger("11111111111111111111111111",2);
  private static final BigInteger TWENTY_SEVEN = new BigInteger("111111111111111111111111111",2);
  public static final BigInteger TWENTY_EIGHT = new BigInteger("1111111111111111111111111111",2);
  public static final BigInteger TWENTY_NINE = new BigInteger("11111111111111111111111111111",2);
  public static final BigInteger THIRTY = new BigInteger("111111111111111111111111111111",2);
  public static final BigInteger THIRTY_ONE = new BigInteger("1111111111111111111111111111111",2);
  public static final BigInteger THIRTY_TWO = new BigInteger("11111111111111111111111111111111",2);

  public static BigInteger getMask(int size) {
    switch (size) {
      case 1: return ONE;
      case 2: return TWO;
      case 3: return THREE;
      case 4: return FOUR;
      case 5: return FIVE;
      case 6: return SIX;
      case 7: return SEVEN;
      case 8: return EIGHT;
      case 9: return NINE;
      case 10: return TEN;
      case 11: return ELEVIN;
      case 12: return TWELVE;
      case 13: return THIRTEEN;
      case 14: return FOURTEEN;
      case 15: return FIFTEEN;
      case 16: return SIXTEEN;
      case 17: return SEVENTEEN;
      case 18: return EIGHTTEEN;
      case 19: return NINETEEN;
      case 20: return TWENTY;
      case 21: return TWENTY_ONE;
      case 22: return TWENTY_TWO;
      case 23: return TWENTY_THREE;
      case 24: return TWENTY_FOUR;
      case 25: return TWENTY_FIVE;
      case 26: return TWENTY_SIX;
      case 27: return TWENTY_SEVEN;
      case 28: return TWENTY_EIGHT;
      case 29: return TWENTY_NINE;
      case 30: return THIRTY;
      case 31: return THIRTY_ONE;
      case 32: return THIRTY_TWO;
    }
    throw new IllegalArgumentException("Not Supported size " + size);
  }
}
