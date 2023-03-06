package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.FramesPageObjects;
import testComponents.BaseTest;

public class FramesTest extends BaseTest {
	
	FramesPageObjects fp;
	
	@BeforeMethod(alwaysRun=true)
	public void frameThing() throws IOException
	{
		fp=frameBulding();
	}
	
	
	@Test
	public void nestedFrames()
	{
		fp.framesLogic();
	}

}
