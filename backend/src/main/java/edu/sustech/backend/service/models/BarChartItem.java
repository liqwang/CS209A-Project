package edu.sustech.backend.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarChartItem<K, V> {
    @JsonProperty("x")
    private K x;

    @JsonProperty("y")
    private V y;

    public BarChartItem() {
    }

    public BarChartItem(K key, V value){
        x = key;
        y = value;
    }

    public K getX() {
        return x;
    }

    public void setX(K x) {
        this.x = x;
    }

    public V getY() {
        return y;
    }

    public void setY(V y) {
        this.y = y;
    }
}
