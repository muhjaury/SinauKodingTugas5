package com.example.SinauKodingTask5.repository;

import com.example.SinauKodingTask5.entity.Pinjam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PinjamRepository extends JpaRepository<Pinjam, Integer> {
    Integer countByIdPinjam(Integer integer);
    List<Pinjam> findByIdPinjam(Integer integer);
}
