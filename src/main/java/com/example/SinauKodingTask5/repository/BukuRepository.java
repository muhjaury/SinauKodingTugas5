package com.example.SinauKodingTask5.repository;

import com.example.SinauKodingTask5.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    List<Buku> findByNamaOrPenulisContaining(String nama, String penulis);
}
