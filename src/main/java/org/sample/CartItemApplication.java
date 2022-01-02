package org.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CartItemApplication {
	
	static Logger logger = LoggerFactory.getLogger(CartItemApplication.class);
	
	public static void main(String[] args) {
        try {
			Quarkus.run(args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
	
}
