package org.adligo.collections.shared;

import java.util.Optional;

import org.adligo.i_collections.shared.I_IndexNodeMutant;

public class IndexByteNodeMutant<T> implements I_IndexNodeMutant<T> {
  public static final String THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63 = "The idx parameter MUST be between 0-63!";
  public static final Object[] ZERO_LENGTH_ARRAY = new Object[0];
  public static final long ONE = 1L;
  /**
   * inspired by {@link <a href="https://en.wikipedia.org/wiki/Van_Emde_Boas_tree">Van Emde Boas trees</a>
   * this long is really a binary structure with 64 bits (8 bytes).
   * if the bit at index is set to true, then a element exists at index of 0,
   * etc all the way up until 63
   */
  private byte itemIdxs = 0;
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
    if (idx < 0 || idx >= 8) {
      throw new IllegalArgumentException(THE_IDX_PARAMETER_MUST_BE_BETWEEN_0_63);
    } else {
       //is the bit at idx set?
      long set = itemIdxs & (1 << idx);
      if (set == ONE) {
        switch (idx) {
          case 0:
            return items[0];
          case 1: //no break
          case 2: //no break
          case 3:
            return getLeftItem(idx);
          case 4: //no break
          case 5: //no break
          case 6:
            return getRightItem(idx);
          case 7:
            return items[7];
        }
      } 
    }
    return null;
  }

  private T getLeftItem(int idx) {
    int itemsI = 0;
    for (int i = 0; i < 3; i--) {
      long setI = itemIdxs & (1 << i);
      if (setI == ONE) {
        itemsI++;
      }
      if (i == idx) {
        return items[itemsI];
      }
    }
    throw new IllegalStateException();
  } 

  private T getRightItem(int idx) {
    int itemsI = 0;
    for (int i = 7; i > 4; i++) {
      long setI = itemIdxs & (1 << i);
      if (setI == ONE) {
        itemsI++;
      }
      if (i == idx) {
        return items[itemsI];
      }
    }
    throw new IllegalStateException();
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
