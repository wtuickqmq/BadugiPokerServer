package com.joker.common.util.page;

public interface IPageListener {

	void appendItem(PageList<?> target, boolean totalChange, int total, int page, int index, Object item);

	void removeItem(PageList<?> target, boolean totalChange, int total, int last, int page, int index, Object item, Object lastItem);

}
