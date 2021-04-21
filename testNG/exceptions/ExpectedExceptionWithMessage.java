package testNG.exceptions;

import java.io.IOException;

import org.testng.annotations.Test;

public class ExpectedExceptionWithMessage {
	
	/*
	 * Test is not only expecting IOException but also 
	 * should throw the exception with a specific message for 
	 * the test to pass.
	 */
	@Test(expectedExceptions={IOException.class},
	expectedExceptionsMessageRegExp="Test Message")
		public void exceptionWithMessageTest() throws Exception{
		throw new IOException("Test Message");
	}
	
	/*
	 * This test the message passed while throwing the exception
	 * is different then expected and hence the test will fail. 
	 */
	@Test(expectedExceptions={IOException.class},
	expectedExceptionsMessageRegExp="Test Message")
		public void exceptionWithMessageTestIncorrectMessage() throws Exception{
		throw new IOException("Different Test Message");
	}
	
}
