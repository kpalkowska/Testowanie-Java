package com.example.mockdemo.app;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoTest {
	
	@Mock
	MessageService mockService;
	private Messenger msg;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		msg = new Messenger(mockService);
	}
	
	@Test
	public void CorrectServer_CheckConnection() {
		when(mockService.checkConnection("inf.ug.edu.pl")).thenReturn(ConnectionStatus.SUCCESS);
		int result = msg.testConnection("inf.ug.edu.pl");
		assertEquals(0, result);
		verify(mockService).checkConnection("inf.ug.edu.pl");
	}
	
	@Test
	public void CorrectServerWithoutConnection_CheckConnection() {
		when(mockService.checkConnection("inf.ug.edu.pl")).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection("inf.ug.edu.pl");
		assertEquals(1, result);
		verify(mockService).checkConnection("inf.ug.edu.pl");
	}
	
	@Test
	public void IncorrectServer_CheckConnection() {
		when(mockService.checkConnection("inf.ug.edu.com")).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection("inf.ug.edu.com");
		assertEquals(1, result);
		verify(mockService).checkConnection("inf.ug.edu.com");
	}
	
	@Test
	public void NullServer_CheckConnection() {
		when(mockService.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		verify(mockService).checkConnection(null);
	}
	
	@Test
	public void CorrectServerAndMessage_Send() throws MalformedRecipientException {
		when(mockService.send("inf.ug.edu.pl", "Message")).thenReturn(SendingStatus.SENT);
		int result = msg.sendMessage("inf.ug.edu.pl", "Message");
		assertEquals(0, result);
		verify(mockService).send("inf.ug.edu.pl", "Message");
	}
	
	@Test
	public void IncorrectServerAndMessage_Send() throws MalformedRecipientException {
		when(mockService.send("xxx", "Ms")).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage("xxx", "Ms");
		assertEquals(2, result);
		verify(mockService).send("xxx", "Ms");
	}
	
	@Test
	public void CorrectServerAndMessage_SendingError() throws MalformedRecipientException {
		when(mockService.send("inf.ug.edu.pl", "Message")).thenReturn(SendingStatus.SENDING_ERROR);
		int result = msg.sendMessage("inf.ug.edu.pl", "Message");
		assertEquals(1, result);
		verify(mockService).send("inf.ug.edu.pl", "Message");
	}
	
	@Test
	public void IncorrectMessage_Send() throws MalformedRecipientException {
		when(mockService.send("inf.ug.edu.pl", "Ms")).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage("inf.ug.edu.pl", "Ms");
		assertEquals(2, result);
		verify(mockService).send("inf.ug.edu.pl", "Ms");
	}
	
	@Test
	public void IncorrectServer_Send() throws MalformedRecipientException {
		when(mockService.send("xxx", "Message")).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage("xxx", "Message");
		assertEquals(2, result);
		verify(mockService).send("xxx", "Message");
	}
	
	@Test
	public void CorrectServerAndNullMessage_Send() throws MalformedRecipientException {
		when(mockService.send("inf.ug.edu.pl", null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage("inf.ug.edu.pl", null);
		assertEquals(2, result);
		verify(mockService).send("inf.ug.edu.pl", null);
	}
	
	@Test
	public void IncorrectServerAndNullMessage_Send() throws MalformedRecipientException {
		when(mockService.send("xxx", null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage("xxx", null);
		assertEquals(2, result);
		verify(mockService).send("xxx", null);
	}
	
	@Test
	public void CorrectMessageAndNullServer_Send() throws MalformedRecipientException {
		when(mockService.send(null, "Message")).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, "Message");
		assertEquals(2, result);
		verify(mockService).send(null, "Message");
	}
	
	@Test
	public void IncorrectMessageAndNullServer_Send() throws MalformedRecipientException {
		when(mockService.send(null, "Ms")).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, "Ms");
		assertEquals(2, result);
		verify(mockService).send(null, "Ms");
	}
	
	@Test
	public void NullServerAndMessage_Send() throws MalformedRecipientException {
		when(mockService.send(null, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		verify(mockService).send(null, null);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		msg = null;
	}

}
