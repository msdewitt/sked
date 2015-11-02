package edu.bsu.sked.model;

import org.junit.*;

import edu.bsu.sked.model.SkedData;

public class SkedDataTest {

	@Test
	public void defaultUserIsUnidentifiedUser() {
		SkedData data = SkedData.initialize();
		Assert.assertEquals("Unidentified user ", data.getName().getFullName());
	}	
	
}