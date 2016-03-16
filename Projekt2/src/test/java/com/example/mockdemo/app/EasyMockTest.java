package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {

	private Messenger msg;
	private MessageService mockService;
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(MessageService.class);
		msg = new Messenger(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		msg = null;
	}

	@Test
	public void CorrectCheckConnection() {
		EasyMock.expect(mockService.checkConnection("inf.ug.edu.pl")).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(mockService);
		int result = msg.testConnection("inf.ug.edu.pl");
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void IncorrectCheckConnection() {
		EasyMock.expect(mockService.checkConnection("inf.ug.edu.com")).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection("inf.ug.edu.com");
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectSendAddressAndMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.pl", "Message")).andReturn(SendingStatus.SENT);
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.pl", "Message");
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void SendingError() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.pl", "Message")).andReturn(SendingStatus.SENDING_ERROR);
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.pl", "Message");
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void IncorrectSendAddressAndMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("wp.pl", "Mess")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("wp.pl", "Mess");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectSendMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.pl", "Mess")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.pl", "Mess");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectSendAddress() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("wp.pl", "Message")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("wp.pl", "Message");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
}
