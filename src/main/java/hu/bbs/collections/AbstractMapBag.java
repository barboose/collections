package hu.bbs.collections;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bvarga and created on 2017. 08. 29..
 */
public abstract class AbstractMapBag<E> implements Bag<E>, Serializable {

	private Map<E, Integer> map;

	public AbstractMapBag() {
		map = new HashMap<>();
	}

	@Override
	public boolean add(E e) {
		final Integer count = map.get(e);
		map.put(e, count != null ? count + 1 : 1);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		map.remove(o);
		return true;
	}

	@SuppressWarnings("SuspiciousMethodCalls")
	@Override
	public int count(Object o) {
		final Integer count = map.get(o);
		return count != null ? count : 0;
	}

	@SuppressWarnings("SuspiciousMethodCalls")
	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public String toString() {
		return map.toString();
	}
}
