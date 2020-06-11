package controller;

import Login.Mangger.UserDao;
import Login.model.User;
import Mangger.ShopDao;
import model.Shop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String test = request.getParameter("password");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "User":
                    userShop(request, response);
                    break;
                case "createUser":
                    insertUser(request, response);
                    break;
                case "create":
                    insertShop(request, response);
                    break;
                case "edit":
                    updateShop(request, response);
                    break;
                case "search":
                    searchResult(request, response);
                    break;
                default:
                    TiamoShop(request, response);
                    break;
            }
        } catch (Exception ex) {
            new Exception(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User newUser = new User(username, password);
        UserDao userDAO = new UserDao();
        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login/createUser.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("viewShop/viewShop.jsp");
    }

    private void searchResult(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Shop> shop ;
        String name = request.getParameter("name");
        ShopDao shopDao = new ShopDao();
        shop = shopDao.findByCountry(name);
        request.setAttribute("listShop", shop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/showSearch.jsp");
        dispatcher.forward(request, response);
    }

    private void updateShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String Description = request.getParameter("Description");

        Shop shops = new Shop(id, url, name, price, Description);
        ShopDao shopDao = new ShopDao();
        shopDao.updateShop(shops);
        request.setAttribute("shop", shops);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewShop/viewShop.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("viewShop/viewShop.jsp");
    }

    private void userShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDAO = new UserDao();
        User user = userDAO.Login(username);
        if (user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("IS_LOGGINED", true);
            session.setAttribute("ROLE", user.getId());
            response.sendRedirect("viewShop/viewShop.jsp");
        } else {
            request.setAttribute("message", "Đăng nhập không thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "ShopTiamo":
                    TiamoShop(request, response);
                    break;
                case "User":
                    ShowUserShop(request, response);
                    break;
                case "createUser":
                    showCreateUser(request, response);
                    break;
                case "create":
                    newShop(request, response);
                    break;
                case "delete":
                    delete(request, response);
                case "edit":
                    showUpdate(request, response);
                case "sort":
                    sortByName(request, response);
                    break;
                default:
                    TiamoShop(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void TiamoShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopDao shopDAO = new ShopDao();
        List<Shop> listShop = shopDAO.selectShop();
        request.setAttribute("listShop", listShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewShop/viewShop.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login/createUser.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowUserShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login/login.jsp");
        dispatcher.forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ShopDao shopDao = new ShopDao();
        List<Shop> shops = shopDao.sort();
        request.setAttribute("listShop", shops);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/sort.jsp");
        dispatcher.forward(request, response);
    }

    private void searchShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewShop.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShopDao shopDao = new ShopDao();
        List<Shop> Shop = shopDao.SelectShop(id);
        request.setAttribute("Shop", Shop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/update.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewShop/viewShop.jsp");
        dispatcher.forward(request, response);
    }

    private void newShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/create.jsp");
        dispatcher.forward(request, response);
    }
}

