package org.conqat.lib.commons.collections;


public interface ISortableData {

	
	int size();

	
	boolean isLess(int i, int j);

	
	void swap(int i, int j);
}