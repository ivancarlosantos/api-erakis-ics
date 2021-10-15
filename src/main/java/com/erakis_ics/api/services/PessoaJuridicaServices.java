package com.erakis_ics.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.entity.PessoaJuridica;
import com.erakis_ics.api.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaServices {

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	public PessoaJuridica savePessoaJuridica(PessoaJuridica pj) {
		List<PessoaJuridica> findCNPJ = pessoaJuridicaRepository.findByCnpj(pj.getCnpj());
		if (findCNPJ.size() > 0) {
			throw new RuntimeException("ERROR: Pessoa Jurídica não cadastrada - CNPJ já Existe");
		}

		return pessoaJuridicaRepository.save(pj);
	}

	public List<PessoaJuridica> findPJAll() {
		List<PessoaJuridica> listAll = pessoaJuridicaRepository.findAll(Sort.by("nomeFantasia"));
		if (listAll == null) {
			throw new RuntimeException("Nenhuma Pessoa Jurídica encontrada");
		}

		return listAll;
	}

	public List<PessoaJuridica> findPJByCNPJ(String psjur_cnpj) {
		List<PessoaJuridica> findCNPJ = pessoaJuridicaRepository.findByCnpj(psjur_cnpj);
		if (findCNPJ.size() > 0) {

		} else {
			throw new RuntimeException("CNPJ não encontrado");
		}

		return findCNPJ;
	}

	public Optional<PessoaJuridica> findPJByRazaoSocial(String razaoSocial) {
		Optional<PessoaJuridica> findByRazaoSocial = pessoaJuridicaRepository.findByRazaoSocial(razaoSocial);
		if (findByRazaoSocial.isPresent()) {
		} else {
			throw new RuntimeException("Razão Social não encontrada");
		}

		return findByRazaoSocial;
	}

	public Optional<PessoaJuridica> findPJByNomeFantasia(String nomeFantasia) {
		Optional<PessoaJuridica> findByNomeFantasia = pessoaJuridicaRepository.findByNomeFantasia(nomeFantasia);
		if (findByNomeFantasia.isPresent() || nomeFantasia.contains(findByNomeFantasia.toString())) {
			//
		} else {
			throw new RuntimeException("Nome Fantasia não encontrado");
		}

		return findByNomeFantasia;
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

	public PessoaJuridica updatePessoaJuridica(Long psjur_id, PessoaJuridica pj) {

		PessoaJuridica pessoaJuridica = findPJByID(psjur_id);
		pessoaJuridica.setCnpj(pj.getCnpj());
		pessoaJuridica.setCodigoSuframa(pj.getCodigoSuframa());
		pessoaJuridica.setInscricaoEstadual(pj.getInscricaoEstadual());
		pessoaJuridica.setInscricaoMunicipal(pj.getInscricaoMunicipal());
		pessoaJuridica.setNomeFantasia(pj.getNomeFantasia());
		pessoaJuridica.setRazaoSocial(pj.getRazaoSocial());
		pessoaJuridica.setSistemaTributario(pj.getSistemaTributario());
		pessoaJuridica.setSite(pj.getSite());

		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public PessoaJuridica deletePessoaJuridica(Long psjur_id, PessoaJuridica pj) {

		Optional<PessoaJuridica> listPJ = pessoaJuridicaRepository.findById(psjur_id);
		if ((pj.getPsjur_id() == null || psjur_id < 0) || (listPJ.isEmpty() || !listPJ.isPresent())) {
			throw new RuntimeException("Pessoa Jurídica de ID [" + psjur_id + "] não excluída e/ou não encontrada");
		}
		pessoaJuridicaRepository.deleteById(psjur_id);

		return pj;
	}

	public HttpStatus getStatus() {
		return HttpStatus.CREATED;
	}

	public Date TimeSession() {
		// Integer TIME_EXPIRED = 600_000;
		return new Date(System.currentTimeMillis());
	}
}
