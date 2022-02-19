package org.adligo.collections.shared;

/**
 * This will provide parameters to the {@link Index} and {@link IndexMutant}
 * classes.
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
  public static final String THE_BASE = "The base ";

  private int base2Exponent = 3;

  private int leafTeirsOfCompression = 0;

  public int getBase() {
    return (int) Math.pow((double) 2, (double) base2Exponent);
  }
  
  public int getBase2Exponent() {
    return base2Exponent;
  }

  public int getLeafTeirsOfCompression() {
    return leafTeirsOfCompression;
  }

  public IndexParams setBase(int base) {
    //There doensn't seem to be a good way to go 
    // from a base to a base2ExponentO
    boolean foundOne = false;
    
    switch (base) {
      case BASE_2: base2Exponent = 1; break;
      case BASE_4: base2Exponent = 2; break;
      case BASE_8: base2Exponent = 3; break;
      case BASE_16: base2Exponent = 4; break;
      case BASE_32: base2Exponent = 5; break;
      case BASE_64: base2Exponent = 6; break;
      case BASE_128: base2Exponent = 7; break;
      case BASE_256: base2Exponent = 8; break;
      case BASE_512: base2Exponent = 9; break;
      case BASE_1K: base2Exponent = 10; break;
      case BASE_2K: base2Exponent = 11; break;
      case BASE_4K: base2Exponent = 12; break;
      case BASE_8K: base2Exponent = 13; break;
      case BASE_16K: base2Exponent = 14; break;
      case BASE_32K: base2Exponent = 15; break;
      case BASE_65K: base2Exponent = 16; break;
      case BASE_131K: base2Exponent = 17; break;
      case BASE_262K: base2Exponent = 18; break;
      case BASE_524K: base2Exponent = 19; break;
      case BASE_1M: base2Exponent = 20; break;
      case BASE_2M: base2Exponent = 21; break;
      case BASE_4M: base2Exponent = 22; break;
      case BASE_8M: base2Exponent = 23; break;
      case BASE_16M: base2Exponent = 24; break;
      case BASE_33M: base2Exponent = 25; break;
      case BASE_67M: base2Exponent = 26; break;
      case BASE_134M: base2Exponent = 27; break;
      case BASE_268M: base2Exponent = 28; break;
      case BASE_536M: base2Exponent = 29; break;
      case BASE_1B: base2Exponent = 30; break;
      default: 
        throw new IllegalArgumentException(THE_BASE + base + IS_NOT_SUPPORETED);
    }
    return this;
  }
  
  /**
   * All of the math in the index uses exponents of 2 / base 2.
   * For examele to get base 8, use 3 for 2 ^ 3, etc.
   */
  public IndexParams setBase2Exponent(int base2Exponent) {
    this.base2Exponent = base2Exponent;
    return this;
  }
 
  /**
   * Increase this number in order to add compression
   * to the leaf most teirs, ONLY when there are enough
   * teirs to support commpression does this value come into play.
   * 
   */
  public IndexParams setLeafTeirsOfCompression(int leafTeirsOfCompression) {
    this.leafTeirsOfCompression = leafTeirsOfCompression;
    return this;
  }  
  
}
