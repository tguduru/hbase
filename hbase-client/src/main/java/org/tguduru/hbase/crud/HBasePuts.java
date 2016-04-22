package org.tguduru.hbase.crud;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import com.google.common.collect.Lists;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.tguduru.hbase.HBaseConnection;

import java.io.IOException;
import java.util.List;

/**
 * Demonstrates the usage of {@link List} of {@link Put} writing into a table as a batch.
 * @author Guduru, Thirupathi Reddy
 * @modified 1/28/16
 */
public class HBasePuts {
    public static void main(final String[] args) throws IOException {
        final Table table = new HBaseConnection("user").getTable();
        final List<Put> puts = Lists.newArrayList();

        final Put put1 = new Put(toBytes("/user:3"));
        put1.addColumn(toBytes("basic"), toBytes("name"), toBytes("User3"));
        puts.add(put1);
        final Put put2 = new Put(toBytes("/user:4"));
        put2.addColumn(toBytes("basic"), toBytes("name"), toBytes("User4"));
        puts.add(put2);
        table.put(puts);
        System.out.println("Written batch Puts");
    }
}
