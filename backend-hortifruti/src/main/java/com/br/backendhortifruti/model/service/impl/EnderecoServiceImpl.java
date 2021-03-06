package com.br.backendhortifruti.model.service.impl;

import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.repository.EnderecoRepository;
import com.br.backendhortifruti.model.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> consultarEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco incluirEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco consultarEndereco(Integer enderecoId) {
        Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
        return endereco.orElse(null);
    }

    @Override
    public Endereco alterarEndereco(Integer enderecoId, Endereco endereco) {
        if(enderecoRepository.findById(enderecoId).isPresent()) {
            Endereco enderecoExistente = enderecoRepository.findById(enderecoId).get();
            enderecoExistente.setCep(endereco.getCep());
            enderecoExistente.setLogradouro(endereco.getLogradouro());
            enderecoExistente.setNumero(endereco.getNumero());
            enderecoExistente.setComplemento(endereco.getComplemento());            
            enderecoExistente.setLocalidade(endereco.getLocalidade());            
            enderecoExistente.setBairro(endereco.getBairro());
            enderecoExistente.setUf(endereco.getUf());
            
            enderecoRepository.save(enderecoExistente);
            return enderecoExistente;
        }
        return null;
    }

    @Override
    public void excluirEndereco(Integer enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }
}
