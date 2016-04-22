package org.tguduru.hbase.crud;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.tguduru.hbase.HBaseConnection;

import java.io.IOException;

/**
 * Demonstrates the usage of {@link Put}.
 * @author Guduru, Thirupathi Reddy
 * @modified 1/26/16
 */
public class HBasePut {
    public static void main(final String[] args) throws IOException {
        final Table table = new HBaseConnection("user").getTable();
        System.out.println(table.getTableDescriptor());
        // Put with bytes
        final Put put = new Put(toBytes("/user:1"));
        put.addColumn(toBytes("basic"), toBytes("name"), toBytes("Bob"));
        System.out.println(put);
        table.put(put);

        // Put with KeyValue
        final Put put1 = new Put(toBytes("/user:2"));
        final KeyValue keyValue = new KeyValue(toBytes("/user:2"),toBytes("basic"), toBytes("name"), toBytes("Fred"));
        put1.add(keyValue);
        System.out.println(keyValue);
        table.put(put1);
        table.close();
        //This will write the data into 'user' table, use HBase Get class or hbase shell to verify the data.
        System.out.println("Write Data Completed");
    }
}
