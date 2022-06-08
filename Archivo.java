/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Gab
 */
public class Archivo {

    private String ruta = "src" + File.separator;

    public void añadirmas(String nuevo) {
        String inicio=(String) leer("Archivo.txt");
        String suma= inicio+nuevo;
        escribir(suma, "Archivo.txt");

    }

    public void escribir(String entrada, String nombre) {

        try {
            FileOutputStream fos = new FileOutputStream(ruta + nombre);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(entrada);
            out.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public Object leer(String nombre) {
        Object object = null;
        try {
            FileInputStream fis = new FileInputStream(ruta + nombre);
            ObjectInputStream in = new ObjectInputStream(fis);
            object = in.readObject();
            in.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return object;
    }

}
