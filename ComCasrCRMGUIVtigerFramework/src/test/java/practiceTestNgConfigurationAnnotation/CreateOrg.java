package practiceTestNgConfigurationAnnotation;

import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class CreateOrg extends BaseClass {
	
	@Test
	public void OrganizationTest() {
		System.out.println("Execute create Organization Test");
	}
	
	@Test
	public void createOrganizationWithIndustryTest() {
		System.out.println("Execute create Organization with Industry Test");
	}
	

}
