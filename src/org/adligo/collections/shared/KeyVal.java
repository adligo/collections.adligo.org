package org.adligo.collections.shared;

import java.util.Objects;

/**
 * A basic immutable key value pair, although the key or value could be mutable.
 * @author scott
 *
 * @param <K>
 * @param <V>
 */
public class KeyVal<K,V> {
  public static final String A_KEY_IS_REQUIRED = "A key is required";
	public static final String A_VALUE_IS_REQUIRED = "A value is required.";
	private final K _key;
  private final V _value;
  
  public KeyVal(K key, V value) {
  	_key = Objects.requireNonNull(key,A_KEY_IS_REQUIRED);
  	_value = Objects.requireNonNull(value,A_VALUE_IS_REQUIRED);
  }

	public K getKey() {
		return _key;
	}

	public V getValue() {
		return _value;
	}

	@Override
	public int hashCode() {
		return _key.hashCode();
	}

	@Override
	public String toString() {
		return "KeyVal [" + _key + ", " + _value + "]";
	}
	
	
}
