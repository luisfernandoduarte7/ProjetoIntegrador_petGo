package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.Especialidade;
import com.pet.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	
	private final EspecialidadeRepository EspecialidadeRepository;

	@Autowired
	public EspecialidadeService(EspecialidadeRepository EspecialidadeRepository) {
		this.EspecialidadeRepository = EspecialidadeRepository;
	}

	public List<Especialidade> buscaTodosEspecialidade(){
		return EspecialidadeRepository.findAll();
	}
	 //@query
	public List<Especialidade> buscaPorNome(String nome) {
		return EspecialidadeRepository.findByNome(nome);
	} 
	
	public Especialidade buscaEspecialidadeId (Long id) {
		Optional <Especialidade> Especialidade = EspecialidadeRepository.findById(id);
		return Especialidade.orElse(null);			
	}
	
	
		
	public Especialidade salvaEspecialidade(Especialidade Especialidade) {
		return EspecialidadeRepository.save(Especialidade);
	}

		
	public Especialidade alterarEspecialidade(Long id, Especialidade alterarEspecialidade) {
		Optional <Especialidade> existeEspecialidade = EspecialidadeRepository.findById(id);
		if (existeEspecialidade.isPresent()) {
			alterarEspecialidade.setId(id);
			return EspecialidadeRepository.save(alterarEspecialidade);
		}
		return null;
	}

	public boolean apagarEspecialidade(Long id) {
		Optional <Especialidade> existeEspecialidade = EspecialidadeRepository.findById(id);
		if (existeEspecialidade.isPresent()) {
			EspecialidadeRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}