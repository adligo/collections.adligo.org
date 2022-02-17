package org.adligo.collections.shared;

import java.util.Objects;

import org.adligo.i_collections.shared.I_Numbered;

/**
 * A simple wrapper to add the {@link I_Nubered} interface
 * to anything.
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
public class Numbered<T> implements I_Numbered {
  private final T _item;
  private final int _nbr;
  
  public Numbered(T item, int nbr) {
    _item = Objects.requireNonNull(item);
    _nbr = nbr;
  }

  public T getItem() {
    return _item;
  }

  public int getNbr() {
    return _nbr;
  }
}
