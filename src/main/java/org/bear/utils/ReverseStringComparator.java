package org.bear.utils;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String> {
	@Override
	public int compare(String string1, String string2) {
		return string2.compareTo(string1);
	}
}
