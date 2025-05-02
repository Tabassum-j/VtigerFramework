package practice.TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
@BeforeSuite
public void BeforeSuite1() {
	System.out.println("BeforeSuite1");
}
@BeforeSuite
public void BeforeSuite2() {
	System.out.println("BeforeSuite2");
}
@BeforeTest
public void BeforeTest1() {
	System.out.println("BeforeTest");
}
@BeforeClass
public void BeforeClass() {
	System.out.println("BeforeClass");
}
@BeforeMethod
public void BeforeMethod1() {
	System.out.println("BeforeMethod1");
}
@BeforeMethod
public void BeforeMethod2() {
	System.out.println("BeforeMethod2");
}

@AfterMethod
public void AfterMethod() {
	System.out.println("AfterMethod");
}
@AfterClass
public void AfterClass() {
	System.out.println("AfterClass");
}

@AfterTest
public void AfterTest() {
	System.out.println("AfterTest");
}

@AfterSuite
public void AfterSuite1() {
	System.out.println("AfterSuite1");
}

@AfterSuite
public void AfterSuite2() {
	System.out.println("AfterSuite2");
}

@AfterSuite
public void AfterSuite3() {
	System.out.println("AfterSuite3");
}
@Test(priority = 1)
public void testAnnotationMethod1() {
	System.out.println("testAnnotation1");
}

@Test
public void testAnnotationMethod2() {
	System.out.println("testAnnotation2");
}

@Test
public void testAnnotationMethod3() {
	System.out.println("testAnnotation3");
}


}
