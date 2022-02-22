package org.adligo.collections.shared.indices.compression;

import java.util.Optional;

import org.adligo.collections.shared.common.Numbered;
import org.adligo.i_collections.shared.common.I_Numbered;
import org.adligo.i_collections.shared.indices.I_IndexNode;

/**
 * A compressed node that uses the concept of a relative pointer / array index.
 * A byte is used in place of a pointer (8x compression on 64 bit java, 4x compression
 * on 32 bit java) to identify the relative position in the compressed array of _items.<br/>
 *   In addition this provides a {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
 * inspired set of bits stored as two longs, which enable bit mask style searching
 * for O(1) operations to identify items before or after a particular compressed item.
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
public class ByteArrayRelativeArrayIndexCompressedIndexNode<T extends I_Numbered> 
extends AbstractCompressedIndexNode<T> implements I_IndexNode<T> {
  public static final String CAPACITY_MUST_BE_LESS_THAN_OR_EQUAL_TO_128 = "Capacity MUST be less than or equal to 128!";
  
  /**
   * This a byte
   * </br>
   */
  private final byte[] _itemIdxs;
  
  /**
   * inspired by {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
   * this byte is really a binary structure with 64 bits.
   * if the bit at index is set to true, then a element exists at index of 0,
   * etc all the way up until 63</br>
   */
  private final long _0to63;

  /**
   * inspired by {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
   * this byte is really a binary structure with 64 bits.
   * if the bit at index is set to true, then a element exists at index of 64,
   * etc all the way up until 127</br>
   */
  private final long _64to127;
  
  /**
   * Technically the items array is mutable after this constructor is called,
   * however as a gentlemans agreement it MUST NOT be mutated after
   * this constructor is called by other code.
   * 
   * @param items
   * @param capacity
   */
  public ByteArrayRelativeArrayIndexCompressedIndexNode(Numbered<T>[] items, int capacity ) {
    super(items, capacity);
    if (capacity > 128) {
      throw new IllegalArgumentException(CAPACITY_MUST_BE_LESS_THAN_OR_EQUAL_TO_128);
    }
    _itemIdxs = new byte[capacity];
    for (int i = 0; i < capacity; i++) {
      _itemIdxs[i] = -1;
    }
    for (int i = 0; i < _items.length; i++) {
      I_Numbered n = _items[i];
      int nbr = n.getNbr();
      _itemIdxs[nbr] = (byte) i;
    }
    //TODO
    _0to63 = 0;
    _64to127 = 0L;
  }
  
  @Override
  public Optional<T> find(int idx) {
    T t = get(idx);
    if (t == null) {
      return Optional.empty();
    } else {
      return Optional.of(t);
    }
  }

  public boolean has(int idx) {
    return false;//TODO
  }

  @Override
  public T get(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AbstractCompressedIndexNode<T> delete(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AbstractCompressedIndexNode<T> upsert(I_Numbered t) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
