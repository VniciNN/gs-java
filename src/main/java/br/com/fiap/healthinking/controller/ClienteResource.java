package br.com.fiap.healthinking.controller;

import java.util.ArrayList;

import br.com.fiap.healthinking.model.entity.Cliente;
import br.com.fiap.healthinking.model.repository.ClienteRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/")
public class ClienteResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cliente")
	public Response findAll() {
		ArrayList<Cliente> resposta = ClienteRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user/{userCliente}")
	public Response findClienteByUser(@PathParam("userCliente") String userCliente) {
		if(ClienteRepository.findClienteByUser(userCliente) != null) {
			Cliente resposta = ClienteRepository.findClienteByUser(userCliente);
			ResponseBuilder response = Response.ok();
			response.entity(resposta);
			return response.build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cadastro")
	public Response save(@Valid Cliente cliente) {
		Cliente resposta = ClienteRepository.save(cliente);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); // 201 - Created
		} else {
			response = Response.status(400); // 400 - Bad Request
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("cliente/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (ClienteRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/bmi")
	public Response update(@Valid Cliente cliente) {
		Cliente resposta = ClienteRepository.update(cliente);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
}