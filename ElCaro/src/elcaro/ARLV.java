
package elcaro;

import java.util.ArrayList;


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
    
    
    public int GetTamañoCampo(int indice){
        return 0;
    }
    
    public int GetNumCampo(){
        return 0;
    }
    
    public int GetPosInicial(){
        return 0;
    }
    
    public String GetNombreCampo(int i){
        return "";
    }
}
