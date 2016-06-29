/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.Conexion;
import cl.model.Empleado;
import cl.model.Grupo;
import cl.model.Metas;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Skitles
 */
public class MetasMysql implements MetasDao {

    @Override
    public Metas FindById(int id) {
       ResultSet rs =Conexion.getResults("SELECT * FROM METAS WHERE META_ID="+id);
        Metas meta=null;
        GrupoDao gg = new GrupoMysql();
         try {    
            while(rs.next()){           
                meta = new Metas(rs.getInt("META_ID"), rs.getDate("META_FECHA_INICIO").toString(), rs.getDate("META_FECHA_TERMINO").toString(), rs.getInt("META_CANT_VENTAS"),rs.getInt("META_CANT_VISITAS"),rs.getInt("META_CANT_CLI_NUEVOS"),gg.FindById(rs.getInt("META_GRU_ID")));
            }
         return meta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return meta;
    }

    @Override
    public ArrayList<Metas> FindAll() {
       ResultSet rs =Conexion.getResults("SELECT * FROM METAS");
        ArrayList<Metas> meta = new ArrayList(); 
        GrupoDao gg = new GrupoMysql();
         try {    
            while(rs.next()){           
                Metas g1 = new Metas(rs.getInt("META_ID"), rs.getDate("META_FECHA_INICIO").toString(), rs.getDate("META_FECHA_TERMINO").toString(), rs.getInt("META_CANT_VENTAS"),rs.getInt("META_CANT_VISITAS"),rs.getInt("META_CANT_CLI_NUEVOS"),gg.FindById(rs.getInt("META_GRU_ID")));
                meta.add(g1);
            }
         return meta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return meta;
    }

    @Override
    public void Save(Metas m) {
         Conexion.insertarEditarBorrar("INSERT INTO METAS (META_ID,META_FECHA_INICIO,META_FECHA_TERMINO,META_CANT_VENTAS,META_CANT_VISITAS,META_CANT_CLI_NUEVOS,META_GRU_ID) VALUES ("+m.getMeta_id()+",'"+m.getMeta_fecha_inicio()+"','"+m.getMeta_fecha_termino()+"',"+m.getMeta_cant_ventas()+","+m.getMeta_cant_visitas()+","+m.getMeta_cant_clientes()+","+m.getGrupo().getGru_id()+")");
    }

    @Override
    public Metas FindByDateAndGroup(String date, Grupo g) {
       ResultSet rs =Conexion.getResults("SELECT * from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and `META_GRU_ID`="+g.getGru_id());
       Metas meta=null;
        GrupoDao gg = new GrupoMysql();
         try {    
            while(rs.next()){           
                meta = new Metas(rs.getInt("META_ID"), rs.getDate("META_FECHA_INICIO").toString(), rs.getDate("META_FECHA_TERMINO").toString(), rs.getInt("META_CANT_VENTAS"),rs.getInt("META_CANT_VISITAS"),rs.getInt("META_CANT_CLI_NUEVOS"),gg.FindById(rs.getInt("META_GRU_ID")));
            }
         return meta;            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return meta;
    }
    
    public static void GenerarGrafico(String date,Grupo g,Empleado e) throws IOException{   
     MetasMysql o = new MetasMysql();
     Metas m = o.FindByDateAndGroup(date,g);
     DefaultCategoryDataset data = new DefaultCategoryDataset();
     data.setValue(m.getMeta_cant_ventas(),"Meta conseguida","Ventas");
     data.setValue(o.ObtCantidadVentasSem(date, e),"Estado de meta","Ventas");
     data.setValue(m.getMeta_cant_visitas(),"Meta conseguida","Visitas");
     data.setValue(o.ObtCantidadCli_Vistado(date,e),"Estado de meta","Visitas");
     data.setValue(m.getMeta_cant_clientes(),"Meta conseguida","Clientes nuevos");
     data.setValue(o.ObtCantidadCliNuevos(date, e),"Estado de meta","Clientes nuevos");
     JFreeChart grafico = ChartFactory.createBarChart("Estadísticas de metas semanales", "", "", data, PlotOrientation.VERTICAL,true,true,false);
     ChartUtilities.saveChartAsPNG(new File("C:\\Users\\Skitles\\Documents\\NetBeansProjects\\ProyectoKlingon\\ProyectoKlingon-war\\web\\Imagenes\\grafica"+e.getRut()+".png"), grafico, 440, 275);
    }
    
    @Override
    public  int ObtCantidadCli_Vistado(String date,Empleado e){
    ResultSet rs = Conexion.getResults("select count(RU_CLI_RUT)as CANT from ruta where `RU_FECHA` BETWEEN \n" +
"(SELECT `META_FECHA_INICIO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and \n" +
"`META_GRU_ID`="+e.getGrupo().getGru_id()+") \n" +
" AND \n" +
" (SELECT `META_FECHA_TERMINO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and \n" +
"`META_GRU_ID`="+e.getGrupo().getGru_id()+") \n" +
" and ru_estado='visitado' and ru_emp_rut="+e.getRut());
    int cantidad=0;
        try {
            if (rs.next()){ // nos devuelve algo
                cantidad = rs.getInt("CANT");
                return cantidad;
            }   } catch (SQLException ex) {
            Logger.getLogger(MetasMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cantidad;
    }
    
    @Override
    public  int ObtCantidadCliNuevos(String date, Empleado e){
    ResultSet rs = Conexion.getResults(" SELECT COUNT(`CLI_RUT`) as CANTCLI FROM `cliente` WHERE `CLI_FECHA_INGRESO` BETWEEN \n" +
"(SELECT `META_FECHA_INICIO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and `META_GRU_ID`="+e.getGrupo().getGru_id()+") \n" +
" AND \n" +
" (SELECT `META_FECHA_TERMINO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and `META_GRU_ID`="+e.getGrupo().getGru_id()+") \n" +
" AND `CLI_EMP_RUT`="+e.getRut());
    int cantidad=0;
        try {
            if (rs.next()){ // nos devuelve algo
                cantidad = rs.getInt("CANTCLI");
                return cantidad;
            }   } catch (SQLException ex) {
            Logger.getLogger(MetasMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cantidad;
    }

    @Override
    public int ObtCantidadVentasSem(String date, Empleado e) {
        ResultSet rs = Conexion.getResults("SELECT COUNT(`VEN_ID`) as CANTVEN FROM `venta` JOIN cliente ON venta.VEN_CLI_RUT=cliente.CLI_RUT WHERE cliente.CLI_EMP_RUT="+e.getRut()+" \n" +
"and \n" +
"venta.VEN_FECHA BETWEEN\n" +
"(SELECT `META_FECHA_INICIO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and \n" +
"\n" +
"`META_GRU_ID`="+e.getGrupo().getGru_id()+")\n" +
"AND\n" +
"(SELECT `META_FECHA_TERMINO` from metas where '"+date+"' BETWEEN `META_FECHA_INICIO` and `META_FECHA_TERMINO` and \n" +
"\n" +
"`META_GRU_ID`="+e.getGrupo().getGru_id()+") and `VEN_ESTADO`='REALIZADA'");
    int cantidad=0;
        try {
            if (rs.next()){ // nos devuelve algo
                cantidad = rs.getInt("CANTVEN");
                return cantidad;
            }   } catch (SQLException ex) {
            Logger.getLogger(MetasMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cantidad;
    }
    
    
    
}
