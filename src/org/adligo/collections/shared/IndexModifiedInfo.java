package org.adligo.collections.shared;

import java.util.Objects;
import java.util.Optional;
/**
 * 
 * @author scott
 *
 * @param <T>
 */
public class IndexModifiedInfo<T>  extends IndexInfo<T> {
  public static final String THE_DELETED_IS_REQUIRED = "The deleted is required.";
	private final Optional<T> _deleted;

  public IndexModifiedInfo() {
  	this(Optional.empty(), Optional.empty(), Optional.empty());
  }

  
  public IndexModifiedInfo(Optional<T> deleted, Optional<T> left, Optional<T> right) {
  	super(left, right);
  	_deleted = Objects.requireNonNull(left,THE_DELETED_IS_REQUIRED);
  }
  
	public Optional<T> getDeleted() {
		return _deleted;
	}
	
}
