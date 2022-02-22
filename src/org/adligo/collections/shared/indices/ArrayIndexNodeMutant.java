package org.adligo.collections.shared.indices;

import java.util.Optional;

import org.adligo.i_collections.shared.indices.I_IndexNodeMutant;


/**
 * A index node which when used in a index tree of these nodes 
 * can give O(log baseX N) i.e. if the base is 3 (Math.pow(2,3) = 8) 
 * it would be O(log log log N) 
 * find and get operations, while maintaining
 * put and set of O(1).   <br/>
 *   The main problem / drawback with this data 
 * structure is the cost of the null pointers for sparse
 * data.  For example if the base is 3 then we have 64 bytes 
 * of null pointers, if 4 (16 slots) we have 128 bytes of null pointers.
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
public class ArrayIndexNodeMutant<T> implements I_IndexNodeMutant<T> {
  public static final String THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63 = "The idx parameter MUST be between 0-63!";

  private final Optional<T>[] items;

  public ArrayIndexNodeMutant() {
    this(3);
  }
  
  @SuppressWarnings("unchecked")
  public ArrayIndexNodeMutant(int base) {
    int size = (int) Math.pow(2, base);
    items = new Optional[size];
    for (int i = 0; i < items.length; i++) {
      items[i] = Optional.empty();
    }
  }
  
  @Override
  public Optional<T> find(int idx) {
    if (idx < 0 || idx >= 8) {
      throw new IllegalArgumentException(THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63);
    } 
    return items[idx];
  }

  @Override
  public T get(int idx) {
    return find(idx).get();
  }

  @Override
  public boolean put(int idx, T t) {
    Optional<T> c = items[idx];
    boolean r = c.isPresent();
    if (t == null) {
      items[idx] = Optional.empty();
    } else {
      items[idx] = Optional.of(t);
    }
    return r;
  }

  @Override
  public ArrayIndexNodeMutant<T> set(int idx, T t) {
    if (t == null) {
      items[idx] = Optional.empty();
    } else {
      items[idx] = Optional.of(t);
    }
    return this;
  }

}
