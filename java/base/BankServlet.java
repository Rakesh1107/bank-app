package base;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cache.Cache;
import exception.BankException;
import logic.Initiator;
import persistence.DBConnector;
import pojo.Account;
import pojo.Customer;

@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	
	Initiator initiator = Initiator.INSTANCE;
	Cache cache = Cache.INSTANCE;
	
	private static final long serialVersionUID = 1L;
    
    public BankServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		RequestDispatcher rd = null;
		
		if (page.equalsIgnoreCase("accounts")) {
			
			try {
				DBConnector connector = new DBConnector();
				List<Account> accounts = connector.getAccounts();
				request.setAttribute("data", accounts);
				
			    rd = request.getRequestDispatcher("accounts.jsp");
				rd.forward(request, response);
				
			} catch (BankException e) {
				request.setAttribute("message", "Failed to load accounts");
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			
			
			
		}
		else if (page.equalsIgnoreCase("customers")) {
			
			try {
				DBConnector connector = new DBConnector();
				List<Customer> customers = connector.getCustomers();
				request.setAttribute("data", customers);
				
				rd = request.getRequestDispatcher("customers.jsp");
				rd.forward(request, response);
			}
			catch (BankException e) {
				request.setAttribute("message", "Failed to load customers");
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			
		}
		else if (page.equalsIgnoreCase("transactions")) {
			
				rd = request.getRequestDispatcher("transactions.jsp");
				rd.forward(request, response);
			
			
		}
	}

}
