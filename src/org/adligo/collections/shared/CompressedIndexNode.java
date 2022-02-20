package org.adligo.collections.shared;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

import org.adligo.i_collections.shared.I_IndexNode;

/**
 * A strange node inspired by 
 * {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas tree</a>
 * which only has a max of 8 items and attempts to shrink space even
 * reducing the memory cost of null pointers (8 bytes on 64bit java).  While
 * not impacting performance much
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
public class CompressedIndexNode<T> implements I_IndexNode<T> {
  public static final String THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_7 = "The idx parameter MUST be between 0-7!";
  @SuppressWarnings("rawtypes")
  public static final Numbered[] ZERO_LENGTH_ARRAY = new Numbered[0];
  public static final long ONE = 1L;
  
  private final int _capacity;
  /**
   * inspired by {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
   * this byte is really a binary structure with 8 bits.
   * if the bit at index is set to true, then a element exists at index of 0,
   * etc all the way up until 7</br>
   * </br>
   */
  private final BigInteger _itemIdxs;
  private final Numbered<T>[] _items;
  private final int _size;
  
  /**
   * Technically the items array is mutable after this constructor is called,
   * however as a gentlemans agreement it MUST NOT be mutated after
   * this constructor is called by other code.
   * 
   * @param items
   * @param capacity
   */
  public CompressedIndexNode(Numbered<T>[] items, int capacity ) {
    _capacity = capacity;
    _items = Objects.requireNonNull(items);
    BigInteger itemIdxs = BigInteger.ZERO;
    for (int i = 0; i < items.length; i++) {
      Numbered<T> n = Objects.requireNonNull(items[i]);
      int nbr = n.getNbr();
      if (nbr == 0) {
        itemIdxs = itemIdxs.or(BigInteger.ONE);
      } else {
        BigInteger shifted = BigInteger.ONE.shiftLeft(n.getNbr());
        itemIdxs = itemIdxs.or(shifted);        
//        System.out.println(shifted.toString(2));
      }
//      System.out.println(itemIdxs.toString(2));
    }
    _itemIdxs = itemIdxs;
    _size = items.length;
  }
  
  /**
   * the total number of items that MAY be 
   * set in this node.
   * @return
   */
  public int capacity() {
    return _capacity;
  }
  
  /**
   * count the bits to the right of the idx in the
   * _itemIdxs, which has zero and one at the right.
   * @param idx
   * @return
   */
  public int countRight(int idx) {
    if (idx == 0) {
      return 0;
    }
    int rightSlots = idx;
    BigInteger mask = IntMask.getMask(rightSlots);
    BigInteger potentialOnes = _itemIdxs.and(mask);
    int onesCount = 0;
    System.out.println("\ndebugging " + mask.toString(2));
    System.out.println(potentialOnes.toString(2));
    for (int i = rightSlots; i > 0;) {
      if (i >= 8) {
        byte b = potentialOnes.and(IntMask.EIGHT).byteValue();
        onesCount += Bits.countBits(b);
        potentialOnes.shiftRight(8);
        i-=8;
      } else {
        byte b = potentialOnes.byteValue();
        onesCount += Bits.countBits(b);
        i = 0;
      }
    }
    return onesCount;
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

  @Override
  public T get(int idx) {
    Optional<Integer> arrayIdx = findItemIndex(idx);
    if (arrayIdx.isPresent()) {
      return _items[arrayIdx.get()].getItem();
    }
    return null;
  }

  public BigInteger getItemIdxs() {
    return _itemIdxs;
  }

  public boolean has(int idx) {
    BigInteger shiftedOne = BigInteger.ONE.shiftLeft(idx);
    int set = _itemIdxs.and(shiftedOne).intValue();
    
//    System.out.println("\n" + shiftedOne.toString(2));
//    System.out.println(_itemIdxs.toString(2));
    return set >= 1;
  }
  
  public int size() {
    return _size;
  }

  /**
   * 
   * @param idx
   * @return
   */
  protected Optional<Integer> findItemIndex(int idx) {
    if (idx > capacity()) {
      return Optional.empty();  
    }
    //is the bit at idx set?
    if (has(idx)) {
      if (_items.length == 1) {
        return Optional.of(0);
      }
      if (idx == 0) {
        return Optional.of(0);
      }
      int right = countRight(idx);
      if (right >= _items.length -1) {
        return Optional.of(_items.length -1);
      } else {
        return Optional.of(right);
      }
    }
    return Optional.empty();
  }
  
}
