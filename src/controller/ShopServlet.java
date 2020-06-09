package controller;

import Mangger.ShopDao;
import model.Shop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "list":
                    listShop(request, response);
                    break;
                case "create":
                    insertShop(request, response);
                    break;
                case "update":
                    updateShop(request, response);
                    break;
                case "search":
                    searchResult(request,response);
                    break;
                default:
                    listShop(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void searchResult(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Shop> shops;
        String country = request.getParameter("country");
        ShopDao shopDao= new ShopDao();
        shops= shopDao.findByCountry(country);
        request.setAttribute("shop",shops);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/showSearch.jsp");
        dispatcher.forward(request,response);
    }

    private void updateShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String Description = request.getParameter("Description");


        Shop book = new Shop(id, url, name, price, Description);
        ShopDao shopDao = new ShopDao();
        shopDao.updateShop(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/update.jsp");
        dispatcher.forward(request, response);
    }

    private void insertShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String Description = request.getParameter("Description");
        Shop newShop = new Shop(url, name, price, Description);
        ShopDao shopDao = new ShopDao();
        shopDao.insertShop(newShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/list.jsp");
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "list":
                    listShop(request, response);
                    break;
                case "create":
                    newShop(request, response);
                    break;
                case "delete":
                    delete(request, response);
                case "update":
                    showUpdate(request, response);
                case "search":
                    searchShop(request,response);
                    break;
                case "sortByName":
                    sortByName(request,response);
                    break;
                default:
                    listShop(request, response);
                    break;

            }
        } catch (Exception ex) {
            new Exception(ex);
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ShopDao shopDao=new ShopDao();
        List<Shop> shops = shopDao.sort();
        request.setAttribute("shop",shops);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/sort.jsp");
        dispatcher.forward(request,response);
    }

    private void searchShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/showSearch.jsp");
        dispatcher.forward(request,response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShopDao shopDao = new ShopDao();
        Shop Shop = (Shop) shopDao.selectShop();
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/update.jsp");
        request.setAttribute("shop", Shop);
        dispatcher.forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShopDao shopDao = new ShopDao();
        try {
            shopDao.deleteShop(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Shop> listShop = shopDao.selectShop();
        request.setAttribute("listShop", listShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/list.jsp");
        dispatcher.forward(request, response);
    }

    private void newShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopDao shopDAO = new ShopDao();
        List<Shop> listShop = shopDAO.selectShop();
        request.setAttribute("listShop", listShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/list.jsp");
        dispatcher.forward(request, response);
    }
}

