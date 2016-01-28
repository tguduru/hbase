package org.tguduru.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * Provides a {@link Connection} to HBase.
 * @author Guduru, Thirupathi Reddy
 * @modified 1/26/16
 */
public class HBaseConnection {
    private final Table table;

    public HBaseConnection() throws IOException {
        final Connection connection = ConnectionFactory.createConnection();
        final TableName tableName = TableName.valueOf("user");
        table = connection.getTable(tableName);
    }

    public Table getTable() {
        return table;
    }
}
