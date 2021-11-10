package com.creditsuisse.parser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.creditsuisse.parser.builder.EventBuilder;
import com.creditsuisse.parser.model.Event;

public class ServiceLogsDaoTest {
	@InjectMocks
	private ServerLogsDao serverLogsDao;
	@Mock
	private Connection mockConnection;
	@Mock
	private Statement mockStatement;
	@Mock
	private PreparedStatement mockPreparedStatement;
	@Mock
	private ResultSet mockResultSet;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createEventsTable() throws SQLException {
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.anyString())).thenReturn(1);
		serverLogsDao.createEventsTable();
	}

	@Test
	public void writeEvent() throws SQLException {
		Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
		Event event = new EventBuilder("test", 2, false).withHost(null).withType(null).build();
		serverLogsDao.writeEvent(event);
	}

	@Test
	public void selectAll() throws SQLException {
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockStatement.executeQuery(Mockito.anyString())).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.next()).thenReturn(true);
		Mockito.when(mockResultSet.getBoolean(Mockito.anyString())).thenReturn(true);
		serverLogsDao.selectAll();
	}

	@Test
	public void deleteAll() throws SQLException {
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);
		serverLogsDao.deleteAll();
	}

	@Test
	public void closeDatabase() throws SQLException {
		serverLogsDao.closeDatabase();

	}
}
