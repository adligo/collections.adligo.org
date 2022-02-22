package org.adligo.collections.shared.indices;

/**
 * This will provide parameters to the {@link Index} and {@link IndexMutant}
 * classes.<br/>
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
public class IndexParams {
  public static final int BASE_2 = 2;
  public static final int BASE_4 = 4;
  public static final int BASE_8 = 8;
  public static final int BASE_16 = 16;
  public static final int BASE_32 = 32;
  public static final int BASE_64 = 64;
  public static final int BASE_128 = 128;
  public static final int BASE_256 = 256;
  public static final int BASE_512 = 512;
  public static final int BASE_1K = 1024;
  public static final int BASE_2K = 2048;
  public static final int BASE_4K = 4096;
  public static final int BASE_8K = 8192;
  public static final int BASE_16K = 16384;
  public static final int BASE_32K = 32768;
  public static final int BASE_65K = 65536;
  public static final int BASE_131K = 131072;
  public static final int BASE_262K = 262144;
  public static final int BASE_524K = 524288;
  public static final int BASE_1M = 1048576;
  public static final int BASE_2M = 2097152;
  public static final int BASE_4M = 4194304;
  public static final int BASE_8M = 8388608;
  public static final int BASE_16M = 16777216;
  public static final int BASE_33M = 33554432;
  public static final int BASE_67M = 67108864;
  public static final int BASE_134M = 134217728;
  public static final int BASE_268M = 268435456;
  public static final int BASE_536M = 536870912;
  public static final int BASE_1B = 1073741824;
  public static final String IS_NOT_SUPPORETED = " is NOT supporeted!";
  public static final String IS_NOT_SUPPORETED_YET = " is NOT supporeted yet!";
  public static final String THE_BASE = "The base ";
  public static final String THE_BASE_2_EXPONENT  = "The base 2 exponent ";

  public static final int baseToBase2Exponent(int base) {
    //There doensn't seem to be a good way to go 
    // from a base to a base2ExponentO
    
    switch (base) {
      case BASE_2: return  1; 
      case BASE_4: return  2; 
      case BASE_8: return  3; 
      case BASE_16: return  4; 
      case BASE_32: return  5; 
      case BASE_64: return  6; 
      case BASE_128: return  7; 
      case BASE_256: return  8; 
      case BASE_512: return  9; 
      case BASE_1K: return  10; 
      case BASE_2K: return  11; 
      case BASE_4K: return  12; 
      case BASE_8K: return  13; 
      case BASE_16K: return  14; 
      case BASE_32K: return  15; 
      case BASE_65K: return  16; 
      case BASE_131K: return  17; 
      case BASE_262K: return  18; 
      case BASE_524K: return  19; 
      case BASE_1M: return  20; 
      case BASE_2M: return  21; 
      case BASE_4M: return  22; 
      case BASE_8M: return  23; 
      case BASE_16M: return  24; 
      case BASE_33M: return  25; 
      case BASE_67M: return  26; 
      case BASE_134M: return  27; 
      case BASE_268M: return  28; 
      case BASE_536M: return  29; 
      case BASE_1B: return  30; 
      default: 
        throw new IllegalArgumentException(THE_BASE + base + IS_NOT_SUPPORETED);
    }
  }

  private int _base2Exponent = 3;
  private int _leafTiersOfCompression = 0;
  private int _leafBase2Exponent = 3;
  
  public int getBase() {
    return (int) Math.pow((double) 2, (double) _base2Exponent);
  }
  
  public int getBase2Exponent() {
    return _base2Exponent;
  }
  
  public int getLeafBase() {
    return (int) Math.pow((double) 2, (double) _leafBase2Exponent);
  }
  
  public int getLeafBase2Exponent() {
    return _leafBase2Exponent;
  }
  
  public int getLeafTiersOfCompression() {
    return _leafTiersOfCompression;
  }

  public IndexParams setBase(int base) {
    //There doensn't seem to be a good way to go 
    // from a base to a base2ExponentO
    _base2Exponent = baseToBase2Exponent(base);
    return this;
  }
  
  /**
   * All of the math in the index uses exponents of 2 / base 2.
   * For example to get base 8, use 3 for 2 ^ 3, etc.
   */
  public IndexParams setBase2Exponent(int base2Exponent) {
    if (base2Exponent < 1 || base2Exponent > 30) {
      throw new IllegalArgumentException(THE_BASE_2_EXPONENT + base2Exponent + IS_NOT_SUPPORETED);
    }
    _base2Exponent = base2Exponent;
    return this;
  }
 
  /**
   * set the base of the leaf nodes and the compressed tiers
   * above leaf nodes.
   * @param leafBase2Exponent
   * @return
   */
  public IndexParams setLeafBase(int leafBase2Exponent) {
    _leafBase2Exponent = baseToBase2Exponent(leafBase2Exponent);
    return this;
  }
  /**
   * Sets the leaf base 2 exponent which MUST be 1,2,3,4,5 or 6
   * @param leafBase2Exponent
   * @return
   */
  public IndexParams setLeafBase2Exponent(int leafBase2Exponent) {
    if (leafBase2Exponent < 1 || leafBase2Exponent > 6) {
      throw new IllegalArgumentException(THE_BASE_2_EXPONENT + leafBase2Exponent + 
          IS_NOT_SUPPORETED);
    }
    if (leafBase2Exponent < 3 || leafBase2Exponent > 3) {
      throw new IllegalArgumentException(THE_BASE_2_EXPONENT + leafBase2Exponent + 
          IS_NOT_SUPPORETED_YET);
    }
    this._leafBase2Exponent = leafBase2Exponent;
    return this;
  }
  
  /**
   * Increase this number in order to add compression
   * to the leaf most teirs, ONLY when there are enough
   * teirs to support commpression does this value come into play.
   * 
   */
  public IndexParams setLeafTiersOfCompression(int leafTeirsOfCompression) {
    this._leafTiersOfCompression = leafTeirsOfCompression;
    return this;
  }  
  
}
