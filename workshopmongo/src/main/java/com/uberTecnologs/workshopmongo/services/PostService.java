package com.uberTecnologs.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uberTecnologs.workshopmongo.domain.Post;
import com.uberTecnologs.workshopmongo.repository.PostRepository;
import com.uberTecnologs.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repo.findyByTitle(text);
	}
	
	public List<Post> fullConsulta(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 20*60*60*1000);
		return repo.FullConsulta(text, minDate, maxDate);
	}
}
