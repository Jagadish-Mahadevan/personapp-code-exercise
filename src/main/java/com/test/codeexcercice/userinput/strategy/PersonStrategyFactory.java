package com.test.codeexcercice.userinput.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.codeexcercice.userinput.constants.UserOption;

public class PersonStrategyFactory {

	@Autowired
	private PersonAddStrategy addStrategy;
	
	@Autowired
	private PersonEditStrategy editStrategy;
	
	@Autowired
	private PersonDeleteStrategy deleteStrategy;
	
	@Autowired
	private PersonListStrategy listStrategy;
	
	@Autowired
	private PersonCountStrategy countStrategy;
	
	public PersonStrategy<?> getPersonStrategy(int code) {
		UserOption option = UserOption.of(code);
		switch (option) {
			case ONE:
				return addStrategy;
			case TWO:
				return editStrategy;
			case THREE:
				return deleteStrategy;
			case FOUR:
				return countStrategy;
			case FIVE:
				return listStrategy;
			default:
				throw new RuntimeException("Invalid option.");
		}
	}
}
