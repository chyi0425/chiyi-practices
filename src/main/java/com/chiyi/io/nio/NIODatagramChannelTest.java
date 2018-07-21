package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.text.MessageFormat;

/**
 * Created by chiyi on 2018/7/21.
 */
public class NIODatagramChannelTest {
	public static void main(String[] args) throws IOException {
		// 设置UDP Server相关信息，并启动Server
		DatagramChannel channel = DatagramChannel.open();

		channel.configureBlocking(true);
		channel.bind(new InetSocketAddress(7795));

		while (true){
			ByteBuffer byteBuffer = ByteBuffer.allocate(128);
			// 接受不了UDP消息
			SocketAddress address = channel.receive(byteBuffer);
			byteBuffer.flip();

			byte[] bytes = new byte[byteBuffer.limit()];
			int i=0;
			while (byteBuffer.hasRemaining()){
				bytes[i]=byteBuffer.get();
				i++;
			}
			System.out.println(MessageFormat.format("From client[{0}] value [{1}]",
					address,new String(bytes)));

			// send response to UDP's address
			channel.send(ByteBuffer.wrap("Hello I am response".getBytes()),address);
			System.out.println("Finished send the response.");

		}

	}
}
