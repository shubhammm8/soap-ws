package ws.kalinga;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface SoapService {
	@WebMethod
	public List<Minds> getAllMinds();
	@WebMethod
	public List<Track> getAlltrack();
	@WebMethod
	public List<Lead> getallLead();
	@WebMethod
	public Lead getLeadById(int id);
	@WebMethod
	public Minds getMindById(int id);
	@WebMethod
	public Track getTrackById(int id);
	@WebMethod
	public String checkme();
	
	
}
