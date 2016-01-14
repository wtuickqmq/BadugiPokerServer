package com.joker.common.util.page;

import java.util.ArrayList;

/**
 * Page
 * 
 * @author linxiaokai.cn
 * @version 20111106
 * @param <E>
 */
public class Page<E> {

	protected int _max;

	protected int _size;

	protected ArrayList<E> _list;

	public Page(int max) {
		_max = max;
		_list = new ArrayList<E>();
	}

	public int append(E item) {
		synchronized (_list) {
			if (_list.size() >= _max) {
				return -1;
			}
			_list.add(item);
			return _list.size() - 1;
		}
	}

	public void setAt(int index, E item) {
		synchronized (_list) {
			_list.set(index, item);
		}
	}

	public E getAt(int index) {
		synchronized (_list) {
			return _list.get(index);
		}
	}

	public int indexOf(Object item) {
		synchronized (_list) {
			return _list.indexOf(item);
		}
	}

	public void remove(Object item) {
		synchronized (_list) {
			_list.remove(item);
		}
	}

	public Object[] getList() {
		synchronized (_list) {
			return _list.toArray();
		}
	}

	public E getLast() {
		synchronized (_list) {
			return _list.get(_list.size() - 1);
		}
	}

	public int size() {
		synchronized (_list) {
			return _list.size();
		}
	}
}
