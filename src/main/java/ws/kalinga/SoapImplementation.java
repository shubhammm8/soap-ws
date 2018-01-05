package ws.kalinga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class SoapImplementation implements SoapService{
	
	static final String jdbc_driver="com.mysql.jdbc.Driver";
	static final String db="jdbc:mysql://localhost/hibernate16";
	static final String user="root";
	static final String pass="Welcome123";
	Connection connection=null;
	Statement statement=null;
	@Override
	public List<Minds> getAllMinds() {
		
		try{
			System.out.println("Connecting...");
			connection=DriverManager.getConnection(db,user,pass);
			System.out.println("connected");
			statement=connection.createStatement();
			String query="Select * From Minds;";
			ResultSet rs=statement.executeQuery(query);
			
			List<Minds> minds=new ArrayList<Minds>();
			
			while(rs.next()){
				Minds m=new Minds();
				m.setLid(rs.getInt("l_id"));
				m.setMid(rs.getInt("m_id"));
				m.setMindName(rs.getString("m_name"));
				minds.add(m);
			}
			rs.close();
			return minds;
		}catch(Exception e){e.printStackTrace();
		return null;
		}finally{
			
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		
		
		
	
	}

	@Override
	public List<Track> getAlltrack() {
		List<Track> track=new ArrayList<Track>();

		try{
			System.out.println("connecting...");
			connection=DriverManager.getConnection(db,user,pass);
			System.out.println("connected");
			statement=connection.createStatement();
			String query="Select * from track";
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				Track t=new Track();
				t.setTid(rs.getInt("t_id"));
				t.setTrackName(rs.getString("t_name"));
				track.add(t);
				
			}
			rs.close();
		}catch(Exception e){e.printStackTrace();
		
		}finally{
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return track;

	}

	@Override
	public List<Lead> getallLead() {
		
		try {System.out.println("connecting...");
			connection=DriverManager.getConnection(db,user,pass);
			System.out.println("connected");
			statement=connection.createStatement();
			String query="Select * from Lead;";
			ResultSet rs=statement.executeQuery(query);
			List<Lead> lead=new ArrayList<Lead>();
			while(rs.next()){
				Lead l=new Lead();
				l.setLeadName(rs.getString("l_name"));
				l.setLid(rs.getInt("l_id"));
				l.setTid(rs.getInt("t_id"));
				lead.add(l);
				
				
			}
			rs.close();
			return lead;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		
		}finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public Lead getLeadById(int id) {
		Lead lead=new Lead();
		try{
			System.out.println("Connecting...");
			connection=DriverManager.getConnection(db,user,pass);
			System.out.println("connected");
			statement=connection.createStatement();
			String query="Select * from Lead where l_id="+id+";";
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
			lead.setLid(rs.getInt("l_id"));
			lead.setLeadName(rs.getString("l_name"));
			lead.setTid(rs.getInt("t_id"));
		}
			rs.close();
			
		}catch(Exception e){e.printStackTrace();
		
		}finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return lead;
	}

	@Override
	public Minds getMindById(int id) {
		Minds mind=new Minds();
		
		try{
			System.out.println("connecting...");
			connection=DriverManager.getConnection(db,user,pass);
			System.out.println("connected");
			statement=connection.createStatement();
			String query="Select * from minds where m_id="+id;
			ResultSet rs=statement.executeQuery(query);
			//rs.absolute(id);
			while(rs.next()){
			mind.setLid(rs.getInt("l_id"));
			mind.setMid(rs.getInt("m_id"));
			mind.setMindName(rs.getString("m_name"));
			}
			rs.close();
			
			
			
		}catch(Exception e){e.printStackTrace();}finally{
			try {
				
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mind;
	}

	@Override
	public Track getTrackById(int id) {
		Track track=new Track();
	try{System.out.println("connecting...");
	connection=DriverManager.getConnection(db,user,pass);
	System.out.println("connected");
	statement=connection.createStatement();
	String query="Select * from Track where t_id="+id+";";
	ResultSet rs=statement.executeQuery(query);
	while(rs.next()){
	
	track.setTid(rs.getInt("t_id"));
	track.setTrackName(rs.getString("t_name"));}
	rs.close();
	
	}catch(Exception e){e.printStackTrace();
	
}finally{
	try {
		statement.close();
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	return track;
	}

	@Override
	public String checkme() {
		// TODO Auto-generated method stub
		return "I m ok,YNWA";
	}

}
