package com.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class java2Bytes {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		byte[] bytes = toBytes();
		toPlayer(bytes);
	}
	
	/**
	 * 序列化
	 * @throws IOException 
	 */
	public static byte[] toBytes() throws IOException{
		//实例化Player对象,添加数据
		Player player = new Player(1, 18, "niub");
		player.getSkills().add(1001);
		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		
		//写入对象
		objectOutputStream.writeObject(player);
		
		//获取字节数组
		byte[] array = byteArrayOutputStream.toByteArray();
		System.out.println(Arrays.toString(array));
		System.out.println("序列化数组长度为:"+array.length);
		return array;
	}
	/**
	 * 反序列化
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void toPlayer(byte[] array) throws IOException, ClassNotFoundException{
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(array));
		
		Player player  = (Player) objectInputStream.readObject();
		
		//打印
		System.out.println("id:"+player.getPlayerId());
		System.out.println("age:"+player.getAge());
		System.out.println("name:"+player.getName());
		System.out.println("skills:"+Arrays.toString(player.getSkills().toArray()));
	}
	
}
