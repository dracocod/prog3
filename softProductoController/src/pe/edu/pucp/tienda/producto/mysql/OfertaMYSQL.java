/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.producto.dao.OfertaDAO;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.model.Oferta;
import pe.edu.pucp.tienda.producto.model.Producto;

/**
 *
 * @author alexis
 */
public class OfertaMYSQL implements OfertaDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public int insertar(Oferta oferta) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            //System.out.println(con);
            cs = con.prepareCall("{call InsertarOferta"
                    + "(?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idOferta", java.sql.Types.INTEGER);
            //cs.setString("_DNI", cliente.getDNI());
            cs.setString("p_descripcion", oferta.getDescripcion());
            cs.setDouble("p_descuento", oferta.getDescuento());
            cs.setDate("p_fechaInicio", new java.sql.Date(oferta.getFechaInicio().getTime()));
            cs.setDate("p_fechaFin", new java.sql.Date(oferta.getFechaFin().getTime()) );
            cs.setInt("p_idProducto", oferta.getProducto().getCodigo());
            cs.executeUpdate();
            oferta.setIdOferta(cs.getInt("p_idOferta"));
            resultado = oferta.getIdOferta();
        } catch (Exception ex) {
            // System.out.println("no entrio");
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //System.out.println(resultado);
        return resultado;
    }

    @Override
    public ArrayList<Oferta> listar() {
    ArrayList<Oferta> ofertas = new ArrayList<>();
    productoDAO proddao = new productoMYSQL();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaOfertas()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Oferta oferta = new Oferta();
                Producto prod = new Producto();
                prod = proddao.buscarProducto(rs.getInt("idProducto"));
                oferta.setIdOferta(rs.getInt("idOferta"));
                //oferta.setDescripcion(rs.getString("des"));
                oferta.setDescripcion(rs.getString("descripcion"));
                oferta.setDescuento(rs.getDouble("descuento"));
                oferta.setFechaInicio(rs.getDate("fechaInicio"));
                oferta.setFechaFin(rs.getDate("fechaFin"));
                oferta.setProducto(prod);
                //oferta.setProducto();
                ofertas.add(oferta);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return ofertas;       
    }

    @Override
    public int eliminar(int id) {
int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaOferta"
                    + "(?)}");
            cs.setInt("p_idOferta", id);
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Oferta oferta) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaOferta"
                    + "(?,?,?,?,?,?)}");
            cs.setInt("p_idOferta", oferta.getIdOferta());
            //System.out.println(producto.getCodigo());
            //cs.setString("p_nombre", oferta.getNombre());
            cs.setString("p_descripcion", oferta.getDescripcion());
            //cs.setString("p_estadoTipoProducto", oferta.getEstadoTipoProducto().toString());
            cs.setDouble("p_descuento",oferta.getDescuento());
            cs.setDate("p_fechaInicio", new java.sql.Date(oferta.getFechaInicio().getTime()));
            cs.setDate("p_fechaFin", new java.sql.Date(oferta.getFechaFin().getTime()));
            cs.setInt("p_idProducto", oferta.getProducto().getCodigo());
            resultado = cs.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;   
    }

    @Override
    public double buscarOferta(int idProducto) {
        Oferta oferta = new Oferta();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call buscarOfertasXProducto"
                + "(?)}");
            cs.setInt("p_idProducto", idProducto);
            rs = cs.executeQuery();
            if (rs.next()) {
                oferta.setIdOferta(rs.getInt("idOferta"));
                oferta.setDescripcion(rs.getString("descripcion"));
                oferta.setDescuento(rs.getDouble("descuento"));
                oferta.setFechaInicio(rs.getDate("fechaInicio"));
                oferta.setFechaInicio(rs.getDate("fechaFin"));
            }else{
                oferta.setIdOferta(0);
                oferta.setDescuento(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return oferta.getDescuento();     
    }

    @Override
    public Oferta buscarOfertaXId(int idOferta) {
        Oferta oferta = new Oferta();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call buscardOfertaXId"
                + "(?)}");
            cs.setInt("p_idOferta", idOferta);
            rs = cs.executeQuery();
            if (rs.next()) {
                oferta.setIdOferta(rs.getInt("idOferta"));
                oferta.setDescripcion(rs.getString("descripcion"));
                oferta.setDescuento(rs.getDouble("descuento"));
                oferta.setFechaInicio(rs.getDate("fechaInicio"));
                oferta.setFechaFin(rs.getDate("fechaFin"));
            }else{
                oferta.setIdOferta(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return oferta;
    }
}

