package es.logixs.web.genericos;

import java.util.LinkedList;
import java.util.Queue;

public class ColaLimitada<T> {

    private Queue<T> cola= new  LinkedList<T>();


    public void offer (T elemento) {

        if (cola.size()<=5) 
        cola.offer(elemento);
        else throw new RuntimeException("la cola esta llena");
    }

    public T poll () {
        return cola.poll();
    }
    
    
}
