package com.api.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.api.webflux.document.Playlist;
import com.api.webflux.services.PlaylistService;

import reactor.core.publisher.Mono;

public class PlaylistHandler {
	@Autowired
	PlaylistService service;
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Playlist.class);
	}
	
	private Object ok() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ((Object) ok())
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		return ((Object) ok())
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(service::save), Playlist.class));
	}

	private Object fromPublisher(Mono<Playlist> flatMap, Class<Playlist> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
