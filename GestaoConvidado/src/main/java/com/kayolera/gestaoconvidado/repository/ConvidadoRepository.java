package com.kayolera.gestaoconvidado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayolera.gestaoconvidado.model.Convidado;

@Repository
public interface ConvidadoRepository  extends JpaRepository<Convidado,Long> {

}
