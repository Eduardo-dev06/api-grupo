package com.api.grupo.Controller;

import com.api.grupo.Entidade.Grupo;
import com.api.grupo.Service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoController {

    private final GrupoService grupoService;

    @PostMapping("/salvar-grupo")
    public Grupo salvar(@RequestBody Grupo grupo){
        return grupoService.salvarGrupo(grupo);
    }// metodo para salvar

    @GetMapping("/listar-grupos")
    public Page<Grupo> listarGrupos(
            @RequestParam(defaultValue = "") String filtro) {
        return grupoService.listarGrupos(filtro);
    }// metodo para lista todos obejtos da tabela Grupo

    @GetMapping("/buscar-grupo/{id}")
    public Grupo buscarGrupoPorId(@PathVariable Long id) {
        return grupoService.buscarGrupoPorId(id);
    }// para buscar pelo id

    @DeleteMapping("/deletar-grupo/{id}")
    public void deletarGrupoPorId(@PathVariable Long id) {
        grupoService.deletarGrupoPorId(id);
    } // deleta o objeto grupo pelo id

    @PutMapping("/atualizar-grupo/{id}")
    public Grupo atualizarGrupo(
            @PathVariable Long id,
            @RequestBody Grupo grupo) {
        return grupoService.atualizarGrupoPorId(id, grupo);
    } // atualizar um gurpo

}
