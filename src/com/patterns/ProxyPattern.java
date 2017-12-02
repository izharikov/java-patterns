package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class ProxyPattern {
    public static void main(String... args) {
        System.out.println(" ---- create proxy object  ----");
        ProxyConnectionResource proxyConnectionResource =
                new ProxyConnectionResource("jdbc:mysql://localhost:3306/testdb");
        System.out.println(" ---- start using resource ----");
        proxyConnectionResource.use();
    }
}

interface CommonResource {
    void use();
}

class Connection {

    public Connection(String connectionString) {
        System.out.println("establishing connection: to " + connectionString);
    }

    public void printData() {
        System.out.println("data print");
    }
}

class ConnectionResource implements CommonResource {

    private Connection connection;

    public ConnectionResource(String name) {
        connection = new Connection(name);
    }

    @Override
    public void use() {
        connection.printData();
    }
}

class ProxyConnectionResource implements CommonResource {
    private ConnectionResource connectionResource;
    private String connectionString;

    public ProxyConnectionResource(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void use() {
        //  lazy init of resource
        if (connectionResource == null) {
            connectionResource = new ConnectionResource(connectionString);
        }
        connectionResource.use();
    }
}