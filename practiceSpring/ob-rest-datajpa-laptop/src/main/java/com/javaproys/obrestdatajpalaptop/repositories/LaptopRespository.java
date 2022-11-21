package com.javaproys.obrestdatajpalaptop.repositories;

import com.javaproys.obrestdatajpalaptop.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRespository extends JpaRepository<Laptop, Long> {
}
