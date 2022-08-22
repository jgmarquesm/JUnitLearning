package com.retangulo;

public class testRetangulo {

    private Retangulo retangulo;

    public boolean testCalcularArea(){
        retangulo = new Retangulo(4, 5);
        double resultadoEsperado = 20;
        double resultado = retangulo.area();

        return resultado == resultadoEsperado;
    }

    public boolean testCalcularPerimetro(){
        retangulo = new Retangulo(4, 5);
        double resultadoEsperado = 18;
        double resultado = retangulo.perimetro();

        return resultado == resultadoEsperado;
    }
}
