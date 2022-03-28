package org.adligo.collections.shared.indices.ranges;

import java.util.Optional;
import java.util.stream.Stream;

import org.adligo.i_collections.shared.indices.I_IndexMutant;

/**
 * This a Mutable RangeIndex.  A RangeIndex is a interesting combination
 * of ideas from SkipLists and Ziggurat Indices.  It uses a top 
 * down structure to predetermine the SkipList style buckets
 * for the entire range of integers, which it stores in arrays
 * using binary division similar to Ziggurat Indices.  This will 
 * provide O(1) to O(log n) performance for accessors and mutators
 * depending on the base of the tiers.<br/>
 *   This data structure has the advantage over Skip Lists of never needing
 * to rebalance, as the structure is pre determined.  This will
 * give it faster performance for accessors and mutators.<br/>
 *   This data structure has the disadvantage of slower seek time 
 * O(log n) to O(log log n) (find
 * nest or previous) when compared with 
 * Skip Lists which has O(1).  
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
public class RangeIndexMutant<T> implements I_IndexMutant<T> {
  private URangeTierMutant<T> _positives;
  private URangeTierMutant<T> _negatives;
  
  public RangeIndexMutant() {
    
  }

  public RangeIndexMutant(RangeIndexParams params) {
    
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
