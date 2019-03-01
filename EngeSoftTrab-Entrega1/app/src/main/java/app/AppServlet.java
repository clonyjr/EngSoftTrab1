package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet("/")
public class AppServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //request.setAttribute("voos", voos());
	  PrintWriter out =  response.getWriter();
    for(int i = 0, l = voos().size(); i < l; i++) {
        out.println(voos().get(i));
    }
    //request.getRequestDispatcher("webapp/WEB-INF/index.jsp").forward(request, response);
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