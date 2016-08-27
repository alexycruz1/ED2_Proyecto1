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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexy Cruz
 */
public class ARLF {

    String Direccion;

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

    public void Agregar(String campo ,long posicion) {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            RAF.seek(posicion);
            RAF.writeBytes(campo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
