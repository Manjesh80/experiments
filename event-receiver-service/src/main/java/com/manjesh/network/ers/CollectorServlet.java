package com.manjesh.network.ers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by aadhya on 11/19/2016.
 */

@WebServlet(name = "CollectorServlet", urlPatterns = "/collector")
public class CollectorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet TestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CollectorServlet at " + request.getContextPath() + "</h1>");

        Client client = ClientBuilder.newClient();
        client.register(VirtualNetworkEventSerializer.class)
                .register(VirtualNetworkEvent.class)
                .register(ClientLoggingFilter.class);

        WebTarget target = client.target("http://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/ers");

        System.out.println("Making webrequest to  " + target.getUri().toURL().toString());

        Entity virtualNetworkEventEntity = Entity.entity(
                new VirtualNetworkEvent(1, "Wifi-Network"), MediaType.APPLICATION_XML_TYPE);
        Response response1 = target.request().post(virtualNetworkEventEntity);

        VirtualNetworkEvent event1 = response1.readEntity(VirtualNetworkEvent.class);

        out.println("Received response for Device: " + event1.getDeviceID() + "<br><br>");
        out.println("Received response for Network: " + event1.getNetworkID() + "<br><br>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
