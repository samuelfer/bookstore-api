package com.marhasoft.bookstore.repositories;

import com.marhasoft.bookstore.domain.Igreja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrejaRepository extends JpaRepository<Igreja, Integer> {
}
