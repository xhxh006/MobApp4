package com.ma.mj.hw4;

/**
 * Created by KimMinJung on 2017-04-04.
 */

public class Data {
    String table, entrance, pasta, pizza, mem;

    public Data(String entrance, String pasta, String pizza, String mem) {
        //this.table = table;
        this.entrance = entrance;
        this.pasta = pasta;
        this.pizza = pizza;
        this.mem = mem;
    }

    public String getTable() {return table;}
    public String getEntrance(){
        return entrance;
    }
    public String getPasta(){
        return pasta;
    }
    public String getPizza(){
        return pizza;
    }
    public String getMem(){
        return mem;
    }

    public void setTable(String table) {this.table = table;}
    public void setEntrance(String s){
        this.entrance = s;
    }
    public void setPasta(String s){
        this.pasta = s;
    }
    public void setPizza(String s){
        this.pizza = s;
    }
    public void setMem(String s){ this.mem = s; }
}
