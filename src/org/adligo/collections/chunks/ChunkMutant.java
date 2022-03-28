package org.adligo.collections.chunks;

import java.util.Optional;
import java.util.stream.Stream;

import org.adligo.collections.shared.common.Base2Exponents;
import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.chunks.I_ChunkOrigin;
import org.adligo.i_collections.shared.chunks.I_NewChunk;
import org.adligo.i_collections.shared.streams.I_SizedSupplier;


/**
 * This is a Mutable implementation of the {@link I_Chunk}
 * interface that must have between 2 and a little over 
 * one billion elements, going up the base 2 number 
 * system (i.e. 2, 4, 8, 16, 32, 64, etc).<br/>
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
public class ChunkMutant<T> extends AbstractChunkMutant<T> implements I_Chunk<T> {
  public static final String THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID = "The following items array size is invalid; ";
  
  

  private static <T> T[] verifyCapacity(T[] items) {
    verifyCapacity(items.length);
    return items;
  }

  private static int verifyCapacity(int capacity) {
    try {
      Base2Exponents.toExponent(capacity, true);
    } catch (IllegalArgumentException x) {
      throw new IllegalArgumentException(THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID + capacity, x);
    }
    return capacity;
  }

  private long[] _bits;

  @SuppressWarnings("unchecked")
  public ChunkMutant() {
    this(32);
  }

  @SuppressWarnings("unchecked")
  public ChunkMutant(int capacity) {
    super(verifyCapacity(capacity));
  }
  
  /**
   * This constructor reuses the items array, as a rule do NOT
   * mutate the items array after it has been passed to this 
   * constructor;
   * @param items
   */
  public ChunkMutant(T[] items) {
    super(verifyCapacity(items));
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
  


  @Override
  Optional<Integer> findIndexBefore(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  Optional<Integer> findIndexAfter(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  void setBit(int bit) {
    // TODO Auto-generated method stub
    
  }
  

}
