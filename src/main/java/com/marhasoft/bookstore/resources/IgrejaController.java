package com.marhasoft.bookstore.resources;

import com.marhasoft.bookstore.domain.Igreja;
import com.marhasoft.bookstore.dtos.IgrejaDTO;
import com.marhasoft.bookstore.services.IgrejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/igrejas")
public class IgrejaController {

    @Autowired
    private IgrejaService igrejaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Igreja> findById(@PathVariable Integer id) {
        Igreja igreja = this.igrejaService.findById(id);
        return ResponseEntity.ok().body(igreja);
    }

    @GetMapping
    public ResponseEntity<List<IgrejaDTO>> getAll() {
        List<Igreja> igrejas = this.igrejaService.getAll();
        List<IgrejaDTO> listDTO = igrejas.stream().map(obj -> new IgrejaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Igreja> create(@Valid @RequestBody Igreja igreja) {
        igreja = this.igrejaService.create(igreja);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(igreja.getId()).toUri();
        return ResponseEntity.created(uri).body(igreja);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<IgrejaDTO> update(@PathVariable Integer id, @Valid @RequestBody IgrejaDTO igrejaDTO) {
        Igreja igreja = this.igrejaService.update(id, igrejaDTO);
        return ResponseEntity.ok().body(new IgrejaDTO(igreja));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.igrejaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
