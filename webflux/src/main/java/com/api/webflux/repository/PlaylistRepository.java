package com.api.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.webflux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{
	
}
