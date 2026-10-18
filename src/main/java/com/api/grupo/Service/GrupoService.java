package com.api.grupo.Service;

import com.api.grupo.Entidade.Grupo;
import com.api.grupo.Repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public Grupo salvarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }// metodo para salvar

    public Page<Grupo> listarGrupos(String filtro) {
        if (filtro == null) {
            filtro = "";
        }
        Page<Grupo> grupos = grupoRepository.listarPorNome(
                filtro.trim(),
                PageRequest.of(0, 10)
        );
        return grupos;
    } // lista os nomes em orde alfabetica em ate 10

    public Grupo buscarGrupoPorId(Long id) {
        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Grupo não encontrado!")
                );

        return grupo;
    }// metodo q faz a busca pelo id

    public void deletarGrupoPorId(Long id) {
        grupoRepository.deleteById(id);
    } // metodo para excluir, busca pelo id

    public Grupo atualizarGrupoPorId(Long id, Grupo grupo) {
        Grupo grupoSalvo = buscarGrupoPorId(id);
        BeanUtils.copyProperties(grupo, grupoSalvo, "id");
        return grupoRepository.save(grupoSalvo);
    } // metodo q faz o update preservando os dados q nn foram alterado


}
