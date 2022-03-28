package org.adligo.collections.shared.indices.ranges;

import java.util.Optional;
import java.util.stream.Stream;

import org.adligo.i_collections.shared.indices.I_IndexMutant;

/**
 * This improves on the performance of RangedIndexMutant by
 * storing doubly linked list style nodes in the leaf most array.  This
 * allows O(1) time performance for obtaining the item T before 
 * or after any other item T.  <br/>
 *   The only operation that slows down due to the usage of the doubly
 * linked list style node, is the set operation when it is inserting
 * into the collection which can no longer achieve O(1) but only somewhere
 * between 2x O(log n) to 2x O(log log n)<br/>
 * 
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
public class LinkedRangeIndexMutant<T> implements I_IndexMutant<T> {
  private RangeIndexMutant<T> _delegate;
  
  public LinkedRangeIndexMutant() {
    
  }

  public LinkedRangeIndexMutant(RangeIndexParams params) {
    
  }

  @Override
  public Optional<T> find(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T get(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> stream() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> stream(int fromIdx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> stream(int fromIdx, int toIdx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> streamNeighbors(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<T> streamTo(int toIdx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isBig() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int add(T t) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean set(int idx, T t) {
    // TODO Auto-generated method stub
    return false;
  }

}
