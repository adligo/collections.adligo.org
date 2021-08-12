package org.adligo.i.collections.shared;

public interface I_List<T> extends I_Collection<T> {
  /**
   * returns the item T at index idx.  
   * @param idx
   * @throws a IllegalStateException if the idx is out of bounds.
   * @return
   */
   T get(int idx);
}
