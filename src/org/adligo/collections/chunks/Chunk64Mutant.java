package org.adligo.collections.chunks;

import java.util.stream.Stream;

import org.adligo.collections.shared.common.Base2Exponents;
import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.chunks.I_ChunkOrigin;
import org.adligo.i_collections.shared.chunks.I_NewChunk;
import org.adligo.i_collections.shared.streams.I_SizedSupplier;


/**
 * This is a Mutable implementation of the {@link I_Chunk}
 * interface that must have between 2 and 64 elements, going
 * up the base 2 number system (i.e. 2, 4, 8, 16, 32, 64).<br/>
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
public class Chunk64Mutant<T> implements I_Chunk<T> {
  public static final String THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID = "The following items array size is invalid; ";
  private long _bits;
  private int _size;
  private T[] _objs;

  @SuppressWarnings("unchecked")
  public Chunk64Mutant() {
    this(32);
  }

  @SuppressWarnings("unchecked")
  public Chunk64Mutant(int capacity) {
    _size = 0;
    verifyCapacity(capacity);
    _objs = (T[]) new Object[capacity];
  }
  
  /**
   * This constructor reuses the items array, as a rule do NOT
   * mutate the items array after it has been passed to this 
   * constructor;
   * @param items
   */
  public Chunk64Mutant(T[] items) {
    verifyCapacity(items.length);
    _objs = items;
    int size = 0;
    for (int i = 0; i < items.length; i++) {
      //set the bits and size here
      throw new IllegalStateException("TODO");
    }
    _size = size;
  }

  @Override
  public int capacity() {
    return _objs.length;
  }
  @Override
  public I_NewChunk<T> overlay(int idx, T t) {
    // TODO Auto-generated method stub
    return new NewChunk<T>(this, I_ChunkOrigin.OVERLAY);
  }
  @Override
  public I_NewChunk<T> reduce(int idx) {
    // TODO Auto-generated method stub
    return new NewChunk<T>(this, I_ChunkOrigin.REDUCE);
  }
  @Override
  public Stream<T> stream(int from, int to) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public Stream<T> streamFrom(int from) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public Stream<T> streamTo(int to) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public I_SizedSupplier<T> supply(int from, int to) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public I_SizedSupplier<T> supplyFrom(int from) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public I_SizedSupplier<T> supplyTo(int to) {
    throw new IllegalStateException("TODO");
  }
  @Override
  public int size() {
    return _size;
  }
  @Override
  public Stream<T> stream() {
    throw new IllegalStateException("TODO");
  }
  @Override
  public I_SizedSupplier<T> supply() {
    throw new IllegalStateException("TODO");
  }

  @Override
  public boolean isBig() {
    return false;
  }

  @Override
  public I_Chunk<T> toChunk() {
    return this;
  }
  

  private void verifyCapacity(int capacity) {
    try {
      Base2Exponents.toExponent(capacity, true);
    } catch (IllegalArgumentException x) {
      throw new IllegalArgumentException(THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID + capacity, x);
    }
    if (capacity < 2 || capacity > 64) {
      throw new IllegalArgumentException(THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID + capacity); 
    }
  }
}
