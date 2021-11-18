package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.PessoaJuridicaDTO;
import com.erakis_ics.api.entity.PessoaJuridica;
import com.erakis_ics.api.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaServices {

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	public PessoaJuridica savePessoaJuridica(PessoaJuridica pj) {
		Optional<PessoaJuridicaDTO> findCNPJ = pessoaJuridicaRepository.findByCnpj(pj.getCnpj());
		if (findCNPJ.isPresent()) {
			throw new RuntimeException("CNPJ já Existe - Pessoa Jurídica não foi cadastrada");
		}

		return pessoaJuridicaRepository.save(pj);
	}

	public List<PessoaJuridicaDTO> findPJAll() {
		
		List<PessoaJuridicaDTO> listAll = pessoaJuridicaRepository
				 					      .findAll(Sort.by("nomeFantasia"))
				 					      .stream()
				 					      .map(pjDTO -> new PessoaJuridicaDTO(pjDTO))
				 					      .collect(Collectors.toList());
		return listAll;
	}

	public Optional<PessoaJuridicaDTO> findPJByCNPJ(String cnpj) {
		Optional<PessoaJuridicaDTO> findCNPJ = pessoaJuridicaRepository.findByCnpj(cnpj);
	
		if (findCNPJ.isPresent()) {
		} else {
			throw new RuntimeException("CNPJ não encontrado");
		}
		return findCNPJ;
	}

	public Optional<PessoaJuridicaDTO> findPJByRazaoSocial(String razaoSocial) {
		Optional<PessoaJuridicaDTO> findRazaoSocial = pessoaJuridicaRepository.findByRazaoSocial(razaoSocial);
		if (findRazaoSocial.isPresent()) {
			return findRazaoSocial;
		} else {
			throw new RuntimeException("Razão Social não encontrada");
		}
	}

	public Optional<PessoaJuridicaDTO> findPJByNomeFantasia(String nomeFantasia) {
		Optional<PessoaJuridicaDTO> findNomeFantasia = pessoaJuridicaRepository.findByNomeFantasia(nomeFantasia);
		if (findNomeFantasia.isPresent()) {
			return findNomeFantasia;
		} else {
			throw new RuntimeException("Nome Fantasia não encontrado");
		}
	}

	public PessoaJuridica findPJByID(Long psjur_id) {
		Optional<PessoaJuridica> findByID = pessoaJuridicaRepository.findById(psjur_id);
		PessoaJuridica pessJur = null;
		if (!findByID.isPresent()) {
			throw new RuntimeException("Pessoa jurídica com ID = [" + psjur_id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		pessJur = findByID.get();

		return pessJur;
	}

	public PessoaJuridica updatePessoaJuridica(Long psjur_id, PessoaJuridicaDTO pjDTO) {

		PessoaJuridica pessoaJuridica = findPJByID(psjur_id);
		pessoaJuridica.setCnpj(pjDTO.getCnpj());
		pessoaJuridica.setCodigoSuframa(pjDTO.getCodigoSuframa());
		pessoaJuridica.setInscricaoEstadual(pjDTO.getInscricaoEstadual());
		pessoaJuridica.setInscricaoMunicipal(pjDTO.getInscricaoMunicipal());
		pessoaJuridica.setNomeFantasia(pjDTO.getNomeFantasia());
		pessoaJuridica.setRazaoSocial(pjDTO.getRazaoSocial());
		pessoaJuridica.setSistemaTributario(pjDTO.getSistemaTributario());
		pessoaJuridica.setSite(pjDTO.getSite());

		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public void deletePessoaJuridica(Long psjur_id, PessoaJuridicaDTO pjDTO) {

		if ((pjDTO.getPsjur_id() == null || psjur_id < 0)) {
			throw new RuntimeException("Pessoa Jurídica de ID = [" + psjur_id + "]" + HttpStatus.NOT_FOUND + " ");
		}

		pessoaJuridicaRepository.deleteById(pjDTO.getPsjur_id());
	}
}
