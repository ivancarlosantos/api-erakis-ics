package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.PessoaFisicaDTO;
import com.erakis_ics.api.entity.PessoaFisica;
import com.erakis_ics.api.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaServices {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	public PessoaFisica savePessoaFisica(PessoaFisica pf) {
		Optional<PessoaFisica> findCPF = pessoaFisicaRepository.findByCpf(pf.getCpf());
		if (findCPF.isPresent()) {
			throw new RuntimeException("CPF já existente - Pessoa Física não foi cadastrada");
		}
		return pessoaFisicaRepository.save(pf);
	}

	public List<PessoaFisicaDTO> findPFAll() {
		List<PessoaFisicaDTO> listAll = pessoaFisicaRepository
									 .findAll(Sort.by("nome"))
									 .stream()
									 .map(pfDTO -> new PessoaFisicaDTO(pfDTO))
									 .collect(Collectors.toList());
		
		return listAll;
	}

	public Optional<PessoaFisica> findPFByNome(String nome) {
		Optional<PessoaFisica> findPFNome = pessoaFisicaRepository.findByNome(nome);
		if (findPFNome.isPresent()) {
			return findPFNome;
		} else {
			throw new RuntimeException("Nome não encontrado");
		}
	}

	public Optional<PessoaFisica> findPFByCPF(String cpf) {
		Optional<PessoaFisica> findPFCPF = pessoaFisicaRepository.findByCpf(cpf);
		if (findPFCPF.isPresent()) {
			return findPFCPF;
		} else {
			throw new RuntimeException("CPF não encontrado");
		}
	}

	public PessoaFisica findPFByID(Long psfis_id) {
		Optional<PessoaFisica> findByID = pessoaFisicaRepository.findById(psfis_id);
		PessoaFisica pessFis = null;
		if (!findByID.isPresent()) {
			throw new RuntimeException("Pessoa jurídica com ID = [" + psfis_id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		pessFis = findByID.get();

		return pessFis;
	}

	public PessoaFisica updatePessoaFisica(Long psfis_id, PessoaFisicaDTO pfDTO) {
		PessoaFisica pessoaFisica = findPFByID(psfis_id);
		pessoaFisica.setNome(pfDTO.getNome());
		pessoaFisica.setSexo(pfDTO.getSexo());
		pessoaFisica.setDataNascimento(pfDTO.getDataNascimento());
		pessoaFisica.setCpf(pfDTO.getCpf());
		pessoaFisica.setRg(pfDTO.getRg());
		pessoaFisica.setOrgaoEmissorRg(pfDTO.getOrgaoEmissorRg());
		return pessoaFisicaRepository.save(pessoaFisica);
	}

	public void deletePessoaFisica(Long psfis_id, PessoaFisicaDTO pfDTO) {
		 
		if ((pfDTO.getPsfis_id() == null) || psfis_id < 0) {
			throw new RuntimeException("Pessoa Física com ID = [" + psfis_id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		pessoaFisicaRepository.deleteById(pfDTO.getPsfis_id());
	}
	
	/*
	 * private void findByEmail(UserDTO obj) { Optional<User> user =
	 * repository.findByEmail(obj.getEmail()); if(user.isPresent() &&
	 * !user.get().getId().equals(obj.getId())) { throw new
	 * DataIntegratyViolationException("E-mail já cadastrado no sistema"); }
	 */
}