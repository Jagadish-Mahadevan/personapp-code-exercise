package com.test.codeexcercice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.codeexcercice.config.SpringContextConfiguration;
import com.test.codeexcercice.model.Response;
import com.test.codeexcercice.userinput.UserData;
import com.test.codeexcercice.userinput.UserInteration;
import com.test.codeexcercice.userinput.strategy.PersonStrategy;
import com.test.codeexcercice.userinput.strategy.PersonStrategyFactory;

public class App 
{
    public static void main( String[] args )
    {
	    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
	    	PersonStrategyFactory factory = context.getBean(PersonStrategyFactory.class);
	    	UserInteration userInteraction = context.getBean(UserInteration.class);
	    	while (true) {
		    	UserData data = userInteraction.getUserOptions(System.in);
		    	PersonStrategy<?> strategy = factory.getPersonStrategy(data.getCode());
		    	Response<?> response = strategy.process(data.getParams());
		    	System.out.println(response.getResultMessage());
		    	System.out.println(response.getBody());
	    	}
    }
}
