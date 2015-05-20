package org.bigtech.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * A Simple test class to populate data into USER table of HBase
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
public class UserDataPopulate {
	/**
	 * Populates data into user table.
	 * <p>
	 * Before you need to create a table using the following shell command
	 * <code>  create 'user', {NAME => 'data'} </code>
	 * 
	 * @throws IOException
	 */
	@Test
	public void populateUserTable() throws IOException {
		Configuration configuration = HBaseConfiguration.create();
		HTable table = new HTable(configuration, "user");
		String rowKey = "/user/3";
		Put put = new Put(Bytes.toBytes(rowKey));
		byte[] family = Bytes.toBytes("data");
		byte[] qualifier = Bytes.toBytes("name");
		byte[] value = Bytes.toBytes("Tom Braddy");
		put.add(family, qualifier, value);
		table.put(put);
		table.close();
	}
}
