package Modelo;

import Vista.Crud;

public class Pregunta {
    private int id;
    private String nombre;
    private String pregunta;
    private int respuesta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;

    public Pregunta(int id, String nombre, String pregunta, int respuesta, String opcion1, String opcion2, String opcion3, String opcion4) {
        this.id = id;
        this.nombre = nombre;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
    }

    public Pregunta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public void crearPregunta(){
        Crud crud = new Crud();
        crud.createPregunta(this);
    }
    
    public boolean updatePregunta(){
        Crud crud = new Crud();
        return crud.UpdatePregunta(this);
    }
    
    public boolean deletePregunta(){
        Crud crud = new Crud();
        return crud.DeletePregunta(this.id);
    }
}
