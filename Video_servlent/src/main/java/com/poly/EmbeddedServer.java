package com.poly;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedServer {

    public static void main(String[] args) throws Exception {
        // Create a basic Jetty server object that will listen on port 8081.
        Server server = new Server(8081);

        // Configure the WebAppContext for the web application.
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/VideoServlent");

        // Set the location of the webapp resources (webapp directory).
        // Adjust the path below if your webapp directory is located elsewhere.
        webapp.setResourceBase("src/main/webapp");

        // Enable the descriptor (web.xml) and other configurations.
        webapp.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        webapp.setParentLoaderPriority(true);

        // Set the WebAppContext as the handler for the server.
        server.setHandler(webapp);

        // Start the server and wait for it to join.
        server.start();
        System.out.println("Server started at http://localhost:8081/VideoServlent");
        server.join();
    }
}
