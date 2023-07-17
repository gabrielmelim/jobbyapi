package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.IEnderecoController;
import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import br.com.groupfive.jobby.service.interfaces.IEnderecoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("/cadastro/endereco")
public class EnderecoController implements IEnderecoController<Integer> {

    private final IEnderecoService<Integer> service;

    public EnderecoController(IEnderecoService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

//    @Override
//    @PostMapping
//    public ResponseEntity<EnderecoDTO> create(@RequestBody CreateEnderecoDTO createEnderecoDTO) {
//        var dto = service.create(createEnderecoDTO);
//        return isNull(dto) ? unaprocessableEntity() : created(dto);
//    }

    //TODO Analisar método
    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(
        @RequestBody UpdateEnderecoDTO updateEnderecoDTO,
        @PathVariable("id") Integer id
    ) {
        var updated = service.update(updateEnderecoDTO, id);
        return updated ? noContent(null) : notFound();
    }

//    @Override
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
//        var deleted = service.deleteById(id);
//        return deleted ? noContent(null) : notFound();
//    }
}
