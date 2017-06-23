package com.zookeeper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

public abstract class BaseZooKeeper {
	protected static final Logger logger = Logger.getLogger(ZookperTest.class);
	protected static final String CONNECTSTRING = "192.168.134.128:2181";
	protected static final int SESSION_TIMEOUT = 60 * 1000;
	protected static final String PATH = "/TestNode";

	public ZooKeeper start() throws IOException {

		return new ZooKeeper(CONNECTSTRING, SESSION_TIMEOUT, null);
	}
	
	public void stopZooKeeper(ZooKeeper zk) throws InterruptedException{
		if(zk!=null){
			zk.close();
		}
	}
	
	public void createNode(ZooKeeper zk,String nodePath,String nodeValue) throws KeeperException, InterruptedException{
		zk.create(nodePath,nodeValue.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	public String getZNode(ZooKeeper zk,String nodePAth) throws KeeperException, InterruptedException{
		String valueNode =null;
		byte[] value = zk.getData(nodePAth, false, new Stat());
		valueNode = new String(value);
		return valueNode;
	}
}
