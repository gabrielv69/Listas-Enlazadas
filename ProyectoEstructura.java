package proyectoestructura;

import javax.swing.JOptionPane;

public class ProyectoEstructura {

    public static void main(String[] args) {
        Archivo archivo = new Archivo();
        Listaenlazada listaen = new Listaenlazada();
        String y = "Archivo.txt";
        String[] botones = {"Al inicio", "Al final", "Al medio"};
        String[] botones1 = {"Leer Archivo", "Imprimir Lista", "Anadir texto", "Eliminar palabra"};

        int opcion = 0, option = 0, opti = 0;
        do {
            opti = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Opciones", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones1, botones1[0]);
            switch (opti) {
                case 0:
                    Object obj1 = archivo.leer(y);
                    String text = (String) obj1;
                    System.out.println("Contenido archivo:");
                    System.out.println(text);
                    break;
                case 1:
                    Object obj = archivo.leer(y);
                    String artxt = (String) obj;
                    listaen.lector(artxt);
                    System.out.println("Lista inicial");
                    System.out.println(listaen.toString());
                    break;
                case 2:
                    do {
                        option = JOptionPane.showOptionDialog(null, "¿Dónde desea añadir?", "Opciones", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
                        switch (option) {
                            case 0:
                                listaen.addInicio(JOptionPane.showInputDialog("Escriba texto"));
                                archivo.escribir(listaen.concatenar(), y);
                                break;
                            case 1:
                                listaen.addFinal(JOptionPane.showInputDialog("Escriba texto"));
                                archivo.escribir(listaen.concatenar(), y);
                                break;
                            case 2:
                                listaen.addMedio(JOptionPane.showInputDialog("Escriba texto"));
                                archivo.escribir(listaen.concatenar(), y);
                                break;
                            default:
                                break;
                        }
                        opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más", "Ingreso de datos", JOptionPane.YES_NO_OPTION);
                    } while (opcion == JOptionPane.YES_OPTION);
                    break;

                case 3:
                    String borrar = JOptionPane.showInputDialog("Ingrese palabra desea borrar");
                    listaen.borrarNodo(borrar);
                    archivo.escribir(listaen.concatenar(), y);
                    System.out.println("Lista tras borrar\n" + listaen.toString());
                    break;
                default:
                    break;
            }
            opcion = JOptionPane.showConfirmDialog(null, "Desea hacer algo mas?", "Opciones", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_OPTION);
    }

}
