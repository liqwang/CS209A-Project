package edu.sustech.search.engine.github.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry<U, T> {
    @JsonProperty("key")
    private U key;

    @JsonProperty("value")
    private T value;

    /**
     * This will only be called by JsonParsers/JsonWriters
     */
    @Deprecated
    public Entry() {
    }

    public Entry(U key, T value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return this.key;
    }

    public T getValue() {
        return this.value;
    }

    public void setKey(U key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + System.identityHashCode(this) + "]:" + "[key={" + key.toString() + "}, value={" + value.toString() + "}]";
    }
}
