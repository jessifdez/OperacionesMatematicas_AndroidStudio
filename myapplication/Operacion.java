package com.example.maanas.myapplication;

class Operacion {
    private static int numero1,numero2,resultado;
    private static char signo;

    public static char getSigno() {
        return signo;
    }

    public static int getNumero1() {
        return numero1;
    }

    public static int getNumero2() {
        return numero2;
    }

    public static int getResultado() {
        return resultado;
    }

    public Operacion(int numero1, int numero2, int resultado, char signo) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.resultado = resultado;
        this.signo = signo;


    }
    public static Operacion obtenerSuma() {//Devuelve objeto tipo Operacion
        char signo='+';
        int numero1= Aleatorio.obtenerAleatorio();
        int numero2= Aleatorio.obtenerAleatorio();
        int resultado=numero1+numero2;
        Operacion o=new Operacion(numero1, numero2, resultado, signo);
        return o;
    }
    public static Operacion obtenerResta() {
        int numero1=Aleatorio.obtenerAleatorio();
        int numero2=Aleatorio.obtenerAleatorio();
        //Para que numero1 sea siempre mayor que numero2 le pido que:
        /*while(numero2>numero1){
            numero2=obtenerAleatorio();
        }*/
        //Otra forma es cambiar el orden de los numeros
        if(numero1<numero2){
            int a=numero1;
            numero1=numero2;
            numero2=a;
        }
        char signo='-';
        int resultado=numero1-numero2;
        Operacion o=new Operacion(numero1, numero2, resultado, signo);
        return o;
    }
    public static Operacion obtenerMultiplicacion() {
        char signo='x';
        int numero1=Aleatorio.obtenerAleatorio();
        int numero2=Aleatorio.obtenerAleatorio();
        int resultado=numero1*numero2;
        Operacion o=new Operacion(numero1, numero2, resultado, signo);
        return o;
    }
}
