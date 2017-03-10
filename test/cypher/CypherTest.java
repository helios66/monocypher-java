/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fdamilola
 */
public class CypherTest {
    
    public CypherTest() {
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
     * Test of encrypt & decrypt method, of class Cypher.
     */
    
    @Test
    public void testEncrypt() {
        testEc("user1234@abc.com");
        testEc("");
        testEc("abdsns");
        testEc("1234556656565658*");
    }
    
    
    private void testEc(String value){
        String s = value;
        String expResult = Cypher.encrypt(s);
        String result = Cypher.encrypt(s);
        System.out.println("Encrypt => " + expResult+"+++++"+result + "==OrigValue==" +  s);
        assertEquals(expResult, result);
    }
    
    private void testDc(String value){
        String expResult = value;
        String crypt = Cypher.encrypt(expResult);
        String result = Cypher.decrypt(crypt);
        System.out.println("Decrypt -> " + result + " ===CryptValue===" + crypt);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class Cypher.
     */
    
    @Test
    public void testDecrypt() {
        testDc("user1234@abc.com");
        testDc("");
        testDc("abdsns");
        testDc("1234556656565658*");
    }
}
