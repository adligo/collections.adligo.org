package org.adligo.collections.shared;


public class MainTest {

	@SuppressWarnings({ "unused" })
	public static void main(String [] args) {
		HashIndexMutant<Integer> hi = new HashIndexMutant<>();
		IndexInsertInfo<Integer> i1 = hi.insert( 1 );
		IndexInsertInfo<Integer> i2 = hi.insert( 2 );
		IndexInsertInfo<Integer> i3 = hi.insert(3);
		IndexInsertInfo<Integer> i4 = hi.insert(4);
		IndexInsertInfo<Integer> i5 = hi.insert(5);
		
		hi.stream().forEach((e) -> {
			System.out.println(e);
		});
	}
}
