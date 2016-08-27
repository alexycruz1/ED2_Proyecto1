/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcaro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexy Cruz
 */
public class ARLF {

    String Direccion;
    Stack<Integer> Borrados = new Stack();

    public ARLF() {
    }

    public ARLF(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void Agregar(String campo, long posicion) {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            RAF.seek(posicion);
            String TamañoCampoTemp = this.TamañoCampo();
            int TamañoCampo = Integer.parseInt(TamañoCampoTemp);

            if (campo.length() <= TamañoCampo) {
                RAF.writeBytes(campo);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Modificar(String Campo, long Posicion) {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            RAF.seek(Posicion);
            RAF.writeBytes(Campo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String TamañoCampo() {
        String TamañoCampo = "";
        int ContadorDelimitador = 0;
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char TamañoCampoTemp = (char) RAF.readByte();
                if (TamañoCampoTemp != ';') {
                    if (ContadorDelimitador == 1) {
                        TamañoCampo += TamañoCampoTemp;
                        System.out.println(TamañoCampo);
                    }
                } else {
                    ContadorDelimitador++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TamañoCampo;
    }

    public String NumeroCampos() {
        String TamañoCampo = "";
        int ContadorDelimitador = 0;
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char TamañoCampoTemp = (char) RAF.readByte();
                if (TamañoCampoTemp != ';') {
                    if (ContadorDelimitador < 1) {
                        TamañoCampo += TamañoCampoTemp;
                        System.out.println(TamañoCampo);
                    }
                } else {
                    ContadorDelimitador++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TamañoCampo;
    }

    public Stack<Integer> getBorrados() {
        return Borrados;
    }

    public void setBorrados(Stack<Integer> Borrados) {
        this.Borrados = Borrados;
    }
}
