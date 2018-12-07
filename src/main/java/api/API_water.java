/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Dao_water;
import dao.DataSourceFactory;
import static dao.DataSourceFactory.getDataSource;
import entity.Water;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(name = "Water", urlPatterns = {"/Water"})
public class API_water extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            action = (action == null) ? "" : action;
            switch(action){
                case "currentData":
                    
                    break;
                case "historyData":
                    try{
                       Date dateStartSQL = Date.valueOf(request.getParameter("dateStart"));
                       Date dateEndSQL = Date.valueOf(request.getParameter("dateEnd"));
                       Dao_water dao_water = new Dao_water(DataSourceFactory.getDataSource());
                       List<Water> WaterHist = dao_water.getWaterHistory(dateStartSQL, dateEndSQL);
                       

                        System.out.println(WaterHist);
                       
                    } catch (IllegalArgumentException ex){
                       
                    }
                    
                    
                    
                    break;
            }
        } catch (Exception ex){
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

}
