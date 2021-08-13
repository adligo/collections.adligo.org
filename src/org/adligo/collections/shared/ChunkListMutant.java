package org.adligo.collections.shared;

import java.util.Arrays;
import java.util.stream.Stream;

import org.adligo.i.collections.shared.I_ListMutant;
import org.adligo.i.collections.shared.I_ListSetters;

/**
 * @Experimental, this would compete with ArrayList
 * @see /notes/2021-08-11-scot-heinz.txt
 * 
 * ArrayList appears to have O(n) on add and insert (add(int, T))
 * any time the list overflows capacity (Arrays.copy).  This class gets add down to
 * O(c + s) where c is the number of chunks and s is the size
 * of the chunks.  If n = 1000, c = 100, and s = 10 this would be 
 * almost 10x faster (1000 vs 110).  If n = 1000, c = 50, and s = 20 you get 
 * better than 10x (1000 vs 70) etc.
 * @author scott
 *
 * @param <T>
 */
public class ChunkListMutant<T> implements I_ListMutant<T> {
  public static final int DEFAULT_CHUNK_SIZE = 50;
  public static final int DEFAULT_CHUNKS = 1;
  private final int _chunkSize;
  private T[][] _data;
  private int _size;

  public ChunkListMutant() {
    this(DEFAULT_CHUNKS, DEFAULT_CHUNK_SIZE, null);
  }

  public ChunkListMutant(int chunkSize, T[] data) {
    this(DEFAULT_CHUNKS, chunkSize, data);
  }

  public ChunkListMutant( T[] data) {
    this(DEFAULT_CHUNKS, DEFAULT_CHUNK_SIZE, data);
  }
  
  @SuppressWarnings("unchecked")
  public ChunkListMutant(int chunks, int chunkSize, T[] data) {
    _chunkSize = chunkSize;
    _data = (T[][]) new Object[chunks][chunkSize];
    add(data);
  }
  
  @Override
  public T get(int idx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int size() {
    return _size;
  }

  @Override
  public I_ListSetters<T> add(T... item) {
    // TODO Auto-generated method stub
    return this;
  }

  @Override
  public I_ListSetters<T> set(int idx, T item) {
    // TODO Auto-generated method stub
    return this;
  }

  private final void ensureCapacity(int capacity) {
    int current = _chunkSize * _data.length;
    if (capacity > current) {
       int needed = capacity - current;
       int newChunks = needed / _chunkSize;
       int oldLen = _data.length;
       int newLen = oldLen + newChunks;
       _data = Arrays.copyOf(_data, newLen);
       for (int i = oldLen; i < newLen; i++) {
         _data[i] = (T[]) new Object[_chunkSize];
       }
    }
  }

  @Override
  public Stream<T> stream() {
    // TODO Auto-generated method stub
    return null;
  }
}
