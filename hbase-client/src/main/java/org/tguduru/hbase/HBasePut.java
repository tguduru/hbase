package org.tguduru.hbase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Hello world!
 */
public class HBasePut {
    public static void main(final String[] args) throws IOException {
        final Table table = new HBaseConnection().getTable();
        System.out.println(table.getTableDescriptor());
        Put put = new Put(Bytes.toBytes("/user:1"));
        put.addColumn(Bytes.toBytes("basic"),Bytes.toBytes("name"),Bytes.toBytes("Bob"));
        table.put(put);
        table.close();
        System.out.println("Write Data Completed");

        
    }
}
