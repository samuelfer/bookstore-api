package com.marhasoft.bookstore.services;

import com.marhasoft.bookstore.domain.Igreja;
import com.marhasoft.bookstore.dtos.IgrejaDTO;
import com.marhasoft.bookstore.exceptions.DataIntegrityViolationException;
import com.marhasoft.bookstore.exceptions.ObjectNotFoundException;
import com.marhasoft.bookstore.repositories.IgrejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IgrejaService {

    @Autowired
    private IgrejaRepository igrejaRepository;

    public Igreja findById(Integer id) {
        Optional<Igreja> igreja = this.igrejaRepository.findById(id);
        return igreja.orElseThrow(() -> new ObjectNotFoundException("Igreja não encontrada! id "+id+", Tipo: "+Igreja.class.getName()));
    }

    public List<Igreja> getAll() {
        return this.igrejaRepository.findAll();
    }

    public Igreja create(Igreja igreja) {
        igreja.setId(null);
        return this.igrejaRepository.save(igreja);
    }

    public Igreja update(Integer id, IgrejaDTO igrejaDTO) {
        Igreja igreja = findById(id);
        igreja.setNome(igrejaDTO.getNome());
        igreja.setTelefone(igrejaDTO.getTelefone());
        igreja.setEmail(igrejaDTO.getEmail());
        igreja.setLocalidade(igrejaDTO.getLocalidade());
        return this.igrejaRepository.save(igreja);
    }

    public void excluir(Integer id) {
        findById(id);
        try {
            this.igrejaRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException exception) {
            throw new DataIntegrityViolationException("Igreja não pode ser deletada");
        }
    }
}
