/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karolis
 */
public class BlocksTest {
    
    public BlocksTest() {
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
     * Test of getBlockheight method, of class Blocks.
     */
    @Test
    public void testGetBlockheight() {
        System.out.println("getBlockHeight");
        Blocks instance = new Blocks(3 ,7);
        int expResult = 50;
        int result = instance.getBlockheight();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetBlockwidth() {
        System.out.println("getBlockWidth");
        Blocks instance = new Blocks(50 ,7);
        int expResult = 3;
        int result = instance.getBlockheight();
        assertEquals(expResult, result);
    }
    /**
     * Test of getBlock method, of class Blocks.
     */
    
 
}
