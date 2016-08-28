package elcaro;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
                        char Revisar = (char)RAF.readByte();
                        if (Revisar != '&') {
                            LongitudCampo++;
                        }else{
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

        } else if (manejo == 'I') {//Indicador

        }

        return LongitudCampo;
    }

    public int GetNumCampo() {
        return 0;
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

    public String GetNombreCampo(int indice) {
        return "";
    }
    
    public ArrayList<String> GetNombresCampos(){
        ArrayList<String> Nombres = new ArrayList();
        
        return Nombres;
    }
    
    public void CargarManejo(){
        File Archivo = null;
        Archivo = new File(Direccion);
        RandomAccessFile RAF = null;
        int ContadorDelimitador = 0;
        char Manejo = 'D';
        
        try {
            RAF = new RandomAccessFile(Archivo, "rw");
            
            for (int i = 0; i < RAF.length(); i++) {
                RAF.seek(i);
                char Revisar = (char)RAF.readByte();
                
                if (ContadorDelimitador == 1) {
                    i++;
                    RAF.seek(i);
                    Manejo = (char)RAF.readByte();
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
    }
    
    public void Agregar(String Registro, int Lenght){
        
    }
}
