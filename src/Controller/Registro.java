/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.Chocolate;
import MySQL.Conexion;
import View.EliminarChocolate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Cristian
 */
public class Registro {
    
    public boolean Grabar(Chocolate chocolate) {
        try {
            Connection conexion =Conexion.getConexion();
            String query = "INSERT INTO chocolates(Codigo,Nombre,Descripcion,Precio_Venta,Cantidad,Tipo,Sabor,Marca,Azucar) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            ingresar.setInt(1, chocolate.getCodigo());
            ingresar.setString(2, chocolate.getNombre());
            ingresar.setString(3, chocolate.getDescripcion());
            ingresar.setInt(4, chocolate.getPrecioVenta());
            ingresar.setInt(5, chocolate.getCantidad());
            ingresar.setString(6, chocolate.getTipo());
            ingresar.setString(7, chocolate.getSabor());
            ingresar.setString(8,chocolate.getMarca());
            if(chocolate.isAzucar()){ingresar.setString(9,"Si");}
            else{ingresar.setString(9, "No");}
            
            ingresar.execute();
            ingresar.close();
            conexion.close(); 
            return true;
            
                       
        }catch(SQLException s){
            System.out.println("Error SQL al agregar Chocolate"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al agregar Chocolate"+e.getMessage());
            return false;
        }

    }
    
    public boolean Eliminar(int Codigo){
        try{
            Connection conexion=Conexion.getConexion();
            String query="DELETE FROM chocolates WHERE Codigo=?";
            PreparedStatement eliminar=conexion.prepareStatement(query);
            eliminar.setInt(1,Codigo);
            if (eliminar.executeUpdate() > 0) {
                return true;
            }
             conexion.close();
        }
        catch(SQLException s){
            System.out.println("Error SQL al eliminar Chocolate"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Chocolate"+e.getMessage());
        }
        return false;
    }
    
    public Chocolate Buscar(int Codigo){
        Chocolate chocolate=new Chocolate();
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT * FROM chocolates where Codigo=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, Codigo);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                chocolate.setCodigo(rs.getInt("Codigo"));
                chocolate.setNombre(rs.getString("Nombre"));
                chocolate.setDescripcion(rs.getString("Descripcion"));
                chocolate.setPrecioVenta(rs.getInt("Precio_Venta"));
                chocolate.setCantidad(rs.getInt("Cantidad"));
                chocolate.setTipo(rs.getString("Tipo"));
                chocolate.setSabor(rs.getString("Sabor"));
                chocolate.setMarca(rs.getString("Marca"));
                if(rs.getString("Azucar").equals("Si")){chocolate.setAzucar(true);}
                else{chocolate.setAzucar(false);}
                }
            conexion.close();
        }catch(SQLException s){
            System.out.println("Error SQL al eliminar Chocolate"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Chocolate"+e.getMessage());
        }
        return chocolate;
    }
    
    public boolean Modificar(Chocolate chocolate){
        try{
            Connection conexion=Conexion.getConexion();
            String query="UPDATE chocolates SET Nombre=?,Descripcion=?,Precio_Venta=?,Cantidad=?,Tipo=?,Sabor=?,Marca=?,Azucar=?"
                    + "WHERE Codigo=?";
            PreparedStatement modificar=conexion.prepareStatement(query);
            modificar.setString(1, chocolate.getNombre());
            modificar.setString(2, chocolate.getDescripcion());
            modificar.setInt(3,chocolate.getPrecioVenta());
            modificar.setInt(4, chocolate.getCantidad());
            modificar.setString(5, chocolate.getTipo());
            modificar.setString(6, chocolate.getSabor());
            modificar.setString(7, chocolate.getMarca());
            if(chocolate.isAzucar()){modificar.setString(8, "Si");}
            else{modificar.setString(8, "No");}
            modificar.setInt(9, chocolate.getCodigo());
            if(modificar.executeUpdate()>0){return true;}
            conexion.close();
        }
        catch(SQLException s){
            System.out.println("Error SQL al eliminar Instrumento"+s.getMessage());
            
        }catch(Exception e){
            System.out.println("Error al eliminar Instrumento"+e.getMessage());
            
        }
        return false;
       
        
        
    }
    
    public JTable Mostrar(JTable table){
            Connection conexion=Conexion.getConexion();

        DefaultTableModel chocolates=new DefaultTableModel();
        
        chocolates.addColumn("Código");
        chocolates.addColumn("Nombre");
        chocolates.addColumn("Descripción");
        chocolates.addColumn("Precio Venta $/250g");
        chocolates.addColumn("Cantidad g");
        chocolates.addColumn("Tipo");
        chocolates.addColumn("Sabor");
        chocolates.addColumn("Marca");
        chocolates.addColumn("Azúcar");
        table.setModel(chocolates);
        String query="SELECT * FROM chocolates";
        Object[]datos=new Object[9];
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                datos[0]=rs.getObject("Codigo");
                datos[1]=rs.getObject("Nombre");
                datos[2]=rs.getObject("Descripcion");
                datos[3]=rs.getObject("Precio_Venta");
                datos[4]=rs.getObject("Cantidad");
                datos[5]=rs.getObject("Tipo");
                datos[6]=rs.getObject("Sabor");
                datos[7]=rs.getObject("Marca");
                datos[8]=rs.getObject("Azucar");
                chocolates.addRow(datos);
            }
            table.setModel(chocolates);
        }
        catch (SQLException ex) {
            Logger.getLogger(EliminarChocolate.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table;           
    }
    
    
    
    public JTable Buscar(JTable table,int Codigo){
            Connection conexion=Conexion.getConexion();

        DefaultTableModel chocolates=new DefaultTableModel();
        
        chocolates.addColumn("Código");
        chocolates.addColumn("Nombre");
        chocolates.addColumn("Descripción");
        chocolates.addColumn("Precio Venta $/250g");
        chocolates.addColumn("Cantidad g");
        chocolates.addColumn("Tipo");
        chocolates.addColumn("Sabor");
        chocolates.addColumn("Marca");
        chocolates.addColumn("Azúcar");
        table.setModel(chocolates);
        String query="SELECT * FROM chocolates WHERE Codigo=?";
        Object[]datos=new Object[9];
        try{
            PreparedStatement st=conexion.prepareStatement(query);
            st.setInt(1, Codigo);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                datos[0]=rs.getObject("Codigo");
                datos[1]=rs.getObject("Nombre");
                datos[2]=rs.getObject("Descripcion");
                datos[3]=rs.getObject("Precio_Venta");
                datos[4]=rs.getObject("Cantidad");
                datos[5]=rs.getObject("Tipo");
                datos[6]=rs.getObject("Sabor");
                datos[7]=rs.getObject("Marca");
                datos[8]=rs.getObject("Azucar");
                chocolates.addRow(datos);
            }
            table.setModel(chocolates);
        }
        catch (Exception e) {
            System.out.println("Error la buscar por codigo " + e.getMessage());
        }
     return table;           
    }
    public  boolean Check(int Codigo){
        boolean codigoExiste=false;
        try{
            Connection conexion=Conexion.getConexion();
            String query="Select * from chocolates";
            PreparedStatement verificar=conexion.prepareStatement(query);
            ResultSet r1=verificar.executeQuery();int codigo;
            while(r1.next()){
                codigo=r1.getInt("Codigo");
                if(codigo==Codigo){
                    System.out.println("Código Existe");
                    codigoExiste=true;
                    
                }
            }
        }
        catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
        return codigoExiste;
    }
}
