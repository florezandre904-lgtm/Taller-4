/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller4;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author UIS
 */
public class Taller4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio1 ();
    }
    public static void ejercicio1 () {
        String nombres[] = new String[100];
        String cel[] = new String[100]; 
                
        int cantidad=0;
        while (true) {
            int menu = Integer.parseInt(JOptionPane.showInputDialog("menu:\n"
                + "1 Registrar estudiante.\n"
                + "2 Consultar estudiante.\n"
                + "3 Modificar nombre del estudiante.\n"
                + "4 Modificar Telefono del estudiante.\n"
                + "5 Eliminar estudiante.\n"
                + "6 Imprimir listado.\n "
                + "7 salir\n"));            
            switch (menu) {
                case 1:
                    String nombre= JOptionPane.showInputDialog("ingrese el nombre del estudiante ");
                    nombres[cantidad]= nombre;
                    String telefono = JOptionPane.showInputDialog("ingrese el telefono del estudiante ");
                    cel[cantidad]= telefono;
                    cantidad++;
                break;
                case 2:
                    String buscar =JOptionPane.showInputDialog("ingrese el nombre del estudiante que desea consultar "); 
                    boolean encontrado=false ;
                    for (int i = 0; i < cantidad; i++) {
                        if (nombres[i].equalsIgnoreCase(buscar)) {
                            JOptionPane.showMessageDialog(null, "estudiante encontrado \n nombre: " +nombres[i] + "\ntelefono:"+ cel[i]);   
                            encontrado=true;
                        }  
                    }
                    if (!encontrado)
                        JOptionPane.showMessageDialog(null, "estudiante no  encontrado");  
                    break;
                    
                case 3: 
                    String busc= JOptionPane.showInputDialog("ingrese el nombre del estudiante que desea modificar ");
                    boolean encontrarnombre = false ;
                    for (int i = 0; i < cantidad; i++) {
                        if (nombres[i].equalsIgnoreCase(busc)) {
                            String nvnom = JOptionPane.showInputDialog("Ingrese el nuevo nombre ");
                            nombres[i] = nvnom;
                            JOptionPane.showMessageDialog(null, "el nombre ha sido modificado");
                            encontrarnombre = true;
                            break;
                        }
                    }
                        if (!encontrarnombre) {
                            JOptionPane.showMessageDialog(null,"el nombre no ha sido modificado");
                        }
                    break;
                case 4:
                    String telbus= JOptionPane.showInputDialog("ingrese el numero de telefono que desea modificar ");
                    boolean encontrarTel = false;
                    for (int i = 0; i < cantidad; i++) {
                        if (nombres[i].equalsIgnoreCase(telbus)) {
                            String nuevotel = JOptionPane.showInputDialog("Ingrese el nuevo numero de telefono ") ;
                            cel[i] = nuevotel ;
                            JOptionPane.showMessageDialog(null, "se ha cambiado el numero de telefono");
                            encontrarTel = true ;
                            break;
                        }
                    }
                        if (!encontrarTel) {
                            JOptionPane.showMessageDialog(null, "el numero de telefono no se ha cambiado ");
                        }
                    break;
                case 5:
                    String busel= JOptionPane.showInputDialog("ingrese el nombre del estudiante que desea eliminar ");
                    boolean eliminar = false;
                    for (int i = 0; i < cantidad; i++) {
                        if (nombres[i].equalsIgnoreCase(busel)) {
                            for (int j = i; j < cantidad; j++) {
                                nombres[j] = nombres[j+1];
                                cel[j] = cel[j+1] ;
                            }
                            cantidad -- ;
                            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente ");
                            eliminar = true ;
                            break;
                        }
                    }
                    if (!eliminar) {
                        JOptionPane.showMessageDialog(null, "no se ha podidio eliminar ");
                    }
                    break;
                case 6:
                    if (cantidad == 0) {
                        JOptionPane.showMessageDialog(null, "no hay estudiantes ");
                    } else {
                        String lista = "Listado de estudiantes:\n ";
                        for (int i = 0; i < cantidad; i++) {
                            lista += ("Nombre: " + nombres[i] + "  Telefono: " + cel[i] + "\n") ;
                        }
                        JOptionPane.showMessageDialog(null,lista) ;
                }
                    break;
                case 7:
                    System.exit(0);
                    break;
                
            }
        }
    }
     public static void ejercicio2() {
         
        String cedulas[] = new String[100];
        int compradas[] = new int[100];
        int cantidadpersonas = 0;
        int totalboletas = 100;
        while (true) {
            if (totalboletas == 0) {
                JOptionPane.showMessageDialog(null, "las boletas estan agotadas");
                System.exit(0);
            }
            String cc = JOptionPane.showInputDialog("Ingrese el número de la cédula:");
            boolean encontrada = false;
            for (int i = 0; i < cantidadpersonas; i++) {
                if (cedulas[i].equals(cc)) {
                    encontrada = true;
                    if (compradas[i] == 4) {
                        JOptionPane.showMessageDialog(null,"Has alcanzado el límite de 4 boletas.\n Venta rechazada.");
                    } else {
                        int dispperson = 4 - compradas[i];
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Solo puede comprar " + dispperson + " boletas.\n¿Cuántas boletas desea comprar?"));
                        if (cantidad <= dispperson&& cantidad <= totalboletas) {
                            compradas[i] += cantidad;
                            totalboletas -= cantidad;
                            JOptionPane.showMessageDialog(null,"has echo un compra exitosa.\n"
                                    + "Total vendidas: " + (100 - totalboletas)
                                    + "\nDisponibles: " + totalboletas);
                        } else {
                            JOptionPane.showMessageDialog(null,"Cantidad inválida o supera el límite.");
                        }
                    break;
                }
            }
            if (!encontrada) {
                int cantidad = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "No está registrado.\nPuede hacer una compra de hasta 4 boletas.\n¿Cuántas desea comprar?"));
                if (cantidad <= 4 && cantidad <= totalboletas) {
                    cedulas[cantidadpersonas] = cedula;
                    compradas[cantidadpersonas] = cantidad;
                    cantidadpersonas++;
                    totalboletas -= cantidad;
                    JOptionPane.showMessageDialog(null, "su compra ha sido exitosa.\n"
                            + "Total vendidas: " + (100 - totalboletas)
                            + "\nDisponibles: " + totalboletas);
                } else {
                    JOptionPane.showMessageDialog(null,"la cantidad es inválida o supera el límite.");
                }
            }
        }
    }
}
}
