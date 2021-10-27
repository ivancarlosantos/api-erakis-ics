package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;

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
			throw new RuntimeException("ERROR: Pessoa Física não cadastrada - CPF já existente");
		}
		return pessoaFisicaRepository.save(pf);
	}

	public List<PessoaFisica> findPFAll() {
		List<PessoaFisica> listAll = pessoaFisicaRepository.findAll(Sort.by("nome"));
		if (listAll == null || listAll.isEmpty()) {
			throw new RuntimeException("Nenhuma Pessoa Física encontrada");
		}

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

	public PessoaFisica updatePessoaFisica(Long psfis_id, PessoaFisica pf) {
		PessoaFisica pessoaFisica = findPFByID(psfis_id);
		pessoaFisica.setNome(pf.getNome());
		pessoaFisica.setSexo(pf.getSexo());
		pessoaFisica.setDataNascimento(pf.getDataNascimento());
		pessoaFisica.setEstadoCivil(pf.getEstadoCivil());
		pessoaFisica.setCpf(pf.getCpf());
		pessoaFisica.setRg(pf.getRg());
		pessoaFisica.setCnh(pf.getCnh());
		pessoaFisica.setOrgaoEmissorRg(pf.getOrgaoEmissorRg());
		pessoaFisica.setOrgaoEmissorCnh(pf.getOrgaoEmissorCnh());
		pessoaFisica.setObservacao(pf.getObservacao());
		pessoaFisica.setProfissao(pf.getProfissao());
		pessoaFisica.setParceiroDesde(pf.getParceiroDesde());

		return pessoaFisicaRepository.save(pessoaFisica);
	}

	public void deletePessoaFisica(Long psfis_id, PessoaFisica pf) {
		Optional<PessoaFisica> findPFByID = pessoaFisicaRepository.findById(psfis_id);
        
		PessoaFisicaDTO pfDTO = new PessoaFisicaDTO(findPFByID.get());
		if ((pfDTO.getPsfis_id() == null) || psfis_id < 0) {
			throw new RuntimeException("Pessoa jurídica com ID = [" + psfis_id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		pessoaFisicaRepository.deleteById(pfDTO.getPsfis_id());
	}
}