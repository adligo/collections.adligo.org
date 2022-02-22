package org.adligo.collections.shared.indices.compression;

import java.util.Objects;

import org.adligo.collections.shared.common.Numbered;
import org.adligo.i_collections.shared.common.I_Numbered;
import org.adligo.i_collections.shared.indices.I_IndexNode;

/**
 * A abstract compressed node, extensions may use custom compression
 * Algorithms.
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
public abstract class AbstractCompressedIndexNode<T extends I_Numbered> implements I_IndexNode<T> {
  public static final I_Numbered[] ZERO_LENGTH_ARRAY = new Numbered[0];
  
  private final int _capacity;
  protected final I_Numbered[] _items;
  
  /**
   * Technically the items array is mutable after this constructor is called,
   * however as a gentlemans agreement it MUST NOT be mutated after
   * this constructor is called by other code.
   * 
   * @param items
   * @param capacity
   */
  public AbstractCompressedIndexNode(I_Numbered[] items, int capacity ) {
    _capacity = capacity;
    _items = Objects.requireNonNull(items);
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
   * Create a new CompressedIndexNode removing the
   * current slot with the one passed in.
   * @param idx
   * @return
   */
  public abstract AbstractCompressedIndexNode<T> delete(int idx);
    
  public int size() {
    return _items.length;
  }
  
  /**
   * Create a new CompressedIndexNode replacing the
   * current slot with the one passed in.
   * @param t
   * @return
   */
  public abstract AbstractCompressedIndexNode<T> upsert(I_Numbered t) ;
  
}
