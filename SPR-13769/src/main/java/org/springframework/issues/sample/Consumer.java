package org.springframework.issues.sample;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Consumer {

	@JmsListener(destination = "TestQueue")
	@SendTo("ReplyTestQueue")
	public byte[] receive(javax.jms.Message message)
			throws InterruptedException, JMSException {

		BytesMessage bytesMessage = (BytesMessage) message;

		long len = bytesMessage.getBodyLength();
		
		byte[] bytes = new byte[(int) len];

		bytesMessage.readBytes(bytes, (int) len);

		System.out.println("Recieved BytesMessage!");
		System.out.print("bytes data: ");
		for(byte b : bytes){
			  System.out.print(Integer.toHexString(b));
		}
		System.out.println("");
		System.out.println("String data: " + new String(bytes));

		TimeUnit.SECONDS.sleep(1);

		return bytes;

	}

	@JmsListener(destination = "TestQueue2")
	@SendTo("ReplyTestQueue2")
	public String receive2(javax.jms.Message message)
			throws InterruptedException, JMSException {

		TextMessage textMessage = (TextMessage) message;
		String text = textMessage.getText();

		System.out.println("Recieved TextMessage!");
		System.out.println("String data: " + text);

		TimeUnit.SECONDS.sleep(1);
		
		return text;

	}

}