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
import static org.junit.jupiter.api.Assertions.*;


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
    @DisplayName("Test de Suma Básica")
    public void testSolve() {
        String formula = "02+02";
        String rTeorico = "02+02=4";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }
    
    @Test
    @DisplayName("Test de Resta Básica")
    public void testSolveResta() {
        String formula = "05-03";
        String rTeorico = "05-03=2";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }
    
    @Test
    @DisplayName("Test de Multiplicación Básica")
    public void testSolveMultiplicacion() {
        String formula = "03*04";
        String rTeorico = "03*04=12";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }

    @Test
    @DisplayName("Test de Multiplicación con Cero") 
    public void testSolveMultiplicacionCero() {
        String formula = "03*00";
        String rTeorico = "03*00=0";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }

    @Test
    @DisplayName("Test de División Básica")
    public void testSolveDivision() {
        String formula = "08/02";
        String rTeorico = "08/02=4";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }

    @Test
    @DisplayName("Test de División por Cero")
    public void testSolveDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            Operations.Solve("08/00");
        });
    }
    @Test
    @DisplayName("Test de Divisón operación con decimal")
    public void testSolveDivisionDecimal() {
        String formula = "05/02";
        String rTeorico = "05/02=2,5";
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }
    @Test
    @DisplayName("Prioridad de signos")
    public void testSolvePrioridad() {
        String formula = "02+03*04";
        String rTeorico = "02+03*04=14"; 
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }

    @Test
    @DisplayName("Test de Operación con Prioridad Compleja") 
    public void testSolveComplejo() {
        String formula = "02+03*04-05/05";
        String rTeorico = "02+03*04-05/05=13"; 
        String rExperimental = Operations.Solve(formula);
        assertEquals(rTeorico, rExperimental);
    }
    

}
