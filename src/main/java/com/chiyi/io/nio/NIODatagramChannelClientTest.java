package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.text.MessageFormat;

/**
 * Created by chiyi on 2018/7/21.
 */
public class NIODatagramChannelClientTest {
	public static void main(String[] args) throws IOException {
		// build UDP connection
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(true);
		channel.connect(new InetSocketAddress("localhost",7795));

		// send UPD data
		channel.write(ByteBuffer.wrap("Hi I am request......".getBytes()));
		System.out.println("Finished send the request.");

		// receive UDP data
		ByteBuffer buffer = ByteBuffer.allocate(128);
		channel.read(buffer);
		buffer.flip();
		// resolve the UPD data
		byte[] bytes = new byte[buffer.limit()];
		int i=0;
		while (buffer.hasRemaining()){
			bytes[i] = buffer.get();
			i++;
		}
		System.out.println(MessageFormat.format("Received the server side response [{0}]",new String(bytes)));
	}
}
