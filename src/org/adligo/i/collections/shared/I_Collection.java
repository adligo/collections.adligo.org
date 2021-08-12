package org.adligo.i.collections.shared;

import java.util.stream.Stream;

public interface I_Collection<T> {
  int size();
  Stream<T> stream();
}
