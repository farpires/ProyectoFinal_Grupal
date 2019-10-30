package daogenerico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author DMALDONADO
 */
public class ErroresGenerales extends Exception 
{
    String MensajeDeErrorGeneral;
    String MensajeDeErrorSalida;

    public ErroresGenerales(String MensajeDeErrorGeneral)
    {
        this.MensajeDeErrorGeneral = MensajeDeErrorGeneral;
        this.MensajeDeErrorSalida = MensajeDeErrorGeneral;
        
        /* DEPENDIENDO DE LOS MENSAJES DE ERROR DE ENTRADA, LOS VOY TRADUCIENDO Y CONVIRTIENDO A LO QUE CORRESPONDA QUE QUEREMOS MOSTRAR POR PANTALLA */
        
         if (MensajeDeErrorGeneral.contains("duplicate key value violates unique constraint") && (!MensajeDeErrorGeneral.isEmpty()))
         {
              MensajeDeErrorSalida = ("Ese Registro ya existe con el valor que está intentando ingresar " +  this.MensajeDeErrorGeneral.substring(this.MensajeDeErrorGeneral.indexOf("Detail:")));         
         }
         
         if (MensajeDeErrorGeneral.contains("null value in column") && (!MensajeDeErrorGeneral.isEmpty()))
         {
              MensajeDeErrorSalida = ("Está intentando Insertar un valor nulo. " +  this.MensajeDeErrorGeneral.substring(this.MensajeDeErrorGeneral.indexOf("Detail:")));         
         }        
    }

    public String getMensajeDeErrorGeneral() 
    {
        return MensajeDeErrorGeneral;
    } 

    public String getMensajeDeErrorSalida()
    {
        return MensajeDeErrorSalida;
    }
    
}
