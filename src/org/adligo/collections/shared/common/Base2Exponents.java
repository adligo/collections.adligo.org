package org.adligo.collections.shared.common;

/**
 * This class contains the integer conversions from base (2,4,8, etc)
 * to the base 2 exponent that could be used to create the base
 * (i.e. 1,2,3, etc) respectively. <br/>
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
public class Base2Exponents {

  public static final String THE_BASE_MUST_BE_2_4_OR_8 = "The base MUST be 2,4 or 8!";
  public static final String THE_EXPONENT_MUST_BE_1_2_OR_3 = "The exponent MUST be 1,2 or 3!";
  public static final String THE_FOLLOWING_BASE_IS_INVALID = "The following base is invalid; ";
  public static final String THE_FOLLOWING_EXPONENT_IS_INVALID = "The following exponent is invalid; ";

  /**
   * 
   * @param exponent the exponent of the 2^exponent=base equation
   * @param throwException
   * @return the base, or -1 if one was NOT found by this method.
   */
  public static int toBase2to8(int exponent, boolean throwException) {
    switch (exponent) {
      case 1: return 2;
      case 2: return 4;
      case 3: return 8;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_EXPONENT_MUST_BE_1_2_OR_3);
        }
    }
    return -1;
  }
  
  /**
   * 
   * @param exponent the exponent of the 2^exponent=base equation
   * @param throwException
   * @return the base, or -1 if one was NOT found by this method.
   */
  public static int toBase16to64(int exponent, boolean throwException) {
    switch (exponent) {
      case 4: return 16;
      case 5: return 32;
      case 6: return 64;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_FOLLOWING_EXPONENT_IS_INVALID + exponent);
        }
    }
    return -1;
  }
  
  /**
   * 
   * @param exponent the exponent of the 2^exponent=base equation
   * @param throwException if an exception should be thrown
   * @return the base, or -1 if one was NOT found by this method.
   */
  public static int toBase(int exponent, boolean throwException) {
    switch (exponent) {
      case 1: return 2;
      case 2: return 4;
      case 3: return 8;
      case 4: return 16;
      case 5: return 32;
      case 6: return 64;
      case 7: return 128;
      case 8: return 256;
      case 9: return 512;
      case 10: return 1024;
      case 11: return 2048;
      case 12: return 4096;
      case 13: return 8192;
      case 14: return 16384;
      // 32768 * 32768 is 1073741824 less than MAX_INTEGER
      case 15: return 32768;
      //don't allow these they would use way to much space on each tier
      //of a ziguart index
      //case 16: return 65536;
      //8192
      //case 17: return 131072;
      //4096
      //case 18: return 262144;
      //2048x
      //case 19: return 524288;
      //1024x
      //case 20: return 1048576;
      //512x
      //case 21: return 2097152;
      //256x
      //case 22: return 4194304;
      //128x
      //case 23: return 8388608;
      //64x
      //case 24: return 16777216;
      //32x
      //case 25: return 33554432;
      //16x
      //case 26: return 67108864;
      //8x
      //case 27: return 134217728;
      //4x
      //case 28: return 268435456;
      //2x
      //case 29: return 536870912;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_FOLLOWING_EXPONENT_IS_INVALID + exponent);
        }
    }
    return -1;
  }

  /**
   * 
   * @param base the result of the 2^exponent=base equation
   * @param throwException
   * @return the exponent, or -1 if one was NOT found by this method.
   */
  public static int toExponent2to8(int base, boolean throwException) {
    switch (base) {
      case 2: return 1;
      case 4: return 2;
      case 8: return 3;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_BASE_MUST_BE_2_4_OR_8);
        }
    }
    return -1;
  }

  /**
   * 
   * @param base the result of the 2^exponent=base equation
   * @param throwException
   * @return the exponent, or -1 if one was NOT found by this method.
   */
  public static int toExponent16to64(int base, boolean throwException) {
    switch (base) {
      case 16: return 4;
      case 32: return 5;
      case 64: return 6;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_FOLLOWING_BASE_IS_INVALID + base);
        }
    }
    return -1;
  }
  
  /**
   * 
   * @param base  the exponent of the 2^exponent=base equation
   * @param throwException
   * @return the exponent, or an exception is thrown
   */
  public static int toExponent(int base, boolean throwException) {
    switch (base) {
      case 2: return 1;
      case 4: return 2;
      case 8: return 3;
      case 16: return 4;
      case 32: return 5;
      case 64: return 6;
      case 128: return 7;
      case 256: return 8;
      case 512: return 9;
      case 1024: return 10;
      case 2048: return 11;
      case 4096: return 12;
      case 8192: return 13;
      case 16384: return 14;
      // 32768 * 32768 is 1073741824 less than MAX_INTEGER,
      // bigger number overflow on the 2nd tier
      case 32768: return 15;
      //don't allow these they would use way to much space on each tier
      //of a ziguart index
      //case 65536: return 16;
      //don't allow these they would use way to much space on each tier
      //of a ziguart index
      //16192x
      //case 131072: return 17;
      //8096x
      //case 262144: return 18;
      //4048x
      //case 524288: return 19;
      //2024x
      //case 1048576: return 20;
      //1024x
      //case 2097152: return 21;
      //512x 
      //case 4194304: return 22;
      //256x
      //case 8388608: return 23;
      //128x
      //case 16777216: return 24;
      //64x
      //case 33554432: return 25;
      //32x
      //case 67108864: return 26;
      //16x
      //case 134217728: return 27;
      //8x
      //case 268435456: return 28;
      //4x
      //case 536870912: return 29;
      //2X
      //case 1073741824: return 30;
      default:
        if (throwException) {
          throw new IllegalArgumentException(THE_FOLLOWING_BASE_IS_INVALID+ base);
        }
    }
    return -1;
  }

}
