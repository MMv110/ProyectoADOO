package Vista;


import Controlador.Conexion;
import Modelo.Pregunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Crud {
    public void createPregunta(Pregunta p){
        
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Insert into Preguntas values (?,?,?,?,?,?,?,?)");
            ps.setNull(1, 0);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getPregunta());
            ps.setInt(3, p.getRespuesta());
            ps.setString(4, p.getOpcion1());
            ps.setString(5, p.getOpcion2());
            ps.setString(6, p.getOpcion3());
            ps.setString(7, p.getOpcion4());
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList<Pregunta> getPreguntas(){
        ArrayList<Pregunta> preguntas = new ArrayList();
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Select * from Preguntas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pregunta pregunta = new Pregunta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                preguntas.add(pregunta);
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return preguntas;
    }
    public Pregunta ReadPregunta(int id){
        Pregunta pregunta = null;
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Select * from Preguntas where id=?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pregunta = new Pregunta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return pregunta;
    }
    public boolean UpdatePregunta(Pregunta p){
        
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Update preguntas set nombre=?, pregunta=?, respuesta=?, opcion1=?, opcion2=?, opcion3=?, opcion4=? where id=?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getPregunta());
            ps.setInt(3, p.getRespuesta());
            ps.setString(4, p.getOpcion1());
            ps.setString(5, p.getOpcion2());
            ps.setString(6, p.getOpcion3());
            ps.setString(7, p.getOpcion4());
            ps.setInt(8, p.getId());
            
            if(ps.execute())
                return true;
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return false;
    }
    public boolean DeletePregunta(int id){
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Delete from preguntas where id=?");
            ps.setInt(1, id);
            
            if(ps.execute())
                return true;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        return false;
    }
}
