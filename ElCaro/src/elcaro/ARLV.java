package elcaro;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ARLV {

    String Direccion;
    char manejo;
    ArrayList<String> borrados = new ArrayList();

    public ARLV(String Direccion, char manejo) {
        this.Direccion = Direccion;
        this.manejo = manejo;
    }

    public ArrayList<String> getBorrados() {
        return borrados;
    }

    public void setBorrados(ArrayList<String> borrados) {
        this.borrados = borrados;
    }

    public ARLV() {
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public char getManejo() {
        return manejo;
    }

    public void setManejo(char manejo) {
        this.manejo = manejo;
    }

    public int GetTamañoCampo(int indice) {
        int LongitudCampo = 0;
        if (manejo == 'D') {//Delimitador&
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorCampo = 0;

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    RAF.seek(i);
                    if (ContadorCampo == indice) {
                        char Revisar = (char) RAF.readByte();
                        if (Revisar != '&') {
                            LongitudCampo++;
                        } else {
                            ContadorCampo++;
                        }
                    } else {
                        char Revisar = (char) RAF.readByte();
                        if (Revisar == '&') {
                            ContadorCampo++;
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'K') {//KeyValue
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorCampo = -1;

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    RAF.seek(i);
                    if (ContadorCampo == indice) {
                        char Revisar = (char) RAF.readByte();
                        if (Revisar != '=') {
                            LongitudCampo++;
                        } else {
                            ContadorCampo++;
                        }
                    } else {
                        char Revisar = (char) RAF.readByte();
                        if (Revisar == '=') {
                            ContadorCampo++;
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'I') {//Indicador
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorCampo = 0;
            String Temp = "";

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    if (ContadorCampo == indice) {
                        for (int j = 0; j < 3; j++) {
                            RAF.seek(i);
                            char ConcatNumber = (char) RAF.readByte();
                            Temp += ConcatNumber;
                            i++;
                        }
                        LongitudCampo = Integer.parseInt(Temp);
                        Temp = "";
                        ContadorCampo++;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            RAF.seek(i);
                            char ConcatNumber = (char) RAF.readByte();
                            Temp += ConcatNumber;
                            i++;
                        }
                        i = i + Integer.parseInt(Temp);
                        ContadorCampo++;
                        Temp = "";
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return LongitudCampo;
    }

    public int GetNumCampo() {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        int NumeroCampos = 0;

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            RAF.seek(0);
            char Temp = (char) RAF.readByte();
            String Temp2 = "";
            Temp2 += Temp;

            NumeroCampos = Integer.parseInt(Temp2);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return NumeroCampos;
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
                if (Revisar == ':') {
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

    public String GetNombreColumna(int indice) {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        int PosicionInicial = 0;
        int NumeroCampo = 0;
        int ContadorDelimitador = 0;
        String NombreColumna = "";

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char) RAF.readByte();
                if (Revisar == ':') {
                    ContadorDelimitador++;
                }

                if (ContadorDelimitador == 2) {
                    PosicionInicial = i + 1;
                }
            }

            ContadorDelimitador = 0;
            System.out.println("Aqui empiezo: " + PosicionInicial);
            for (int i = PosicionInicial; i < RAF.length(); i++) {
                RAF.seek(i);
                char CharCampo = (char) RAF.readByte();
                if (CharCampo != ':') {
                    if (ContadorDelimitador == indice) {
                        NombreColumna += CharCampo;
                    }
                } else {
                    ContadorDelimitador++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return NombreColumna;
    }

    public ArrayList<String> GetNombresCampos(int Registro) {
        ArrayList<String> Nombres = new ArrayList();
        String DelimitadorRegistro = "'";
        if (manejo == 'D') {//Delimitador&
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorCampo = 0;
            int ContadorRegistro = 0;
            String Campo = "";

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    RAF.seek(i);
                    if (ContadorRegistro == Registro) {
                        char CharRevisar = (char) RAF.readByte();
                        if (CharRevisar != '&') {
                            Campo += CharRevisar;
                        } else {
                            Nombres.add(Campo);
                            Campo = "";
                        }
                    } else {
                        char CharRevisar = (char) RAF.readByte();
                        if (CharRevisar == DelimitadorRegistro.charAt(0)) {
                            ContadorRegistro++;
                            i++;
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'K') {//KeyValue
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorRegistro = 0;
            String Campo = "";
            int ContadorDelimitador = 0;

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    RAF.seek(i);
                    if (ContadorRegistro == Registro) {
                        char CharRevisar = (char) RAF.readByte();
                        char Revisar = (char) RAF.readByte();
                        if (Revisar != '=') {
                            //LongitudCampo++;
                        } else {
                            //ContadorCampo++;
                        }

                    } else {
                        char CharRevisar = (char) RAF.readByte();
                        if (CharRevisar == DelimitadorRegistro.charAt(0)) {
                            ContadorRegistro++;
                            i++;
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'I') {//Indicador
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            int PosicionInicial = GetPosInicial();
            int ContadorCampo = 0;
            int ContadorRegistro = 0;
            String Temp = "";

            try {
                RAF = new RandomAccessFile(Archivo, "rw");

                for (int i = PosicionInicial; i < RAF.length(); i++) {
                    if (ContadorCampo == Registro) {
                        for (int j = 0; j < 3; j++) {
                            RAF.seek(i);
                            char ConcatNumber = (char) RAF.readByte();
                            Temp += ConcatNumber;
                            i++;
                        }
                        //LongitudCampo = Integer.parseInt(Temp);
                    } else {
                        for (int j = 0; j < 3; j++) {
                            RAF.seek(i);
                            char ConcatNumber = (char) RAF.readByte();
                            Temp += ConcatNumber;
                            i++;
                        }
                        i = i + Integer.parseInt(Temp);
                        ContadorCampo++;
                        Temp = "";
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Nombres;
    }

    public void CargarManejo() {
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        int ContadorDelimitador = 0;
        char Manejo = 'D';

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char) RAF.readByte();

                if (ContadorDelimitador == 1) {
                    i++;
                    RAF.seek(i);
                    Manejo = (char) RAF.readByte();
                }

                if (Revisar == ':') {
                    ContadorDelimitador++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLV.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setManejo(Manejo);
    }

    public boolean IsVariable(File Archivo) {
        boolean IsVariable = true;

        Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;

        try {
            RAF = new RandomAccessFile(Archivo, "rw");

            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char) RAF.readByte();
                if (Revisar == ';') {
                    IsVariable = false;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ARLF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IsVariable;
    }

    public DefaultTableModel CargarArchivoVariable(String DireccionArchivo, String DireccionPila, DefaultTableModel Modelo) {

        return Modelo;
    }

    public void Agregar(String Registro, long Lenght) {
        if (manejo == 'D') {
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            try {
                RAF = new RandomAccessFile(Archivo, "rw");
                RAF.seek(Lenght);
                RAF.writeBytes(Registro + "&");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'K') {
            File Archivo = null;
            Archivo = new File(Direccion);
            RandomAccessFile RAF = null;
            try {
                RAF = new RandomAccessFile(Archivo, "rw");
                RAF.seek(Lenght);
                RAF.writeBytes(Registro);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ElCaro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (manejo == 'I') {

        }
    }
}
