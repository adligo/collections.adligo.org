package org.adligo.collections.shared;


public class MainTest {

	@SuppressWarnings({ "unused" })
	public static void main(String [] args) {
		HashIndexMutant<Integer> hi = new HashIndexMutant<>();
		IndexModifiedInfo<Integer> i1 = hi.insert( 1 );
		IndexModifiedInfo<Integer> i2 = hi.insert( 2 );
		IndexModifiedInfo<Integer> i3 = hi.insert(3);
		IndexModifiedInfo<Integer> i4 = hi.insert(4);
		IndexModifiedInfo<Integer> i5 = hi.insert(5);
		
		hi.stream().forEach((e) -> {
			System.out.println(e);
		});
	}
}
