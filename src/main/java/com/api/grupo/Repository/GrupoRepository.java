package com.api.grupo.Repository;

import com.api.grupo.Entidade.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    // essas anotacoes sera feitas para deixa explicado exatamente o que esta sendo desenvolvido no metodo

    //o Query seginifica "Pesquisa"
    @Query("""
        SELECT g
        FROM Grupo g
        WHERE LOWER(g.nome) LIKE LOWER(CONCAT(:filtro, '%'))
        ORDER BY g.nome ASC
    """)
    // nesse pesquisa ele puxa todos objetos da tabela Grupo(apelidado por g)
    // o Where aplica a condicao do filtro enquanto o lower converte para minusculo, o Comcat junto o filtro com a % q sera a pesquisa do filtro
    // e o Order by serve para ordena em forma alfabetica  :>

    Page<Grupo> listarPorNome(
            @Param("filtro") String filtro,
            Pageable pageable
    );
    // essa parte representa a pagina de pesquisa dos resultados, e quantos registros vao retorna

}
