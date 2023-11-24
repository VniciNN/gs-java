package br.com.fiap.healthinking.controller;

import java.util.ArrayList;

import br.com.fiap.healthinking.model.entity.SonoDiario;
import br.com.fiap.healthinking.model.repository.SonoDiarioRepository;
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
public class SonoDiarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("sonos")
	public Response findAll() {
		ArrayList<SonoDiario> resposta = SonoDiarioRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("sonos/{idCliente}")
	public Response findByIdCliente(@PathParam("idCliente") Long idCliente) {
		ArrayList<SonoDiario> resposta = SonoDiarioRepository.findByIdCliente(idCliente);
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("sono")
	public Response save(@Valid SonoDiario sonoDiario) {
		SonoDiario resposta = SonoDiarioRepository.save(sonoDiario);
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
	@Path("sonos/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (SonoDiarioRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("sono")
	public Response update(@Valid SonoDiario sonoDiario) {
		SonoDiario resposta = SonoDiarioRepository.update(sonoDiario);
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