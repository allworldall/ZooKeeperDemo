package com.zookeeper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookperTest extends BaseZooKeeper{

	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZookperTest zoo = new ZookperTest();
		ZooKeeper zk = zoo.start();
		zoo.createNode(zk, PATH, "helloWorld");
		System.out.println(zoo.getZNode(zk, PATH));
		zoo.stopZooKeeper(zk);
	}
	
	
	
	
	
	
	
	
	
	
}
