package com.apache.maven;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestA {
	@Test
	public void verifyHelloWorld() {
		Assert.assertEquals("Aaa", "Aaa");
		System.out.println("This is Hello World");
	}

}
