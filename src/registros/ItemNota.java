/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

public class ItemNota {
    public int id;
    public String categoria;
    public String nota;

    public String getNota() {
        return nota;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNota(String newNota) {
        this.nota = newNota;
    }

    public void setCategoria(String newCategoria) {
        this.categoria = newCategoria;
    }
    
    
}
