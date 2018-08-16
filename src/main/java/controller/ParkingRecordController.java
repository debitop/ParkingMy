package controller;

import dao.RecordDao;
import dao.daoImpl.RecordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Actions.DELETE;
import static util.Actions.LIST;

public class ParkingRecordController extends HttpServlet {
    private static final String LIST_RECORD = "listRecord.jsp";
    private static final String EDIT_RECORD = "editRecord.jsp";
    private RecordDao recordDao;

    public ParkingRecordController(){recordDao=new RecordDaoImpl();    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";
        if (action.equalsIgnoreCase(LIST.name())){
            int carId =Integer.parseInt(req.getParameter("carId"));
            req.setAttribute("carId", carId);
            req.setAttribute("records", recordDao.listRecordById(carId));
            view =LIST_RECORD;
        }
        else if(action.equalsIgnoreCase(DELETE.name())){
            int recordId = Integer.parseInt(req.getParameter("recordId"));
            int carId = Integer.parseInt(req.getParameter("carId"));
            recordDao.delRecord(recordId);
            req.setAttribute("records", recordDao.listRecordById(carId));
            view=LIST_RECORD;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
