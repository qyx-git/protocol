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
	 * ���л�
	 * @throws IOException 
	 */
	public static byte[] toBytes() throws IOException{
		//ʵ����Player����,�������
		Player player = new Player(1, 18, "niub");
		player.getSkills().add(1001);
		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		
		//д�����
		objectOutputStream.writeObject(player);
		
		//��ȡ�ֽ�����
		byte[] array = byteArrayOutputStream.toByteArray();
		System.out.println(Arrays.toString(array));
		System.out.println("���л����鳤��Ϊ:"+array.length);
		return array;
	}
	/**
	 * �����л�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void toPlayer(byte[] array) throws IOException, ClassNotFoundException{
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(array));
		
		Player player  = (Player) objectInputStream.readObject();
		
		//��ӡ
		System.out.println("id:"+player.getPlayerId());
		System.out.println("age:"+player.getAge());
		System.out.println("name:"+player.getName());
		System.out.println("skills:"+Arrays.toString(player.getSkills().toArray()));
	}
	
}
