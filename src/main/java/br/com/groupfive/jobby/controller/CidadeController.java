package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.ICidadeController;
import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.cidade.CreateCidadeDTO;
import br.com.groupfive.jobby.dto.cidade.UpdateCidadeDTO;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.service.interfaces.ICidadeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static br.com.groupfive.jobby.utils.ResponseEntityUtils.created;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("cidade")
@CrossOrigin("*")
public class CidadeController implements ICidadeController<Integer> {

    private final ICidadeService<Integer> service;

    public CidadeController(ICidadeService<Integer> service) {
        this.service = service;
    }


    @GetMapping()
    @Override
    public ResponseEntity<List<CidadeDTO>> findAll() {
        List<CidadeDTO> listDto = service.findAll();
        return listDto.isEmpty() ? notFound() : ok(listDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathVariable("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<CidadeDTO> create(@RequestBody CreateCidadeDTO createCidadeDTO) {
        var dto = service.create(createCidadeDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(
        @RequestBody UpdateCidadeDTO updateCidadeDTO,
        @PathVariable("id") Integer id
    ) {
        var updated = service.update(updateCidadeDTO, id);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
