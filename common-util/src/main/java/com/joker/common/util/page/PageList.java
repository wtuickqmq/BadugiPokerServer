package com.joker.common.util.page;

import java.util.ArrayList;

public class PageList<E> {

	protected int _pageSize;

	protected IPageListener _listener;

	protected ArrayList<Page<E>> _list;

	public PageList(int pageSize, IPageListener listener) {
		_pageSize = pageSize;
		_listener = listener;
		_list = new ArrayList<Page<E>>();
	}

	public void append(E item) {
		synchronized (_list) {
			Page<E> page;
			int current = -1;
			int index = -1;
			boolean totalChange = false;
			if (_list.size() < 1) {
				page = new Page<E>(_pageSize);
				_list.add(page);
				current = _list.size() - 1;
				index = page.append(item);
			} else {
				current = _list.size() - 1;
				page = _list.get(current);
				index = page.append(item);
				if (index == -1) {
					page = new Page<E>(_pageSize);
					_list.add(page);
					totalChange = true;
					current = _list.size() - 1;
					index = page.append(item);
				}
			}
			if (_listener != null) {
				_listener.appendItem(this, totalChange, Math.max(1, _list.size()), current + 1, index, item);
			}
		}
	}

	public boolean remove(E item) {
		synchronized (_list) {
			if (_list.size() < 1) {
				return false;
			}
			int index = -1;
			int current = 0;
			for (Page<E> page : _list) {
				index = page.indexOf(item);
				if (index != -1)
					break;
				current++;
			}
			if (index == -1) {
				return false;
			}
			boolean totalChange = false;
			int last = _list.size() - 1;
			Page<E> currentPage = _list.get(current);
			E lastItem = null;
			if (_list.size() > 1 && current != last) {
				Page<E> lastPage = _list.get(last);
				lastItem = lastPage.getLast();
				lastPage.remove(lastItem);
				currentPage.setAt(index, lastItem);
				if (lastPage.size() == 0) {
					_list.remove(_list.size() - 1);
					if (_list.size() > 0) {
						totalChange = true;
					}
				}
			} else {
				_list.get(current).remove(item);
				if (currentPage.size() == 0) {
					_list.remove(current);
					if (_list.size() > 0) {
						totalChange = true;
					}
				}
			}
			if (_listener != null) {
				_listener.removeItem(this, totalChange, Math.max(1, _list.size()), last + 1, current + 1, index, item, lastItem);
			}
			return true;
		}
	}

	public E getAt(int page, int index) {
		synchronized (_list) {
			Page<E> current = _list.get(page - 1);
			if (current == null) {
				return null;
			}
			return current.getAt(index);
		}
	}

	public PagePlace getPlace(E item) {
		synchronized (_list) {
			int current = 0;
			int index = -1;
			for (Page<E> page : _list) {
				index = page.indexOf(item);
				if (index != -1) {
					break;
				}
				current++;
			}
			if (index != -1) {
				return new PagePlace(current + 1, index);
			} else {
				return null;
			}
		}
	}

	public int size() {
		synchronized (_list) {
			return Math.max(1, _list.size());
		}
	}

	public Object[] getPage(int page) {
		synchronized (_list) {
			if (page < 1 || page > _list.size()) {
				return null;
			}
			return _list.get(page - 1).getList();
		}
	}
}
