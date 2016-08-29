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
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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
    
    public int GetPosInicial() {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        int PosicionInicial = 0;

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char) RAF.readByte();
                if (Revisar == ';') {
                    PosicionInicial = i + 1;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PosicionInicial;
    }

    public Stack<Integer> getBorrados() {
        return Borrados;
    }

    public void setBorrados(Stack<Integer> Borrados) {
        this.Borrados = Borrados;
    }

    public boolean IsFija(File Archivo) {
        boolean IsFija = false;

        Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char) RAF.readByte();
                if (Revisar == ';') {
                    IsFija = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IsFija;
    }

    public DefaultTableModel CargarArchivoFijo(String DireccionArchivo, String DireccionPila, DefaultTableModel Modelo) {
        String Indice_Borrado = "";
        int ContadorDelimitador = 0;
        int RowsAgregadas = 0;
        int ContadorRow = 0;
        Object[] Row = new Object[Integer.parseInt(TamañoCampo())];
        int LongitudRegistro = Integer.parseInt(NumeroCampos()) * Integer.parseInt(TamañoCampo());
        String Campo = "";
        ArrayList<Integer> BorradosTemp = new ArrayList();
        File Archivo = null;
        Archivo = new File(DireccionPila);
        File Archivo_Campos = null;
        Archivo_Campos = new File(DireccionArchivo);
        RandomAccessFile RAF = null;
        RandomAccessFile RAF2 = null;

        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            for (int i = 0; i < RAF.length(); i++) {//cargar borrados
                RAF.seek(i);
                char Delimitador = (char) RAF.readByte();
                if (Delimitador != ';') {
                    Indice_Borrado += Delimitador;
                } else {
                    int Indice = Integer.parseInt(Indice_Borrado);
                    this.Borrados.push(Indice);
                    BorradosTemp.add(Indice);
                    Indice_Borrado = "";
                    ContadorDelimitador++;
                }
            }//termina cargar borrados

            ArrayList<String> Nombres;
            Nombres = NombresCampos();

            for (int i = 0; i < Nombres.size(); i++) {
                Modelo.addColumn(Nombres.get(i));
            }
            ContadorDelimitador = 0;

            RAF2 = new RandomAccessFile(Archivo_Campos, "rw");
            int TamañoAlcanzado = 0;
            for (int i = 0; i < RAF2.length(); i++) {//cargar datos de campos
                RAF2.seek(i);
                char Delimitador = (char) RAF2.readByte();
                if (Delimitador != ';') {
                    if (ContadorDelimitador == (2 + Integer.parseInt(NumeroCampos()))) {
                        RAF2.seek(i);
                        int TamañoCampo = Integer.parseInt(TamañoCampo());
                        if (TamañoAlcanzado < TamañoCampo) {
                            RAF2.seek(i);
                            char CharacterCampo = (char) RAF2.readByte();
                            Campo += CharacterCampo;
                            TamañoAlcanzado++;
                        } else {
                            if (ContadorRow >= Integer.parseInt(NumeroCampos())) {
                                ContadorRow = 0;
                            }
                            Row[ContadorRow] = Campo;
                            i--;
                            if (ContadorRow + 1 == Integer.parseInt(NumeroCampos())) {
                                Modelo.addRow(Row);
                            }
                            ContadorRow++;
                            TamañoAlcanzado = 0;
                            Campo = "";
                        }
                    }
                } else {
                    ContadorDelimitador++;
                }
            }//termina cargar datos de campos

            int PosicionFinal = (int) (RAF2.length() - (Integer.parseInt(NumeroCampos()) * Integer.parseInt(TamañoCampo())));
            String UltimoCampo = "";
            TamañoAlcanzado = 0;
            int NumeroCampos = Integer.parseInt(NumeroCampos());
            int TamañoCampo = Integer.parseInt(TamañoCampo());
            for (int i = PosicionFinal; i < RAF2.length(); i++) {//cargar ultimo dato
                RAF2.seek(i);
                if (TamañoAlcanzado < TamañoCampo) {
                    char CharacterCampo = (char) RAF2.readByte();
                    UltimoCampo += CharacterCampo;
                    TamañoAlcanzado++;
                }else{
                    System.out.println("Ultimo Campo: " + UltimoCampo);
                    Row[NumeroCampos] = UltimoCampo;
                    Modelo.addRow(Row);
                    NumeroCampos++;
                    TamañoAlcanzado = 0;
                }
            }//terminar cargar ultimo dato
            
            for (int i = 0; i < BorradosTemp.size(); i++) {
                for (int j = 0; j < Integer.parseInt(NumeroCampos()); j++) {
                   Modelo.setValueAt(" ", BorradosTemp.get(i), j); 
                }      
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Modelo;
    }

    public ArrayList<String> NombresCampos() {
        ArrayList<String> Nombres = new ArrayList();
        String Campo = "";
        int TamañoCampo = Integer.parseInt(TamañoCampo());
        int ContadorDelimitador = 0;
        RandomAccessFile RAF = null;
        File Archivo = null;
        Archivo = new File(Direccion);

        try {
            RAF = new RandomAccessFile(Archivo, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i = 0; i < RAF.length(); i++) {//cargar borrados
                RAF.seek(i);
                char Delimitador = (char) RAF.readByte();
                if (Delimitador != ';') {
                    if (ContadorDelimitador >= 2 && ContadorDelimitador < Integer.parseInt(NumeroCampos()) + 2) {
                        RAF.seek(i);
                        char CharacterNombre = (char) RAF.readByte();
                        Campo += CharacterNombre;
                    }
                } else {
                    if (!Campo.isEmpty()) {
                        Nombres.add(Campo);
                        Campo = "";
                    }
                    ContadorDelimitador++;
                }
            }//termina cargar borrados
        } catch (IOException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Nombres;
    }
}
