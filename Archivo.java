/*
 * Crea una clase archivo que permita recibir un archivo
 * CSV mediante su nombre por teclado y abrirlo, dicho 
 * archivo tiene el listado de un número de 2 o más 
 * participantes ademas cada fila del archivo contiene 
 * el dato de un participante, se debe hacer un 
 * recorrido del archivo y corregir casos donde 2 
 * participantes tengan el mismo nombre y apellido y 
 * mismo telefono y mismo correo (seria valido que se 
 * repitan 3 pero no los 4 al mismo tiempo), para esto 
 * se puede recorrer cada linea del archivo e ir comparando 
 * con las demas lineas del archivo viendo que no se repitan 
 * mas de 2 palabras, el objeto que la clase cree ya 
 * debe tener este filtro           
 */
package Prueba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
  private String nombreArchivo;
  private String[] lineas;

  public Archivo(String nombreArchivo) throws IOException {
    this.nombreArchivo = nombreArchivo;
    this.lineas = leerArchivo();
    this.filtrar();
  }

  private String[] leerArchivo() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
    String linea;
    StringBuilder sb = new StringBuilder();
    while ((linea = br.readLine()) != null) {
      sb.append(linea).append("\n");
    }
    br.close();
    return sb.toString().split("\n");
  }

  private void filtrar() {
    for (int i = 0; i < lineas.length; i++) {
      String[] campos1 = lineas[i].split(",");
      for (int j = i + 1; j < lineas.length; j++) {
        String[] campos2 = lineas[j].split(",");
        if (campos1[0].equals(campos2[0]) && campos1[1].equals(campos2[1])
            && campos1[2].equals(campos2[2]) && campos1[3].equals(campos2[3])) {
          campos2[1] = campos2[1] + " (Repetido)";
          lineas[j] = String.join(",", campos2);
        }
      }
    }
  }

  public void mostrarArchivo() {
    for (String linea : lineas) {
      System.out.println(linea);
    }
  }
  
    public static void main(String[] args) {
        try {
            Archivo archivo = new Archivo("Participantes.csv");
            archivo.mostrarArchivo();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

  
}
