/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.Kernel;

/**
 *
 * @author c
 */
@WebServlet(name = "GenControl", urlPatterns = {""})
public class GenControl extends HttpServlet {

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

        HashMap<String,String> h = new HashMap();
        h.put("1", "food.html");
        h.put("2", "water.html");
        h.put("3", "energy.html");
        h.put("4", "health.html");
        h.put("5", "equipement.html");
        h.put("6", "maintenance.html");
        String action = request.getParameter("action");
        action = (action == null) ?  "" : action;
        switch(action){
            case "":
                request.getRequestDispatcher("view/newjsp.jsp").forward(request, response);
                break;
            
            
            case "2":

                    response.sendRedirect(request.getContextPath()+"/water_Control");
                   break;
            default : request.getRequestDispatcher("newjsp.jsp").forward(request, response); 
            
            case "3":
                   response.sendRedirect(request.getContextPath()+"/nourriture_control");
                   break;
                   
                   
   
         
         
        }
        
        
        
        
        
         
        request.getRequestDispatcher("/view/GenJSP.jsp").forward(request, response);
        
        
        
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
