package com.api.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.webflux.document.Playlist;
import com.api.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository pr;

	@Override
	public Flux<Playlist> findAll() {
		return pr.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return pr.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return pr.save(playlist);
	}

}
