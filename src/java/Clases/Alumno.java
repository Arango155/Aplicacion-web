package Clases;

public class Alumno {
    
AlumnoModell[] tablaALumno;
    int indiceArray;
    
    public Alumno(){
        tablaALumno = new AlumnoModell[100];
        this.indiceArray = 0;
    }
    
public void guardarAlumno(AlumnoModell client){
        this.tablaALumno[this.indiceArray] = client;
        this.indiceArray = this.indiceArray + 1;
    }
    
    public AlumnoModell[] getAlumnos(){
        return tablaALumno;
    }

    public void remover(String position){
          int pos = Integer.parseInt(position);
          this.tablaALumno[pos] = null;
          for(int i = pos; i < indiceArray - 1; i++) {
                this.tablaALumno[i] = this.tablaALumno[i + 1];
          }
          this.tablaALumno[indiceArray - 1] = null;
          indiceArray --;
    }

}
