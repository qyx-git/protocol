package com.proto;

import java.util.Arrays;

import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.PlayerModule.PBplayer;
import com.proto.PlayerModule.PBplayer.Builder;

/**
 * protobufѧϰ
 * @author myself
 *
 */
public class PB2Bytes {

	public static void main(String[] args) throws InvalidProtocolBufferException {
		byte[] bytes = toBytes();
		toPlayer(bytes);
	}
	/**
	 * ���л�
	 */
	public static byte[] toBytes(){
		//��ȡһ��PBPlayer������
		Builder builder = PlayerModule.PBplayer.newBuilder();
		//��������
		builder.setPlayerId(1).setAge(18).setName("niub").setSkills(1001);
		//���������
		PBplayer build = builder.build();
		//���л����ֽ�����
		byte[] array = build.toByteArray();
		
		System.out.println(Arrays.toString(array));
		System.out.println("���л����鳤��Ϊ:"+array.length);
		return array;
	}
	/**
	 * �����л�
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
