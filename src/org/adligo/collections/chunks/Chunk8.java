package org.adligo.collections.chunks;

import java.util.Arrays;
import java.util.stream.Stream;

import org.adligo.collections.shared.common.Numbered;
import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.chunks.I_NewChunk;
import org.adligo.i_collections.shared.streams.I_SizedSupplier;

/**
 * A surrogate for an array with reduced space usage due to the 
 * avoidance of null pointers, with a capacity of 
 * 8 and a size between 0 and 8.
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
public class Chunk8<T> implements I_Chunk<T> {

  public static final String CHUNK8_ONLY_ACCEPTS_AN_ITEMS_ARRAY_OF_SIZE_8 = "Chunk8 only accepts an items array of size 8!";
  /**
   * a list of ones and zeros to facilitate
   * binary mask searching / optimizations.
   */
  private byte bits = 0;
  /**
   * each byte in this array contains 2 numbers<br/>
   * A number with the binary string 1000 represents a null / empty element<br/>
   * Other numbers represent the index in the objs array for this element.
   */
  private byte[] objIdxs;
  /**
   * an array of up to size 8 that contains references to the
   * objects of type T
   */
  private T[] objs;
  
  public Chunk8(T[] items) {
    if (items.length != 8) {
      throw new IllegalArgumentException(CHUNK8_ONLY_ACCEPTS_AN_ITEMS_ARRAY_OF_SIZE_8);
    }
  }
  
  public Chunk8(Numbered<T>[] items) {
    //T[] ia = Arrays
    
  }
  
  @Override
  public int capacity() {
    return 8;
  }
  
  @Override
  public Stream<T> stream(int from, int to) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> streamFrom(int from) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> streamTo(int to) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public I_SizedSupplier<T> supply(int from, int to) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public I_SizedSupplier<T> supplyFrom(int from) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public I_SizedSupplier<T> supplyTo(int to) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int size() {
    return objs.length;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Stream<T> stream() {
    return (Stream<T>) Arrays.stream(objs);
  }

  @Override
  public I_SizedSupplier<T> supply() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public I_NewChunk<T> overlay(int idx, T t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public I_NewChunk<T> reduce(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isBig() {
    // TODO Auto-generated method stub
    return false;
  }

}
