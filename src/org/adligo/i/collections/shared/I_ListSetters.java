package org.adligo.i.collections.shared;

public interface I_ListSetters<T> extends I_Collection<T> {
  /**
   * @param item(s)
   * @throws a IllegalStateException if the idx is out of bounds.
   * @return
   */
  I_ListSetters<T> add(T ... item);
  
  /**
   * Replaces the current item with the item method parameter.
   * @param idx
   * @param item
   * @throws a IllegalStateException if the idx is out of bounds.
   * @return
   */
  I_ListSetters<T> set(int idx, T item);
}
