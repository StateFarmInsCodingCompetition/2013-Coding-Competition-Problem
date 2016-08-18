//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.xmlhandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;



//
//Do not change anything in the following JAVA class!
//
public class XMLHandlerTest {
	 	private IXMLHandler xmlHandler = new XMLHandler();
		private Input input1 = new Input();
		private Header header = new Header();
		private Body body = new Body();
		private OperationInput operationInput = new OperationInput();
		private Output outputTest = new Output();
		private String outputParameter = "";
		
	    @Before
	    public void setUp() throws Exception {
	    	//Input XML values
	    	header.setService("get_benefit_information");
	    	operationInput.setEmployeeID("1234");
	    	body.setOperationInput(operationInput);
	    	input1.setBody(body);
	    	input1.setHeader(header);

	    	//Output XML values
	    	outputTest.setService("get_benefit_information");
	    	
	    	Body body = new Body();
	    	Benefits benefits = new Benefits();
	    	benefits.setEmployeeID("1234");
	    	
	    	EmployeeInfo employeeInfo = new EmployeeInfo();
	    	employeeInfo.setName("Big Bird");
	    	employeeInfo.setGender("M");
	    	employeeInfo.setStreetAddress("1 Sesame Street");
	    	employeeInfo.setCity("Bloomington");
	    	employeeInfo.setState("IL");
	    	employeeInfo.setZip("61704");
	    	
	    	RetirementAccounts retirementAccounts = new RetirementAccounts();
	    	retirementAccounts.setRothIRABalance("$10,500");
	    	retirementAccounts.setPensionBalance("$5,000");
	    	
	    	benefits.setEmployeeInfo(employeeInfo);
	    	benefits.setRetirementAccounts(retirementAccounts);
	    	
	    	body.setBenefits(benefits);
	    	outputTest.setBody(body);
	    	
	    	//outputParameter = "<Output ><Service>get_benefit_information</Service><Body><Benefits><EmployeeID>1234</EmployeeID><EmployeeInfo><Name>Big Bird</Name><Gender>M</Gender><StreetAddress>1 Sesame Street</StreetAddress><City>Bloomington</City><State>IL</State><Zip>61704</Zip></EmployeeInfo><RetirementAccounts><RothIRABalance>$10,500</RothIRABalance><PensionBalance>$5,000</PensionBalance></RetirementAccounts></Benefits></Body></Output>";
	    	outputParameter = "<Output><service>get_benefit_information</service><body><benefits><employeeID>1234</employeeID><employeeInfo>  <name>Big Bird</name> <gender>M</gender><streetAddress>1 Sesame Street</streetAddress>  <city>Bloomington</city> <state>IL</state> <zip>61704</zip></employeeInfo><retirementAccounts><rothIRABalance>$10,500</rothIRABalance><pensionBalance>$5,000</pensionBalance></retirementAccounts></benefits></body></Output>";
	    }
			
	    /**
	     * Tests that only input XML is valid.
	     */
	    @Test
	    public void testSendValidInputXMLInputValue() {
	    	//System.out.println(xmlHandler.toXML(input1));
	    	assertTrue(xmlHandler.toXML(input1).contains("<Input>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("</Input>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("<Header>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("</Header>"));
	    	assertTrue(xmlHandler.toXML(input1).contains(" <Service>get_benefit_information</Service>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("<Body>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("</Body>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("<EmployeeID>1234</EmployeeID>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("<OperationInput>"));
	    	assertTrue(xmlHandler.toXML(input1).contains("</OperationInput>"));
	    }

	    /**
	     * Tests that only input XML is not null.
	     */
	    @Test
	    public void testInputXMLNotNull() {
	    	assertNotNull(xmlHandler.toXML(input1));
	       
	    }
	    
	    /**
	     * Tests that only output XML is valid.
	     */
	    @Test
	    public void testSendValidOutputXML() {

	    	assertEquals(xmlHandler.fromXML(outputParameter).getService().toString(),outputTest.getService().toString());
	    	assertTrue(xmlHandler.fromXML(outputParameter).getService().toString().equals("get_benefit_information"));
	    	
	    	assertEquals(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getRetirementAccounts().getPensionBalance().toString(), outputTest.getBody().getBenefits().getRetirementAccounts().getPensionBalance().toString());
	    	assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getRetirementAccounts().getPensionBalance().toString().equals("$5,000"));
	    	
	    	assertEquals(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getRetirementAccounts().getRothIRABalance().toString(), outputTest.getBody().getBenefits().getRetirementAccounts().getRothIRABalance().toString());
	    	assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getRetirementAccounts().getRothIRABalance().toString().equals("$10,500"));
	    	
	    	assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getName().toString().equals("Big Bird"));
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getGender().toString().equals("M"));
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getStreetAddress().toString().equals("1 Sesame Street"));
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getCity().toString().equals("Bloomington"));
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getState().toString().equals("IL"));
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeInfo().getZip().toString().equals("61704"));	
   			assertTrue(xmlHandler.fromXML(outputParameter).getBody().getBenefits().getEmployeeID().toString().equals("1234"));	
   					
	    }

	   

	    /**
	     * Tests that only output XML is invalid.
	     */
	    @Test
	    public void testSendInvalidOutputXML() {
	    	assertFalse(xmlHandler.fromXML(outputParameter).getBody().equals(outputTest));
	       
	    }
}
