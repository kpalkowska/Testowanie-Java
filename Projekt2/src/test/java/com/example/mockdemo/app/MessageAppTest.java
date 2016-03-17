package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.MessageServiceMock;

public class MessageAppTest {

	private MessageServiceMock mockService;
	private Messenger msg;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "xxx";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		mockService = new MessageServiceMock();
		msg = new Messenger(mockService);
	}

	@Test
	public void CorrectServer_CheckConnection() {
		mockService.setConnection(true);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
	}
	
	@Test
	public void CorrectServerWithoutConnection_CheckConnection() {
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
	}
	
	@Test
	public void IncorrectServer_CheckConnection() {
		mockService.setConnection(true);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
	}
	
	@Test
	public void IncorrectServerWithoutConnection_CheckConnection() {
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
	}
	
	@Test
	public void NullServer_CheckConnection() {
		mockService.setConnection(true);
		int result = msg.testConnection(null);
		assertEquals(1, result);
	}
	
	@Test
	public void NullServerWithoutConnection_CheckConnection() {
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
	}
	
	@Test
	public void CorrectServerAndMessage_Send() {
		mockService.setMessageStatus(true);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
	}
	
	@Test
	public void CorrectServerAndMessage_SendingError() {
		mockService.setMessageStatus(false);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
	}
	
	@Test
	public void IncorrectServerAndMessage_Send() {
		int result = msg.sendMessage(INVALID_SERVER2, INVALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void InorrectServer_Send() {
		int result = msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void IncorrectMessage_Send() {
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void CorrectServerAndNullMessage_Send() {
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
	}
	
	@Test
	public void IncorrectServerAndNullMessage_Send() {
		int result = msg.sendMessage(INVALID_SERVER2, null);
		assertEquals(2, result);
	}
	
	@Test
	public void CorrectMessageAndNullService_Send() {
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void IncorrectMessageAndNullService_Send() {
		int result = msg.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void NullServiceAndMessage_Send() {
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
	}
	
	@After
	public void tearDown() throws Exception {
		mockService = null;
		msg = null;
	}
}
