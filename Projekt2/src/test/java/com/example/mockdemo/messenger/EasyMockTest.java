package com.example.mockdemo.messenger;

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
	public void CorrectServer_CheckConnection() {
		EasyMock.expect(mockService.checkConnection("inf.ug.edu.pl")).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(mockService);
		int result = msg.testConnection("inf.ug.edu.pl");
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectServerWithoutConnection_CheckConnection() {
		EasyMock.expect(mockService.checkConnection("inf.ug.edu.pl")).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection("inf.ug.edu.pl");
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void IncorrectServer_CheckConnection() {
		EasyMock.expect(mockService.checkConnection("inf.ug.edu.com")).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection("inf.ug.edu.com");
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void NullServer_CheckConnection() {
		EasyMock.expect(mockService.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectServerAndMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.ug.edu.pl", "Message")).andReturn(SendingStatus.SENT);
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.ug.edu.pl", "Message");
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectServerAndMessage_SendingError() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.ug.edu.pl", "Message")).andReturn(SendingStatus.SENDING_ERROR);
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.ug.edu.pl", "Message");
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void IncorrectServerAndMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("xxx", "Ms")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("xxx", "Ms");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.ug.edu.pl", "Ms")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.ug.edu.pl", "Ms");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectServer_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("xxx", "Message")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("xxx", "Message");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectServerAndNullMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("xxx", null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("xxx", null);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectServerAndNullMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send("inf.ug.edu.pl", null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage("inf.ug.edu.pl", null);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void CorrectMessageAndNullServer_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(null, "Message")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(null, "Message");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void IncorrectMessageAndNullServer_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(null, "Ms")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(null, "Ms");
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void NullServerAndMessage_Send() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(null, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
}
