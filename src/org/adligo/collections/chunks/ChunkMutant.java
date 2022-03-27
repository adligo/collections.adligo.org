package org.adligo.collections.chunks;

import java.util.stream.Stream;

import org.adligo.collections.shared.common.Base2Exponents;
import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.chunks.I_NewChunk;
import org.adligo.i_collections.shared.streams.I_SizedSupplier;

public class ChunkMutant<T> implements I_Chunk<T> {
  public static final String THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID = "The following items array size is invalid; ";
  private int _size;
  private T[] _objs;

  @SuppressWarnings("unchecked")
  public ChunkMutant() {
    _size = 0;
    _objs = (T[]) new Object[32];
  }

  /**
   * This constructor reuses the items array, as a rule do NOT
   * mutate the items array after it has been passed to this 
   * constructor;
   * @param items
   */
  public ChunkMutant(T[] items) {
    int size = 0;
    
    try {
      Base2Exponents.toExponent(items.length, true);
    } catch (IllegalArgumentException x) {
      throw new IllegalArgumentException(THE_FOLLOWING_ITEMS_ARRAY_SIZE_IS_INVALID + items.length, x);
    }
    _objs = items;
  }
  
  @Override
  public I_NewChunk<T> overlay(int idx, T t) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public I_NewChunk<T> reduce(int idx) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public Stream<T> stream(int from, int to) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public Stream<T> streamFrom(int from) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public Stream<T> streamTo(int to) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public I_SizedSupplier<T> supply(int from, int to) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public I_SizedSupplier<T> supplyFrom(int from) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public I_SizedSupplier<T> supplyTo(int to) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public int capacity() {
    // TODO Auto-generated method stub
    return 0;
  }
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }
  @Override
  public Stream<T> stream() {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public I_SizedSupplier<T> supply() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isBig() {
    // TODO Auto-generated method stub
    return false;
  }
}
