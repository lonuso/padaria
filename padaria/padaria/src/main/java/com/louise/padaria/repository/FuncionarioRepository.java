package com.louise.padaria.repository;

import com.louise.padaria.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository -> anotação responsavel por identificar uma classe que faz comunicação com banco
@Repository
//extends -> indica uma herança, quer dizer que estou recebendo todos os metodos que tem no JPA repository
//JpaRepository -> interface de metodos padrão que traduzem do Java para o SQL. <tipo entidade, tipo identificador>
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {
}
