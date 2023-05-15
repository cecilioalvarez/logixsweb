package es.logixs.web.genericos;

public class PruebaGenericos {

    public static void main(String[] args) {

        ColaLimitada<String> cola = new ColaLimitada<String>();

        cola.offer("hola");
        cola.offer("que");
        cola.offer("tal");
        cola.offer("estas");

        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
    }

}
