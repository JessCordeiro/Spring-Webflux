package com.api.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.webflux.document.Playlist;
import com.api.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner {

	
	private final PlaylistRepository playlistRepository;

	DummyData(PlaylistRepository playlistRepository) {
       this.playlistRepository = playlistRepository;
    }

	@Override
    public void run(String... args) throws Exception {

   	playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("Orgulho e Preconceito", "Dom Quixote de la Mancha", "O Pequeno Príncipe ",
                                "Dom Casmurro", "O Bandolim do Capitão Corelli", "O Conde de Monte Cristo")
                                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }

}
