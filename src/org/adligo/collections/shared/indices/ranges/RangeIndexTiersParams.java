package org.adligo.collections.shared.indices.ranges;

public class RangeIndexTiersParams {
  private int _base2Exponent;
  private boolean _compress;
  private RangeIndexParams _nextSegment;
  private int _min;
  private int _max;
  
  public int getBase2Exponent() {
    return _base2Exponent;
  }
  public void setBase2Exponent(int base2Exponent) {
    this._base2Exponent = base2Exponent;
  }
  public boolean isCompress() {
    return _compress;
  }
  public void setCompress(boolean compress) {
    this._compress = compress;
  }
  public RangeIndexParams getNextSegment() {
    return _nextSegment;
  }
  public void setNextSegment(RangeIndexParams nextSegment) {
    this._nextSegment = nextSegment;
  }
  public int getMin() {
    return _min;
  }
  public void setMin(int min) {
    this._min = min;
  }
  public int getMax() {
    return _max;
  }
  public void setMax(int max) {
    this._max = max;
  }
}
