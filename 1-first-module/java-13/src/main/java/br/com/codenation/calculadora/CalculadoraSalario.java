package br.com.codenation.calculadora;


public class CalculadoraSalario {

    public long calcularSalarioLiquido(double salarioBase) {
        if (salarioBase < 1039.00 || salarioBase < 0) {
            return 0;
        }

        double descontoInss = calcularInss(salarioBase);
        double descontoIfrr = calcularIrrf(descontoInss);
        return Math.round(descontoIfrr);
    }


    private double calcularInss(double salarioBase) {
        double desconto;
        if (salarioBase <= 1500.00) {
            desconto = salarioBase * 0.08;
        } else if (salarioBase <= 4000.00) {
            desconto = salarioBase * 0.09;
        } else {
            desconto = salarioBase * 0.11;
        }
        return salarioBase - desconto;
    }


    private double calcularIrrf(double salarioLiquido) {
        double desconto;
        if (salarioLiquido <= 3000.00) {
            return salarioLiquido;
        } else if (salarioLiquido <= 6000.00) {
            desconto = salarioLiquido * 0.075;
        } else {
            desconto = salarioLiquido * 0.15;
        }

        return salarioLiquido - desconto;
    }
}