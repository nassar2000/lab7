package org.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlayerProgresie implements Runnable {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    BordProg bPlayer; /* am creat o tabla comuna pt jucatori din care vom trage si sterge tokenuri */
    String name; /*numele jucatorului*/
    TokenProgresie copy; /*un object token pt a copia in el tokenurile curente extrase*/
    int playerPoints; /* punctajul jucatorului*/
    static final List<Integer> mana1 = new ArrayList<Integer>(); /*aici retin lista de tokenuri din mana juc 1*/
    static final List<Integer> mana2 = new ArrayList<Integer>(); /*aici retin lista de tokenuri din mana juc 2*/
    static int nrDeTokenuri1; /*aici vom retine nr de tokenuri din mana juc 1*/
    static int nrDeTokenuri2; /*aici vom retine nr de tokenuri din mana juc 2*/
    int id; /*avem aici un id pentru a face diferenta intre jucator 1 si jucator 2 in timpul jocului*/

    /*construcotrul pt clasa PlayerProgresie*/
    public PlayerProgresie(String name, BordProg bPlayer, int id) {
        this.name = name;
        this.bPlayer = bPlayer;
        this.id = id;
    }

    @Override
    public synchronized void run() {
        System.out.println("Selecteaza cartea:");
        String commandTwo = null;
        try {
            commandTwo = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = Integer.parseInt(commandTwo);

        if (this.id == 1) {
            copy = bPlayer.listToken.get(index);
            this.mana1.add(copy.getTokenProgresie());
            bPlayer.listToken.remove(index);
            nrDeTokenuri1++;
            System.out.println(this.name + " ai " + this.nrDeTokenuri1);
        } else {
            copy = bPlayer.listToken.get(index);
            this.mana2.add(copy.getTokenProgresie());
            bPlayer.listToken.remove(index);
            nrDeTokenuri2++;
            System.out.println(this.name + " ai " + this.nrDeTokenuri2);
        }

        System.out.println(this.name + " ai luat cartonasul cu " + copy.random);
        if (this.id == 1)
            System.out.println(this.name + " ai urmatoarel carti in mana:" + this.mana1.toString());
        else
            System.out.println(this.name + " ai urmatoarele carti in mana:" + this.mana2.toString());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name +
                +'\'' +
                '}';
    }
}

