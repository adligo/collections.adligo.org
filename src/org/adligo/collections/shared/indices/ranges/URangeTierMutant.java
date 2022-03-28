package org.adligo.collections.shared.indices.ranges;

import java.util.Optional;

import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.common.UInt;

/**
 * A bucketing system for the set of all unsigned integer primitives. <br/>
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
public class URangeTierMutant<T> {
  public static final String A_RANGE_MUTANT_S_BASE2_EXPONENT_MUST_BE_BETWEEN_2_AND_5 = "A RangeMutant's base2Exponent MUST be between 2 and 5";
  private I_Chunk<T> _chunk;
  private byte _base2Exponent;

  @SuppressWarnings("unchecked")
  public URangeTierMutant(byte base2Exponent) {
    if (base2Exponent <= 1 || base2Exponent > 5) {
      throw new IllegalArgumentException(
          A_RANGE_MUTANT_S_BASE2_EXPONENT_MUST_BE_BETWEEN_2_AND_5);
    }
    int slots = (int) Math.pow(2, base2Exponent);
    //_array = (T[]) new Object[slots];
    _base2Exponent  = base2Exponent;
  }

  public Optional<T> find(int idx) {
    return find(new UInt(idx));
  }
  
  public Optional<T> find(UInt idx) {
    T t = get(idx);
    if (t == null) {
      return Optional.empty();
    }
    return Optional.of(t);
  }
  
  public T get(int idx) {
    return get(new UInt(idx));
  }
  
  public T get(UInt idx) {
    int u = idx.toInt();
    //base 2 division
    int ai = u >> _base2Exponent;
    //return _array[ai];
    throw new IllegalStateException("TODO");
  }
  
  /**
   * 
   * @param idx
   * @param item
   * @return if the value was replaced
   */
  public boolean set(int idx, T item) {
    return set(new UInt(idx), item);
  }
  
  /**
   * 
   * @param idx
   * @param item
   * @return if the value was replaced
   */
  public boolean set(UInt idx, T item) {
    throw new IllegalStateException("TODO");
//    int u = idx.toInt();
//    //base 2 division
//    int ai = u >> _base2Exponent;
//    T old = _array[ai];
//    _array[ai] = item;
//    if (item == null) {
//      //_bits = _bits |
//    } else {
//      
//    }
//    return old != null;
  }
}
