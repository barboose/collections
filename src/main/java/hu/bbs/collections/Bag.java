package hu.bbs.collections;

/**
 * @author bvarga and created on 2017. 08. 29..
 */
public interface Bag<E> {

	boolean add(E e);

	boolean remove(Object o);

	int count(Object o);

	boolean contains(Object o);

	int size();

	void clear();
}
