package com.t2m.gestao.service;

import com.t2m.gestao.model.Endereco;
import com.t2m.gestao.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Optional<Endereco> atualizarEndereco(Long id, Endereco endereco) {
        if (enderecoRepository.existsById(id)) {
            endereco.setId(id);
            return Optional.of(enderecoRepository.save(endereco));
        }
        return Optional.empty();
    }

    public boolean deletarEndereco(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}