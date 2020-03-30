package org.lab7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String args[]) throws IOException {


        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        /*aici sunt datele jocului introduse de la tastatura*/
        System.out.println("selecteaza nume 1:");
        String nume1 = br.readLine();
        System.out.println("selecteaza nume 2:");
        String nume2 = br.readLine();
        System.out.println("selecteaza un numar de carti:");
        String s1 = br.readLine();
        int cartonase = Integer.parseInt(s1);
        System.out.println("selecteaza valoarea maxima a cartilor:");
        String s2 = br.readLine();
        int valMax = Integer.parseInt(s2);
        System.out.println("selecteaza cate carti vrei sa aiba jucatorul ca sa se termine jocul(val progresiei):");
        String s3 = br.readLine();
        int valProg = Integer.parseInt(s3);


        BordProg board = new BordProg(cartonase, valMax); /*am creat tabla de joc cu numarul de tokenuri si valoare lor maxim*/


        board.setListToken(); /*am creat lista cu tokenuri*/
        PlayerProgresie jucatorul1 = new PlayerProgresie(nume1, board, 1); /*am creat playerul 1*/
        PlayerProgresie jucatorul2 = new PlayerProgresie(nume2, board, 2); /*am creat playerul 2*/

        GameInputProgresie game= new GameInputProgresie(jucatorul1,jucatorul2,valProg,board);  /*cream jocul*/

    }
}