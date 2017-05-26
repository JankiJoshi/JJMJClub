/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mjanes5520
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFullName method, of class Member.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Member instance = new Member();
        String expResult = "Abc";
        instance.setFullName(expResult);
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmailAddress method, of class Member.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        String expResult = "Abc@123";
        instance.setEmailAddress(expResult);
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPhoneNumber method, of class Member.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        String expResult = "1234567890";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProgramName method, of class Member.
     */
    @Test
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member instance = new Member();
        String expResult = "Abc";
        instance.setProgramName(expResult);
        String result = instance.getProgramName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getYearLevel method, of class Member.
     */
    @Test
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member instance = new Member();
        int expResult = 0;
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testValidNegative() {
        System.out.println("isValidNegative");
        Member instance = new Member();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testValidPositive() {
        System.out.println("isValidPositive");
        Member instance = new Member("Matthew", "Matt@email");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
