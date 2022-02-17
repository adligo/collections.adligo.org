package org.adligo.collections.shared;

import java.util.Objects;
import java.util.Optional;
/**
 * Just another Either class, both may be empty or one MAY be set. <br/>
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
public class Tri<L,R> {
  public static final String BOTH_CAN_NOT_BE_PRESENT = "Both can NOT be present!";
  public static final Tri EMPTY_TRI = new Tri();
  
  private final Optional<L> left;
  private final Optional<R> right;
  
  private Tri() {
    this(Optional.empty(), Optional.empty());
  }
  
  public Tri(Optional<L> left, Optional<R> right) {
    this.left = Objects.requireNonNull(left);
    this.right = Objects.requireNonNull(right);

    if (left.isPresent() && right.isPresent()) {
      throw new IllegalArgumentException(BOTH_CAN_NOT_BE_PRESENT);
    }
  }
  
  public Optional<L> getLeft() {
    return left;
  }

  public Optional<R> getRight() {
    return right;
  }

  public boolean isEmpty() {
    if (left.isPresent() || right.isPresent()) {
      return false;
    }
    return true;
  }
}
