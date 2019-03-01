package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class VooController {
	@RequestMapping("/")
    public String index() {
        return voos().toString();
    }
	
	private List<Voo> voos() {
	    try {
	      final String URL = "https://opensky-network.org/api/states/all";
	      Map o = ClientBuilder
	        .newClient()
	        .target(URL)
	        .queryParam("lamin", "45.8389")
	        .queryParam("lomin", "5.9962")
	        .queryParam("lamax", "47.8229")
	        .queryParam("lomax", "10.5226")
	        .request()
	        .accept(MediaType.APPLICATION_JSON)
	        .get(Map.class)
	      ;
	      return processa(o);
	    } catch (RuntimeException e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
	    }
	  }
	
	private List<Voo> processa(final Map map) {
	    final List<Voo> voos = new ArrayList<Voo>();
	    final List lines = (List)map.get("states");
	    for(int i = 0, l = lines.size(); i < l; i++) {
	      final List line = (List)lines.get(i);
	      voos.add(new Voo(line));
	    }
	    return voos;
	}
}