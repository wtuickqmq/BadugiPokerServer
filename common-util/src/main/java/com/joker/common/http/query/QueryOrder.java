/*
 * Copyright 2011, Strategic Gains, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.joker.common.http.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Supports the concept of sorting a result based on the 'sort' query parameter.
 * The value of the sort parameter will be the name of the field to sort on,
 * prefixed with a dash ('-') for descending order. Sort on multiple fields by
 * separating field names with a vertical bar ('|').
 * <p/>
 * To sort on name (ascending): ?sort=name
 * <p/>
 * To sort on name (descending): ?sort=-name
 * <p/>
 * To sort on name (descending), description (ascending), creation date
 * (descending): ?sort=-name|description|-createdAt
 * 
 * @author toddf
 * @since Apr 12, 2011
 */
public class QueryOrder {
	private List<OrderComponent> sorts = null;

	public QueryOrder() {
		super();
	}

	/**
	 * Create a QueryOrder instance from an array of property names to order on,
	 * prefixed with '-' to sort descending.
	 * 
	 * @param strings
	 *            property name(s) to sort on (prefixed with '-' to sort
	 *            descending).
	 */
	public QueryOrder(String... strings) {
		this();

		if (strings == null || strings.length == 0)
			return;

		addSort(strings);
	}

	/**
	 * Add sort order(s) to this QueryOrder instance.
	 * 
	 * @param strings
	 *            property names to sort on (prefixed with '-' to sort
	 *            descending).
	 * @return this QueryOrder instance to facilitate method chaining.
	 */
	public QueryOrder addSort(String... strings) {
		if (sorts == null) {
			sorts = new ArrayList<OrderComponent>(strings.length);
		}

		for (String sortString : strings) {
			boolean isDescending = sortString.startsWith("-");
			String fieldName = sortString.replaceAll("^[+-]{1}", "");
			sorts.add(new OrderComponent(fieldName, isDescending));
		}

		return this;
	}

	/**
	 * Returns true if this QueryOrder contains sort criteria.
	 * 
	 * @return true if sort criteria are present
	 */
	public boolean isSorted() {
		return (sorts != null && !sorts.isEmpty());
	}

	public void iterate(OrderCallback callback) {
		if (callback == null || !isSorted())
			return;

		for (OrderComponent component : sorts) {
			callback.orderBy(component);
		}
	}
}
