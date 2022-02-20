package org.adligo.collections.shared;

import java.util.Optional;

import org.adligo.i_collections.shared.I_IndexNodeMutant;


/**
 * A index node which when used in a index tree of these nodes 
 * can give O(log baseX N) i.e. <br/>
 * if the base is 3 (Math.pow(2,3) = 8) it would be O(log log log N) <br/>
 * if the base is 4 (Math.pow(2,4) = 16) it would be O(log log log log N) <br/>
 * etc <br/>
 * find and get operations, while maintaining
 * put and set of O(1), as getting to a element T would always 
 * traverse the entire ziggurat height (aka a flat top tree).   <br/>
 *   The main problem / drawback with this data 
 * structure is the cost of the pointers to {@link Tri#EMPTY_TRI}s for sparse
 * data.  For example if the base is 3 then we have 512 bytes 
 * of pointers to {@link Tri#EMPTY_TRI}, if 4 (16 slots) we have 1,024 bytes (1Kb) of
 * pointers to {@link Tri#EMPTY_TRI}sbr/>
 *   This problem MAY be alienated significantly by setting compress flag to to true,
 *  which should reduce the size to O(n) as it's less than 2*n.  <br/>
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
public class ArrayTriIndexNodeMutant<T> implements I_IndexNodeMutant<T> {
  /**
   * The base Math.pow(2, base) number of elements in the top / left
   * arrays
   */
  private int _base;
  /**
   * The base Math.pow(2, base) number of elements in the leaf
   * most nodes, note if compress is true the leaf most nodes will 
   * be  {@link ByteIndexNodeMutant}, so this will be 3 for arrays of size 8.
   */
  private int _baseLeaf;
  /**
   * When this is set to true the items leaf 
   * most node will be a {@link ByteIndexNodeMutant}
   * when false it will be a {@link ArrayIndexNodeMutant}
   */
  private boolean compress = false;
  private int dimensions;
  /**
   * this is top down left to right so the items
   * in here are either <br/>
   * NULL<br/>
   * another dimension of this<br/>
   * or
   * leaf's @see compress above
   */
  private Either<CompressedIndexNode<T>, I_IndexNodeMutant<T>>[] items;
  private int size = 0;

  public ArrayTriIndexNodeMutant() {
    this(3,1);
  }
  
  @SuppressWarnings("unchecked")
  public ArrayTriIndexNodeMutant(int base, int dimensions) {
    _base = base;
    _baseLeaf = base;
    int size = (int) Math.pow(2, base);
  }
  
  @Override
  public Optional<T> find(int idx) {
    throw new IllegalStateException("TODO");
  }

  @Override
  public T get(int idx) {
    throw new IllegalStateException("TODO");
  }

  @Override
  public boolean put(int idx, T t) {
    throw new IllegalStateException("TODO");
  }

  @Override
  public ArrayTriIndexNodeMutant<T> set(int idx, T t) {
    throw new IllegalStateException("TODO");
  }

}
