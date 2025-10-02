package murach.download;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;

import murach.business.Product;
import murach.business.User;
import murach.data.ProductIO;
import murach.data.UserIO;
import murach.util.CookieUtil;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "listAlbums"; // mặc định
        }

        String url = "/index.jsp";

        if (action.equals("listAlbums")) {
            ServletContext sc = getServletContext();
            String productPath = sc.getRealPath("/WEB-INF/products.txt");
            List<Product> products = ProductIO.getProducts(productPath);

            request.setAttribute("products", products);
            url = "/index.jsp";
        }
        else if (action.equals("checkUser")) {
            String productCode = request.getParameter("productCode");

            Cookie emailCookie = CookieUtil.getCookie(request.getCookies(), "emailCookie");
            if (emailCookie != null && !emailCookie.getValue().equals("")) {
                ServletContext sc = getServletContext();
                String productPath = sc.getRealPath("/WEB-INF/products.txt");
                Product product = ProductIO.getProduct(productCode, productPath);

                HttpSession session = request.getSession();
                session.setAttribute("product", product);

                url = "/" + productCode + "_download.jsp";
            } else {
                url = "/register.jsp?productCode=" + productCode;
            }
        }
        else if (action.equals("viewCookies")) {
            url = "/view_cookies.jsp";
        }
        else if (action.equals("deleteCookies")) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    c.setMaxAge(0);
                    c.setPath("/");  
                    response.addCookie(c);
                }
            }

            // Invalidate session
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            // Xóa JSESSIONID luôn
            Cookie jsession = new Cookie("JSESSIONID", "");
            jsession.setMaxAge(0);
            jsession.setPath(request.getContextPath());
            response.addCookie(jsession);

            // Redirect để tránh Tomcat tạo session mới
            response.sendRedirect(request.getContextPath() + "/delete_cookies.jsp");
            return;
        }

        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "registerUser";
        }

        String url = "/index.jsp";

        if (action.equals("registerUser")) {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String productCode = request.getParameter("productCode");

            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            ServletContext sc = getServletContext();
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            UserIO.add(user, path);

            // set cookie (fix path = "/")
            Cookie c = new Cookie("emailCookie", email);
            c.setMaxAge(60 * 60 * 24 * 365 * 3); 
            c.setPath("/");
            response.addCookie(c);

            // put product vào session
            String productPath = sc.getRealPath("/WEB-INF/products.txt");
            Product product = ProductIO.getProduct(productCode, productPath);

            HttpSession session = request.getSession();
            session.setAttribute("product", product);

            url = "/" + productCode + "_download.jsp";
        }

        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}
