package com.example.SinauKodingTask5.repository;

import com.example.SinauKodingTask5.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnggotaRepository extends JpaRepository<Anggota,Integer> {
    List<Anggota> findByNamaContaining(String nama);
}
