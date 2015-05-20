package org.bigtech.hbase.dao.util;

/**
 * Utility for general processing
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
public class Util {
	public static int parseRowKey(String rowKey) {
		String rowId = rowKey.substring(rowKey.lastIndexOf("/") + 1);
		return Integer.parseInt(rowId);
	}
}
