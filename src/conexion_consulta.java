
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class conexion_consulta {
    static Connection conexion=null;
    static Statement sentencia;
    public static void conectar(){
   try {
          Class.forName("com.mysql.jdbc.Driver");
          conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservacion","root","");
          //System.out.println("Hasta aquí todo bien");
        }
    catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
}
    public static ArrayList<String> llenar_combo(){
        String fecha1=form_reserva.fecha;
        System.out.println(fecha1);
        String hora1=form_reserva.hora;
        System.out.println(hora1);
        ArrayList<String> labs= new ArrayList<String>();
        ArrayList<String> res= new ArrayList<String>();
        String q= "SELECT * FROM laboratorios";
        //String p= "SELECT * FROM reservas";
        String p= "SELECT * FROM reservas WHERE fecha='"+fecha1+"' AND hora='"+hora1+"'";
        try{
            PreparedStatement pst=conexion.prepareStatement(q);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                labs.add(rs.getString(2));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            PreparedStatement pst1=conexion.prepareStatement(p);
            ResultSet rs1=pst1.executeQuery();
            while(rs1.next()){
                res.add(rs1.getString(2));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        for(int i=0;i<labs.size();i++){
            for(int j=0;j<res.size();j++){
                if(labs.get(i).equals(res.get(j))){
                    labs.remove(i);
                }
            }
        }
        return labs;
    }
    
    public static void guardar(campos_altas x){
        String ultimo=null;
        try{
            String sql= "INSERT INTO reservas (laboratorio,fecha,hora,id_user) VALUES ('"+x.getLaboratorio()+"','"+x.getFecha()+"','"+x.getHora()+"','"+x.getId_usuario()+"')";
            Statement res= conexion.createStatement();
            
            res.executeUpdate(sql);
            
            PreparedStatement stmtr = conexion.prepareStatement("SELECT * FROM reservas ORDER BY id_reserva DESC");
            ResultSet rsr = stmtr.executeQuery();
            if(rsr.next()){
                ultimo = rsr.getString(1);
            }
            JOptionPane.showMessageDialog(null, "Tu número de reservación es: "+ultimo+"\n Es muy importante que anotes este número\n si deseas cancelar la reservación");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
