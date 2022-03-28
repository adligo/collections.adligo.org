package org.adligo.collections.chunks;

import java.util.Objects;
import java.util.stream.Stream;

import org.adligo.i_collections.shared.chunks.ChunkOrigin;
import org.adligo.i_collections.shared.chunks.I_Chunk;
import org.adligo.i_collections.shared.chunks.I_ChunkOrigin;
import org.adligo.i_collections.shared.chunks.I_NewChunk;
import org.adligo.i_collections.shared.streams.I_SizedSupplier;

public class NewChunk<T> implements I_NewChunk<T>{
  private final I_Chunk<T> _delegate;
  private final byte _origin;
  
  public NewChunk(I_Chunk<T> delegate, byte origin) {
    this(delegate, ChunkOrigin.values()[origin]);
  }
  
  public NewChunk(I_Chunk<T> delegate, ChunkOrigin origin) {
    _delegate = Objects.requireNonNull(delegate);
    _origin = origin.getOriginId();
  }

  @Override
  public I_ChunkOrigin getOrigin() {
    return ChunkOrigin.values()[_origin];
  }

  @Override
  public byte getOriginId() {
    return _origin;
  }

  public Stream<T> stream() {
    return _delegate.stream();
  }

  public boolean isBig() {
    return _delegate.isBig();
  }

  public int size() {
    return _delegate.size();
  }

  public int capacity() {
    return _delegate.capacity();
  }

  public I_SizedSupplier<T> supply() {
    return _delegate.supply();
  }

  public Stream<T> stream(int from, int to) {
    return _delegate.stream(from, to);
  }

  public Stream<T> streamFrom(int from) {
    return _delegate.streamFrom(from);
  }

  public I_NewChunk<T> overlay(int idx, T t) {
    return _delegate.overlay(idx, t);
  }

  public Stream<T> streamTo(int to) {
    return _delegate.streamTo(to);
  }

  public I_SizedSupplier<T> supply(int from, int to) {
    return _delegate.supply(from, to);
  }

  public I_NewChunk<T> reduce(int idx) {
    return _delegate.reduce(idx);
  }

  public I_SizedSupplier<T> supplyFrom(int from) {
    return _delegate.supplyFrom(from);
  }

  public I_SizedSupplier<T> supplyTo(int to) {
    return _delegate.supplyTo(to);
  }

  @Override
  public I_Chunk<T> toChunk() {
    return _delegate;
  }


}
