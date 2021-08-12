package org.adligo.collections.shared;

import java.util.Objects;
import java.util.Optional;
/**
 * 
 * @author scott
 *
 * @param <T>
 */
public class IndexSearchResult<T> extends IndexInfo<T> {
  public static final String THE_FOUND_IS_REQUIRED = "The found is required.";
	private final Optional<T> _found;

  public IndexSearchResult() {
  	this(Optional.empty(), Optional.empty(), Optional.empty());
  }

  
  public IndexSearchResult(Optional<T> found, Optional<T> left, Optional<T> right) {
  	super(left, right);
  	_found = Objects.requireNonNull(found,THE_FOUND_IS_REQUIRED);
  }
  
	public Optional<T> getFound() {
		return _found;
	}
	
}
