package com.example.bbdd;

/**
 * Created by guopm on 14/05/2017.
 */
public class DataSource {
    private String dataBase;
    private String port;

    public DataSource(String dataBase, String port) {
        this.dataBase = dataBase;
        this.port = port;
    }

    public String getDataBase() {
        return dataBase;
    }

    public String getPort() {
        return port;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "dataBase='" + dataBase + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
