package com.spring.docker.github01.repositories;

import com.spring.docker.github01.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutoRepository extends JpaRepository<Producto,Integer> {
}
