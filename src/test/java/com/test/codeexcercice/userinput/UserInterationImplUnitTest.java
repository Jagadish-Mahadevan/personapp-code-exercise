package com.test.codeexcercice.userinput;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserInterationImplUnitTest {
	
	@InjectMocks
	UserInterationImpl interaction;
	
	@Test
	public void test_getUserOptions() throws FileNotFoundException {
		UserData actual = interaction.getUserOptions(new FileInputStream(new File("test-data.txt")));
		assertEquals(1, actual.getCode());
		//TODO - assert other values as well
	}
	
	//TODO - repeat for other  cases in the switch
}
