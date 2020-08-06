package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

/**
 * @author Eduarda de Brum Lucena
 */
public class Teste {

    @Somar
    private BigDecimal n1;

    @Somar
    private BigDecimal n2;

    @Subtrair
    private BigDecimal n3;

    @Subtrair
    private BigDecimal n4;

    public BigDecimal getN1() {
        return n1;
    }

    public void setN1(BigDecimal n1) {
        this.n1 = n1;
    }

    public BigDecimal getN2() {
        return n2;
    }

    public void setN2(BigDecimal n2) {
        this.n2 = n2;
    }

    public BigDecimal getN3() {
        return n3;
    }

    public void setN3(BigDecimal n3) {
        this.n3 = n3;
    }

    public BigDecimal getN4() {
        return n4;
    }

    public void setN4(BigDecimal n4) {
        this.n4 = n4;
    }
}
