/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import com.google.gson.Gson;
import daogenerico.ErroresGenerales;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "categoriaWS", urlPatterns = {"/categoriaWS"})
public class categoriaWS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String MensajeADevolverEnFormatoJSON = "";
        
        int TipoProceso = 0;
        TipoProceso = Integer.valueOf(request.getParameter("TipoProceso"));
        
        if (TipoProceso == 4) // Es una Consulta
        {
            String NombreCategoria = "";    
            String ComandoSQL = ""; 
            NombreCategoria = request.getParameter("CategoriaNombreABuscar");
            
            categoriaDAO MyCategoriaDAO = new categoriaDAO();
                                
            if (NombreCategoria.isEmpty())
            {
               /* ComandoSQL = "select producto.*,categoria.categorianombre from producto inner join categoria on producto.categoriapk = categoria.categoriapk";   */
            ComandoSQL = "select categoria.*,distribuidora.distribuidoranombre from categoria inner join distribuidora on categoria.iddistribuidora = distribuidora.iddistribuidora";   
           
            }
            else
            {
                ComandoSQL = "select producto.*,categoria.categorianombre from producto inner join categoria on producto.categoriapk = categoria.categoriapk where producto.productonombre like '%" + NombreCategoria.trim() + "%'";
              ComandoSQL = "select categoria.*,distribuidora.distribuidoranombre from categoria inner join distribuidora on categoria.iddistribuidora = distribuidora.iddistribuidora where categoria.categorianombre like '%" + NombreCategoria.trim() + "%'";
         
            }  
            
            try 
            {
                MensajeADevolverEnFormatoJSON = MyCategoriaDAO.getJoinAllToJSON(ComandoSQL);
            } catch (ErroresGenerales ex) 
            {
                MensajeADevolverEnFormatoJSON = ex.getMensajeDeErrorGeneral();
            }
        }
        else
        {                       
            // Es 1 = Alta, 2 = Modificacion, 3 = Eliminacion
            if ((TipoProceso == 1) || (TipoProceso == 2) || (TipoProceso==3)) 
            {
                String ParametroEntrada = "";
                ParametroEntrada = request.getParameter("ParametroJSON");
                
                MensajeADevolverEnFormatoJSON = ProcesarAltaBajaModificacion(TipoProceso,ParametroEntrada);                
            } 
            else
            {
                if (TipoProceso == 5)
                {
                    Long PK = Long.valueOf(0);
                    PK = Long.valueOf(request.getParameter("PK"));
                    if (PK > 0)
                    {
                        categoriaDAO MyCategoriaDAO = new categoriaDAO();                    
                        try 
                        {
                            MensajeADevolverEnFormatoJSON = MyCategoriaDAO.LoadRecordToJSON(PK);                                             
                        } 
                        catch (ErroresGenerales ex) 
                        {
                            MensajeADevolverEnFormatoJSON = ex.getMensajeDeErrorGeneral();
                        }
                    }
                    else
                    {
                        MensajeADevolverEnFormatoJSON = "NO PUEDO DEVOLVER LA CATEGORIA PORQUE NO TENGO LA CLAVE PRIMARIA !!!.";
                    }
                }
                else
                {
                    MensajeADevolverEnFormatoJSON = "TIPO DE PROCESO NO IMPLEMENTADO TODAVÍA !!!." + TipoProceso;
                }
            }          
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println(MensajeADevolverEnFormatoJSON);
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoWS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoWS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String ProcesarAltaBajaModificacion(int TipoProceso,String ParametroEntrada)
    {
        String SalidaJSON = "";
        if (!ParametroEntrada.isEmpty())
        {           
            categoria P = new categoria();  
            Gson Conversor = new Gson();                    
            P = Conversor.fromJson(ParametroEntrada,categoria.class);   
            
            categoriaDAO DAO = new categoriaDAO();
            
            if (TipoProceso == 1) // es ALTA
            {     
                try 
                {
                    categoria ProductoAgregado = DAO.AddRecord(P);
                    SalidaJSON = "Categoria Agregado " + ProductoAgregado.toString();
                } 
                catch (ErroresGenerales ex)
                {
                    SalidaJSON = ex.getMensajeDeErrorGeneral();
                }
            }
            
            
            // MensajeADevolverEnFormatoJSON = ProcesarAltaBajaModificacion(TipoProceso,ParametroEntrada);
            if (TipoProceso == 2) // es MODIFICACION
            {   
                try 
                {
                    boolean PudimosActualizar = DAO.UpdateRecord(P);
                    if (PudimosActualizar)
                    {
                        SalidaJSON = "Categoria Actualizado !!!";
                    }   
                    else
                    {
                        SalidaJSON = "La Categoria no pudo ser Actualizado !!!";
                    }
                } 
                catch (ErroresGenerales ex)
                {
                    SalidaJSON = ex.getMensajeDeErrorGeneral();
                }
            }        
            if (TipoProceso == 3) // es BAJA
            {      
               try 
                {
                    boolean PudimosEliminar = DAO.DeleteRecord(P);
                    if (PudimosEliminar)
                    {
                        SalidaJSON = "Categoria Eliminado !!!";
                    }      
                    else
                    {
                        SalidaJSON = "La categoria no pudo ser Eliminado";
                    }
                } 
                catch (ErroresGenerales ex)
                {
                    SalidaJSON = ex.getMensajeDeErrorGeneral();
                }
            }
        }
      
        return SalidaJSON;        
    }
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

}
