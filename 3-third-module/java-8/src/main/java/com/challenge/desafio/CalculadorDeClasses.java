package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author Eduarda de Brum Lucena
 */
public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return calculate(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calculate(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        BigDecimal sum = somar(object);
        BigDecimal subtract = subtrair(object);
        return sum.subtract(subtract);
    }

    private BigDecimal calculate(Object object, Class<? extends Annotation> annotation) {
        BigDecimal resultOperation = BigDecimal.ZERO;
        Class<?> myClass = object.getClass();
        Field[] classDeclaredFields = myClass.getDeclaredFields();

        try {

            for (Field field : classDeclaredFields) {
                if (fieldIsBigDecimalAndHasAnnotation(field, annotation)) {
                    field.setAccessible(true);
                    BigDecimal fieldValue = (BigDecimal) field.get(object);
                    resultOperation = resultOperation.add(fieldValue);
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        }

        return resultOperation;
    }

    private boolean fieldIsBigDecimalAndHasAnnotation(Field field, Class<? extends Annotation> annotation) {
        return BigDecimal.class.equals(field.getType()) && field.isAnnotationPresent(annotation);
    }
}
