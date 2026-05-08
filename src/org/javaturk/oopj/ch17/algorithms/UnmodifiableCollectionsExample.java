
package org.javaturk.oopj.ch17.algorithms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.javaturk.oopj.ch14.util.CollectionUtil;

public class UnmodifiableCollectionsExample {

	public static void main(String[] args) {
		Collection coll = CollectionUtil.getCollection();
		System.out.println(coll);
		coll.add("fifteen");
		System.out.println(coll);
		
		Collection unmodifiableCollection = Collections.unmodifiableCollection(coll);
		CollectionUtil.listElements(unmodifiableCollection);
//		unmodifiableCollection.add("twenty");
		
		Set unmodifiableSet = Collections.unmodifiableSet(CollectionUtil.getSet());
		CollectionUtil.listElements(unmodifiableSet);
//		unmodifiableSet.add("5");
		
		List unmodifiableList = Collections.unmodifiableList(CollectionUtil.getStringList());
		CollectionUtil.listElements(unmodifiableList);
//		unmodifiableList.add("5");
	}
}
