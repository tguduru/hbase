package org.bigtech.hbase.dao.util;

/**
 * Constants for HBase client API
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
public interface Constants {
	public final String table = "user";
	public final String columnFamily = "data";
	public final String columnQualifier = "name";
	public final String partialRowKey = "/user/";
}
