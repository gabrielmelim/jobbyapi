package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.IProfissaoController;
import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import br.com.groupfive.jobby.service.interfaces.IProfissaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("profissao")
@CrossOrigin("*")
public class ProfissaoController implements IProfissaoController<Integer> {

    private final IProfissaoService<Integer> service;

    public ProfissaoController(IProfissaoService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<ProfissaoDTO>> findAll() {
        List<ProfissaoDTO> listDto = service.findAll();
        return listDto.isEmpty() ? notFound() : ok(listDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfissaoDTO> findById(@PathVariable Integer id) {
        ProfissaoDTO dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<ProfissaoDTO> create(@RequestBody CreateProfissaoDTO createProfissaoDTO) {
        ProfissaoDTO dto = service.create(createProfissaoDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        boolean deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
