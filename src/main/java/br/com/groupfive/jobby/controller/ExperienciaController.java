package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.IExperienciaController;
import br.com.groupfive.jobby.dto.experiencia.CreateExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.ExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.UpdateExperienciaDTO;
import br.com.groupfive.jobby.service.interfaces.IExperienciaService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController implements IExperienciaController<Integer> {
    private final IExperienciaService<Integer> service;

    public ExperienciaController(IExperienciaService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaDTO> findById(@PathVariable("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<ExperienciaDTO> create(@RequestBody CreateExperienciaDTO createExperienciaDTO) {
        var dto = service.create(createExperienciaDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    //TODO Analisar método
    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(
        @RequestBody UpdateExperienciaDTO updateExperienciaDTO,
        @PathVariable("id") Integer id
    ) {
        var updated = service.update(updateExperienciaDTO, id);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
