package org.adligo.collections.shared;

import java.util.Objects;
import java.util.Optional;
/**
 * 
 * @author scott
 *
 * @param <T>
 */
public class IndexInfo<T> {
	public static final String THE_RIGHT_IS_REQUIRED = "The right is required.";
	public static final String THE_LEFT_IS_REQUIRED = "The left is required.";
	private final Optional<T> _left;
  private final Optional<T> _right;

  public IndexInfo() {
  	this(Optional.empty(), Optional.empty());
  }
  
  public IndexInfo(Optional<T> left, Optional<T> right) {
  	_left = Objects.requireNonNull(left,THE_LEFT_IS_REQUIRED);
  	_right = Objects.requireNonNull(right, THE_RIGHT_IS_REQUIRED);
  }
	
	public Optional<T> getLeft() {
		return _left;
	}

	public Optional<T> getRight() {
		return _right;
	}

}
