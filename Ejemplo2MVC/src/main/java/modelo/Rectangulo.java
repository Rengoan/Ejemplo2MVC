package modelo;

import java.io.Serializable;

public class Rectangulo implements Serializable{
    private int base;
    private int altura;
    
    //Contructor

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo() {
    }
    
    //Getter and Setter

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
