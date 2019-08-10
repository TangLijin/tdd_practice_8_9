package com.thoughtworks.tdd;

public class Poker {
    private String value;
    private char type;

    public Poker() {
    }

    public Poker(String value, char type) {
        this.value = value;
        this.type = type;
    }

    public Poker(String poker){
        this.value = poker.substring(0,poker.length() - 1);
        this.type = poker.charAt(poker.length() - 1);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getValue() + this.getType();
    }
}
