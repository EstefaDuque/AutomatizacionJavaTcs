package com.mybank;

import java.util.ArrayList;

public class Account {
    Integer balance;
    Integer credit;
    ArrayList<Integer> depositList = new ArrayList<>();

    Account(){
        balance = 0;
        credit = 500;
    }

    void deposit(Integer amount){
        balance += amount;
        depositList.add(amount);
    }

    void pay(Integer amount){
        credit += amount;
    }

    ArrayList<Integer> getDepositList(){
        return depositList;
    }

    Integer getBalance(){
        Integer result = balance;
        return result;
    }

    Integer getCredit(){
        Integer result = credit;
        return result;
    }

    boolean buy(Integer amount) {

        if (amount <= 0) { return false; }

        if (balance >= amount) {    //comprar con el saldo
            deposit(-amount);       //withdrawall
            return true;
        }

        if (credit >= amount) {    //comprar con el credito
            credit -= amount;       //withdrawall
            return true;
        }

        if ( balance > 0 &&  ( balance + credit ) >= amount ) { //compra mixta debito y credito
            deposit(-amount);
            pay(balance); // en este punto es negativo
            if (balance < 0) { balance = 0; };
            return true;
        }

        return false;
    }

    String getProducts(){
        String result = "Ud tiene los siguiete productos:\n";
        result = result + "Cuenta coriente con Saldo Depositos:"+balance+"\n";
        result = result + "Su Saldo Credito es:"+credit;
        return result;
    }

}
