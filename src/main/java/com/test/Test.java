package com.test;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;

/**
 * @auth chenmingzhou
 */
public class Test {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new RetryNTimes(5, 10);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.6.128:2181", retryPolicy);
        client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                System.out.println(newState.name());
            }
        });
        client.start();
//        try {
//            client.create().withMode(CreateMode.PERSISTENT).forPath("/test");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }finally {
//            client.close();
//        }

    }
}
