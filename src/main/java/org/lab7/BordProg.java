package org.lab7;

import java.util.*;

public class BordProg {
    int nrTokens;  /* nr de tokeni cerut*/
    int valueMaxToken;  /* val max a tokene*/
    TokenProgresie tokenEx;  /*am dec obiectul folosit la crearea listei de val random*/
    Set<TokenProgresie> set = new HashSet<TokenProgresie>();  /* set pt a avea val unice cum cere problema si nu duplicate*/
    List<TokenProgresie> listToken = new ArrayList<TokenProgresie>();  /* am declarat o lista in care vom pune tokenurile unice*/

    public void setListToken() {    /* lista de tokenuri  */
        int a = 0;
        while (a < nrTokens) {   /* comp size-ul lui set, sa vedem daca avem numarul cerut de tokenuri */
            {
                tokenEx = new TokenProgresie(valueMaxToken);   /* cream un obiect de tip token cu o val random */
                set.add(tokenEx);  /* adaugam in set obiectul de tip token */
                a = set.size();  /* copiem in a size-ul lui set pentru a folosi aceasta valoare la while */
            }

        }
        listToken.addAll(set);   /* salvam in lista de tokeni acel set deoarece acum putem avea o lista fara duplicate*/
    }

    public List<TokenProgresie> getListToken() {  /* returnam lista de tokeni */
        return listToken;
    }

    public BordProg(int n, int m) {    /* constructorul pt board */
        nrTokens = n;
        valueMaxToken = m;
    }

    @Override
    public String toString() {
        return "Board{" +
                "nrTokens=" + nrTokens +
                ", listToken=" + listToken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BordProg)) return false;
        BordProg that = (BordProg) o;
        return tokenEx.equals(that.tokenEx) &&
                set.equals(that.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenEx, set);
    }
}

