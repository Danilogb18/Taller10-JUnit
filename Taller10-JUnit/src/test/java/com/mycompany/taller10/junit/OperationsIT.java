/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.taller10.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author danilo
 */
public class OperationsIT {
    
    public OperationsIT() {
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */

    @Test
    @DisplayName("Revisar que la formula no sea Null")
    public void testMakeFormulaNotNull(){
        String result = Operations.MakeFormula();
        assertNotNull(result);
    }

    @Test
    @DisplayName("Revisar que la formula no sea un string vacio.")
    public void testMakeFormulaNotEmpty(){
        String result = Operations.MakeFormula();
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Revisar que la formula solo contenga caracteres validos.")
    public void testMakeFormulaOnlyValidCharacters () {
        String result = Operations.MakeFormula();
        boolean valid = result.matches("[0-9+\\-*/]+");
        assertTrue(valid); 
    }
    @Test
    @DisplayName("Prueba de que todos los numeros sean de dos caracteres")
    public void testMakeFormulaNumbers () {
        String result = Operations.MakeFormula();
        String remplazo1= result.replace("+", ",").replace("-", ",").replace("*", ",").replace("/", ",");
        for (String numero : remplazo1.split(",")) {
            assertEquals(numero.length(), 2);
        }
    }

    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testSolve() {
        //System.out.println("Solve");
        //String formula = "";
        //String expResult = "";
        //String result = Operations.Solve(formula);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
