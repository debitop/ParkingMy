package controller;

import dao.CarDao;
import dao.daoImpl.CarDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Actions.DELETE;
import static util.Actions.LIST;

public class CarController extends HttpServlet {
    private static final String LIST_CAR = "listCar.jsp";
    private static final String EDIT_CAR = "editCar.jsp";
    private CarDao carDao;

    public CarController(){carDao=new CarDaoImpl();    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";
        if (action.equalsIgnoreCase(LIST.name())){
            int ownerId = Integer.parseInt(req.getParameter("ownerId"));
            req.setAttribute("ownerId", ownerId);
            req.setAttribute("cars", carDao.listCarById(ownerId));
            view=LIST_CAR;
        }else if (action.equalsIgnoreCase(DELETE.name())){
            int carId = Integer.parseInt(req.getParameter("carId"));
            int ownerId = Integer.parseInt(req.getParameter("ownerId"));
            carDao.delCar(carId);
            req.setAttribute("cars", carDao.listCarById(ownerId));
            view=LIST_CAR;
        }
        req.getRequestDispatcher(view).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
