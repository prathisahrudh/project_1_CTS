

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import voter.*;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		//Taking Input from the UI
		String aadhar = request.getParameter("aadhar");
		String phoneNo_String = request.getParameter("pno");
		String address = request.getParameter("addr");
		String Email = request.getParameter("email");
		String pass = request.getParameter("pass");

		int phoneNo_int = Integer.parseInt(phoneNo_String);
		Voter v = new Voter();
		v.setAadhar_number(Integer.parseInt(aadhar));
		v.setPhone_no(phoneNo_int);
		v.setAddress(address);
		v.setEmail(Email);
		v.setPassword(pass);
		
		VoterDAO voterdao = new VoterDAO();
		int k =voterdao.addVoter(v);
		
		if(k> 0)
		{
			out.println("Voter Registered Sucessfully");
		}
		else {
			out.println("Voter could not be Registered");
		}
	}


}
