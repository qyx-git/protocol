package com.proto;

import java.util.Arrays;

import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.PlayerModule.PBplayer;
import com.proto.PlayerModule.PBplayer.Builder;

/**
 * protobuf学习
 * @author myself
 *
 */
public class PB2Bytes {

	public static void main(String[] args) throws InvalidProtocolBufferException {
		byte[] bytes = toBytes();
		toPlayer(bytes);
	}
	/**
	 * 序列化
	 */
	public static byte[] toBytes(){
		//获取一个PBPlayer构造器
		Builder builder = PlayerModule.PBplayer.newBuilder();
		//设置数据
		builder.setPlayerId(1).setAge(18).setName("niub").setSkills(1001);
		//构造出对象
		PBplayer build = builder.build();
		//序列化成字节数组
		byte[] array = build.toByteArray();
		
		System.out.println(Arrays.toString(array));
		System.out.println("序列化数组长度为:"+array.length);
		return array;
	}
	/**
	 * 反序列化
	 * @throws InvalidProtocolBufferException 
	 */
	public static void toPlayer(byte[] array) throws InvalidProtocolBufferException{
		PBplayer parseFrom = PlayerModule.PBplayer.parseFrom(array);
		
		System.out.println("id:"+parseFrom.getPlayerId());
		System.out.println("age:"+parseFrom.getAge());
		System.out.println("name:"+parseFrom.getName());
		System.out.println("skills:"+parseFrom.getSkills());
		
	}
}
