/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cristian
 */
public class Chocolate {
    
    private int Codigo;
    private String Nombre;
    private String Descripcion;
    private int precioVenta;
    private int Cantidad;
    private String Tipo;
    private String Sabor;
    private String Marca;
    private boolean Azucar;
    
    public Chocolate(){}
    
    public Chocolate(int Codigo,String Nombre,String Descripcion,int precioVenta,
            int Cantidad,String Tipo,String Sabor,String Marca,boolean Azucar){
        
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
        this.precioVenta=precioVenta;
        this.Cantidad=Cantidad;
        this.Tipo=Tipo;
        this.Sabor=Sabor;
        this.Marca=Marca;
        this.Azucar=Azucar;
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String Sabor) {
        this.Sabor = Sabor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public boolean isAzucar() {
        return Azucar;
    }

    public void setAzucar(boolean Azucar) {
        this.Azucar = Azucar;
    }

    @Override
    public String toString() {
        return "Codigo: " + Codigo + "  Nombre: " + Nombre + "  Descripcion:" + Descripcion + "  Precio Venta (1/4 K): " + precioVenta + 
                "  Cantidad: " + Cantidad + "  Tipo:" + Tipo + "  Sabor: " + Sabor + "  Marca:" + Marca + "  Azucar:" + Azucar;
    }
    
    
    
}
