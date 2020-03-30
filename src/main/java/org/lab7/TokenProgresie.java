package org.lab7;

        import java.util.Objects;
        import java.util.Random;

/* contine un token cu un numar random*/
public class TokenProgresie {
    int value_m;
    int value_rand;
    Random rand = new Random();
    int random;

    /*creaza un numar random pentru fiecare token*/
    public int setRandom() {

        random = rand.nextInt(value_m);    /*aici alegem un nr random pentru obiectul nostru*/
        return random;

    }

    /*returneaza un numar random dar care a primit o valoare maxima ca parametru*/
    public int getTokenProgresie() {
        return value_rand;
    }

    @Override
    public String toString() {
        return "Token{" +
                " rand=" + random +
                '}';
    }

    public TokenProgresie(int m) {
        value_m = m;
        value_rand = setRandom();     /*aici avem constructorul pentru obiectul Token*/
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenProgresie)) return false;
        TokenProgresie that = (TokenProgresie) o;
        return value_rand == that.value_rand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value_rand);
    }
}
