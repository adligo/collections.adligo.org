package org.adligo.collections.shared.indices;

import java.util.Optional;
import java.util.stream.Stream;

import org.adligo.collections.shared.common.Numbered;
import org.adligo.i_collections.shared.indices.I_IndexMutant;

/**
 * A sort of a ArrayList like thing with the max size of {@link Integer#MAX_VALUE}
 * however with faster add / insert execution times O(log baseX n), really pretty close
 * to O(1).  Slower random access times O(log baseX n) instead of O(1), and similar
 * loop times (via stream methods O(n).
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
public class IndxMutant<T> implements I_IndexMutant<T> {
  private NumberedArrayIndexMutant<Numbered<T>> _delegate;
  
  @Override
  public int add(T t) {
    // TODO Auto-generated method stub
    return 0;
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
  public boolean set(int idx, T t) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isBig() {
    // TODO Auto-generated method stub
    return false;
  }

}
