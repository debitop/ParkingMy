package controller;

import dao.DriverDao;
import dao.daoImpl.DriverDaoImpl;
import model.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Actions.*;

public class DriverController extends HttpServlet {
    private static final String LIST_DRIVER = "/listDriver.jsp";
    private static final String EDIT_DRIVER = "/editDriver.jsp";
    private DriverDao driverDao;

    public DriverController() {
        driverDao = new DriverDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";
        if (action.equalsIgnoreCase(LIST.name())) {
            req.setAttribute("drivers", driverDao.listDriver());
            view = LIST_DRIVER;
        } else if (action.equalsIgnoreCase(CREATE.name())) {
            view = EDIT_DRIVER;
        } else if (action.equalsIgnoreCase(EDIT.name())) {
            int id = Integer.parseInt(req.getParameter("ownerId"));
            Driver driver = driverDao.getDriverById(id);
            req.setAttribute("driver", driver);
            view = EDIT_DRIVER;
        } else if (action.equalsIgnoreCase(DELETE.name())) {
            int id = Integer.parseInt(req.getParameter("ownerId"));
            driverDao.delDriver(id);
            req.setAttribute("drivers", driverDao.listDriver());
            view = LIST_DRIVER;
        } else {
            throw new RuntimeException();
        }
        req.getRequestDispatcher(view).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Driver driver = new Driver();
        driver.setUsername(req.getParameter("username"));
        String ownerId = req.getParameter("ownerId");
        if (ownerId == null || ownerId.isEmpty()) {
            driverDao.addDriver(driver);
        } else {
            driver.setOwnerId(Integer.parseInt(ownerId));
            driverDao.editDriver(driver);
        }
        req.setAttribute("drivers", driverDao.listDriver());
        req.getRequestDispatcher(LIST_DRIVER).forward(req, resp);
    }
}
