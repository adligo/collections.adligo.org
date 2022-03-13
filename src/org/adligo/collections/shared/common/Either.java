package org.adligo.collections.shared.common;

import java.util.Objects;
import java.util.Optional;
/**
 * Just another Either class either the left or right must
 * be set, optimized for low space usage.. <br/>
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
public class Either<L,R> {
  private final boolean _left;
  private final Object _leftOrRight;
  
  @SuppressWarnings("unchecked")
  public Optional<L> getLeft() {
    if (_left) {
      return (Optional<L>) Optional.of(_leftOrRight);
    }
    return Optional.empty();
  }

  @SuppressWarnings("unchecked")
  public Optional<R> getRight() {
    if ( !_left) {
      return (Optional<R>) Optional.of(_leftOrRight);
    }
    return Optional.empty();
  }

  public Either(L left) {
    _left = true;
    _leftOrRight = Objects.requireNonNull(left);
  }
}
