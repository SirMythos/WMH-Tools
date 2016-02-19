package org.sirmythos.test.examples;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.sirmythos.examples.*;

public class PalindromeTest {
	
	@Test
	public void isPalindromeTest() {
		Assert.assertTrue(Palindrome.isPalindrome("Otto"), "Ist kein Palindrome");
	}
	
	@Test
	public void isNoPalindromeTest(){
		Assert.assertFalse(Palindrome.isPalindrome("Test"), "Ist ein Palindrome");
	}

}
