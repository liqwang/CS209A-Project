package edu.sustech.search.engine.github.models;

public class Entry<U, T> {
    private U key;
    private T value;

    public Entry(U key, T value){
        this.key = key;
        this.value = value;
    }

    public U getKey(){
        return this.key;
    }

    public T getValue(){
        return this.value;
    }

    public void setKey(U key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
