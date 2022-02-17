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
 * structure is the cost of the pointers to empty {@link Tri}}s for sparse
 * data.  For example if the base is 3 then we have 512 bytes 
 * of pointers to empty {@link Tri}, if 4 (16 slots) we have 1,024 bytes of
 * pointers empty {@link Tri}}s .
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
  
  private int dimensions;
  private Tri<ArrayIndexNodeMutant<T>, ArrayTriIndexNodeMutant<T>>[] items;
  private int size = 0;

  public ArrayTriIndexNodeMutant() {
    this(3,1);
  }
  
  @SuppressWarnings("unchecked")
  public ArrayTriIndexNodeMutant(int base, int dimensions) {
    int size = (int) Math.pow(2, base);
    items = new Tri[size];
    for (int i = 0; i < items.length; i++) {
      items[i] = Tri.EMPTY_TRI;
    }
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
  public void set(int idx, T t) {
    throw new IllegalStateException("TODO");
  }

}
