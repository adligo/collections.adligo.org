package org.adligo.collections.shared;

import java.util.Iterator;
import java.util.Optional;

import org.adligo.i_collections.shared.I_IndexMutant;
import org.adligo.i_collections.shared.I_IndexNodeMutant;

public class IndexIntNodeMutant<T> implements I_IndexNodeMutant<T> {
  public static final String THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63 = "The idx parameter MUST be between 0-63!";
  public static final Object[] ZERO_LENGTH_ARRAY = new Object[0];
  /**
   * inspired by {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
   * this long is really a binary structure with 64 bits (8 bytes).
   * if the bit at index is set to true, then a element exists at index of 0,
   * etc all the way up until 63
   */
  private int itemIdxs = 0;
  @SuppressWarnings("unchecked")
  private T[] items = (T[]) ZERO_LENGTH_ARRAY;
  
  @Override
  public Optional<T> find(int idx) {
    T t = get(idx);
    if (t == null) {
      return Optional.empty();
    } else {
      return Optional.of(t);
    }
  }

  @Override
  public T get(int idx) {
    if (idx < 0 || idx >= 32) {
      throw new IllegalArgumentException(THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63);
    } else if (idx < 64) {
       //is the bit at idx set?
      long set = itemIdxs & (1 << idx);
      if (set == 1) {
        if (idx > 32) {
          //mask the bits after the index and then work backward from the end of the
          //items array to get the item
          int count = 0;
          for (int i = idx; i < 32; i++) {
            count +=  itemIdxs & (1 << i);
          }
          T r = null;
          //for
          return null;
        } else {
          //mask the bits before the index and then work forward from the end of the
          //items array to get the item
          return null;
          
        }
      } 
    } 
    return null;
  }

  @Override
  public boolean put(int idx, T t) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void set(int idx, T t) {
    // TODO Auto-generated method stub
    
  }

}
