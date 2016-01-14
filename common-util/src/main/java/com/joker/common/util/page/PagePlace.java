package com.joker.common.util.page;

public final class PagePlace {

	private int _page;

	private int _index;

	public PagePlace(int page, int index) {
		_page = page;
		_index = index;
	}

	public int getPage() {
		return _page;
	}

	public int getIndex() {
		return _index;
	}

	public String toString() {
		return "page=" + _page + ".index=" + _index;
	}
}
