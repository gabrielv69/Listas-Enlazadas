            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructura;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Listaenlazada {

    Nodo inicio;

    public void lector(String original) {
        inicio = null;
        addFinal(original);

    }

    public String concatenar() {
        String concatenar = "";
        Nodo p = inicio;
        while (p != null) {
            concatenar += p.informacion + " ";
            p = p.enlace;
        }
        return concatenar;
    }

    public Listaenlazada() {
        super();
        this.inicio = null;
    }

    public boolean estávacía() {
        return (this.inicio == null);
    }

    public void addInicio(String inf) {
        StringTokenizer tk = new StringTokenizer(inf, " ");
        while (tk.hasMoreTokens()) {
            if (estávacía()) {
                this.inicio = new Nodo(tk.nextToken());
            } else {
                this.inicio = new Nodo(tk.nextToken(), this.inicio);
            }
        }

    }

    public void addFinal(String inf) {
        StringTokenizer tk = new StringTokenizer(inf, " ");
        while (tk.hasMoreTokens()) {
            Nodo p, q;
            p = new Nodo(tk.nextToken());
            q = inicio;
            if (estávacía()) {
                inicio = p;
            } else {
                while (q.enlace != null) {
                    q = q.enlace;
                }
                q.enlace = p;
            }
        }

    }

    public int length() {
        if (inicio == null) {
            return 0;
        }
        int count = 1;
        Nodo p = inicio;
        do {
            count++;
            p = p.enlace;
        } while (p.enlace != null);
        return count;
    }

    public void addMedio(String inf) {
        StringTokenizer tk = new StringTokenizer(inf, " ");
        while (tk.hasMoreTokens()) {
            int medio = length() / 2;
            int cont = 1;
            Nodo p, q, r;
            p = new Nodo(tk.nextToken());
            q = inicio;
            if (estávacía()) {
                inicio = p;
            } else {
                while (cont < medio) {
                    cont++;
                    q = q.enlace;

                }
                r = q.enlace;
                q.enlace = p;
                p.enlace = r;
            }
        }

    }

    public void borrarNodo(String bor) {
        if (estávacía()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            Nodo p = inicio;
            Nodo q = inicio.enlace;
            if (inicio.informacion.equalsIgnoreCase(bor)) {
                inicio = inicio.enlace;
                return;
            }
            while (q.enlace != null) {
                if (q.informacion.equalsIgnoreCase(bor)) {
                    p.enlace = q.enlace;
                    return;
                }
                p = p.enlace;
                q = q.enlace;
            }
            if (q.informacion.equalsIgnoreCase(bor)) {
                p.enlace = null;
            }
        }
    }

    @Override
    public String toString() {
        String salida = "";
        Nodo p = inicio;
        while (p != null) {
            salida += p.informacion + "\n";
            p = p.enlace;
        }
        return salida;
    }

}
