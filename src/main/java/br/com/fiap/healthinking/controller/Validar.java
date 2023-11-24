package br.com.fiap.healthinking.controller;

import br.com.fiap.healthinking.model.entity.Cliente;
import br.com.fiap.healthinking.model.repository.ClienteRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/validar")
public class Validar {

	@GET
	public Response validateUser(@QueryParam("usuario")String user, @QueryParam("senha")String password) {
		try {
            Cliente cliente = ClienteRepository.findClienteByUser(user);
            System.out.println(cliente);
            
            if (password.equals(cliente.getSenhaCliente())) {
                return Response.ok().entity("{\"success\": true}").build();
            } else {
                return Response.ok().entity("{\"success\": false, \"message\": \"Invalid password\"}").build();
            }
        } catch (Exception e) {
            return Response.ok().entity("{\"success\": false, \"message\": \"Error: " + e.getMessage() + "\"}").build();
        }
	}
	
}
