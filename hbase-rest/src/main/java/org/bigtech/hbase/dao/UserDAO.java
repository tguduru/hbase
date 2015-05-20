package org.bigtech.hbase.dao;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.bigtech.hbase.dao.object.User;
import org.bigtech.hbase.dao.util.Constants;
import org.bigtech.hbase.dao.util.Util;

import com.google.common.collect.Lists;

/**
 * DAO to access/write data using HBase user table.
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
public class UserDAO {
	private final Configuration configuration;
	private final HTable hTable;

	/**
	 * @throws IOException
	 * 
	 */
	public UserDAO() throws IOException {
		configuration = HBaseConfiguration.create();
		hTable = new HTable(configuration, Constants.table);
	}

	public String getUserName(User user) throws IOException {
		Get get = new Get(Bytes.toBytes(Constants.partialRowKey
				+ user.getUserId()));
		Result result = hTable.get(get);
		if (result.isEmpty()) {
			hTable.close();
			return "User Not Found";
		}

		byte[] value = result.getValue(Bytes.toBytes(Constants.columnFamily),
				Bytes.toBytes(Constants.columnQualifier));
		hTable.close();
		return new String(value);
	}

	public boolean writeUserName(User user) throws IOException {
		Put put = new Put(Bytes.toBytes(Constants.partialRowKey
				+ user.getUserId()));
		byte[] family = Bytes.toBytes(Constants.columnFamily);
		byte[] qualifier = Bytes.toBytes(Constants.columnQualifier);
		byte[] value = Bytes.toBytes(user.getUserName());
		put.add(family, qualifier, value);
		hTable.put(put);
		hTable.close();
		System.out.println("Added user with id: " + user.getUserId()
				+ ", name: " + user.getUserName());
		return true;
	}

	public List<User> getAllUsers() throws IOException {
		List<User> users = Lists.newArrayList();
		Scan scan = new Scan(Bytes.toBytes(Constants.partialRowKey));
		ResultScanner scanner = hTable.getScanner(scan);
		for (Result result : scanner) {
			byte[] rowKeyBytes = result.getRow();
			byte[] userNameBytes = result.getValue(
					Bytes.toBytes(Constants.columnFamily),
					Bytes.toBytes(Constants.columnQualifier));
			String userName = new String(userNameBytes);
			String rowKey = new String(rowKeyBytes);
			int id = Util.parseRowKey(rowKey);
			User user = new User(userName, id);
			users.add(user);
		}
		return users;
	}
}
