package com.clinicsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicsystem.models.Paciente;
import com.clinicsystem.repositories.PacienteRepository;


@Service
public class PacienteService {
	
	 @Autowired
	    private PacienteRepository PacienteRepository;

	    public void salvar(Paciente paciente){
	        PacienteRepository.save(paciente);
	    }

	    public Paciente buscarPorId(int id){
	        return PacienteRepository.findById(id).orElse(null);
	    }

	    public List<Paciente> buscarTodos(){
	        return PacienteRepository.findAll();
	    }


	    public void excluir(int id){
	        PacienteRepository.deleteById(id);
	    }

	    public Page<Paciente> buscarPaginado(Pageable pageable)
	    {
	        return PacienteRepository.findAll(pageable);
	    }

	    public Page<Paciente> buscarPorRegistro(Pageable pageable, int id){

	        try{
	            return PacienteRepository.findById(pageable, id);
	        }catch(Exception e){
	            return PacienteRepository.findAll(pageable);
	        }

	    }

	    public Page<Paciente> buscarPornome(Pageable pageable, String nome){return PacienteRepository.findByNomeLike(pageable, "%" + nome + "%");}

		public Object buscarPornome(PageRequest of, Paciente nome) {
			// TODO Auto-generated method stub
			return null;
		}


}
