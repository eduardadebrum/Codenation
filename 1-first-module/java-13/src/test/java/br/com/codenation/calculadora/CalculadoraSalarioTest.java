package br.com.codenation.calculadora;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Teste Calculadora Salario")
public class CalculadoraSalarioTest {

    private CalculadoraSalario calculadoraSalario;

    @BeforeEach
    void init() {
        this.calculadoraSalario = new CalculadoraSalario();
    }

    @DisplayName("Success - Calcular Liquido R$10.000,00 - Desconto Inss e Irrf")
    @Test
    public void salarioLiquidoIsNotNull() {
        long salarioLiquido = calculadoraSalario.calcularSalarioLiquido(1000.0);
        assertNotNull(salarioLiquido);
    }

    @DisplayName("Success - Calcular Liquido R$10.000,00 - Desconto Inss e Irrf")
    @Test
    void calcularLiquidoDezMilReaisDescontoInssIrrf() {
		long salario = calculadoraSalario.calcularSalarioLiquido(10000.00);
		assertEquals(7565, salario);
    }


    @DisplayName("Success - Calcular Liquido R$1.500,00 - Desconta Inss")
    @Test
    void calcularLiquidoMilQuinhetosDescontaInss() {
        long salario = calculadoraSalario.calcularSalarioLiquido(1500.00);
        assertEquals(1380.00, salario);
    }
}

