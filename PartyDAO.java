package party;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PartyDAO implements PartyService{

	static Connection con = null;
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newVoting", "root", "ITdept~8915");
			System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
		return con;
	}
	
	
	@Override
	public int addParty(Party p) {
		Connection con = PartyDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("insert into party values(?,?,?,?)");
			ps.setInt(1,p.getParty_Id());
			ps.setString(2,p.getParty_Name());
			ps.setString(3,p.getParty_Number());
			ps.setInt(4, p.getContact_Number());
			int k = ps.executeUpdate();
			return k;
		}
		catch(Exception e) {
			System.out.println("Exception is :"+e);
		}
		return 0;
	}
	
	
	@Override
	public List<Party> getAll() {
		List<Party> objx = new ArrayList<Party>();
		Connection con = PartyDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from party");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Party p = new Party();
				p.setParty_Id(rs.getInt(1));
				p.setParty_Name(rs.getString(2));
				p.setParty_Number(rs.getNString(3));
				p.setContact_Number(rs.getInt(4));
				objx.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objx;
	}

	@Override
	public int deleteParty(int partyId) {
		Connection con = PartyDAO.getConnect();
		List<Party> lip = new ArrayList<Party>();
		try {
			PreparedStatement ps = con.prepareStatement("select party_id from party");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Party p = new Party();
				p.setParty_Id(rs.getInt(1));
				int id = p.getParty_Id();
				
				if(id == partyId) {
					lip.remove(p);
					break;
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("The Exception is :"+e);
		}
		return 0;
	}

}
