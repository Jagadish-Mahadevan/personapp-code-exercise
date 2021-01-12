package com.test.codeexcercice.userinput.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.codeexcercice.userinput.strategy.PersonAddStrategy;
import com.test.codeexcercice.userinput.strategy.PersonCountStrategy;
import com.test.codeexcercice.userinput.strategy.PersonDeleteStrategy;
import com.test.codeexcercice.userinput.strategy.PersonEditStrategy;
import com.test.codeexcercice.userinput.strategy.PersonListStrategy;
import com.test.codeexcercice.userinput.strategy.PersonStrategyFactory;

@RunWith(MockitoJUnitRunner.class)
public class PersonStrategyFactoryUnitTest {

	@InjectMocks
	PersonStrategyFactory factory;
	
	@Mock
	PersonAddStrategy personAddStrategy;
	@Mock
	PersonEditStrategy personEditStrategy;
	@Mock
	PersonDeleteStrategy personDeleteStrategy;
	@Mock
	PersonListStrategy personListStrategy;
	@Mock
	PersonCountStrategy personCountStrategy;
	
	@Test
	public void test_getPersonStrategy() {
		assertEquals(personAddStrategy, factory.getPersonStrategy(1));
	}
	
	//TODO - similarly for other strategies by passing 2,3,4 and 5
	
	//TODO - also expect RuntimeException if invalid code is passed  
}
