package com.example.SinauKodingTask5.service;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.Pinjam;
import com.example.SinauKodingTask5.repository.AnggotaRepository;
import com.example.SinauKodingTask5.repository.BukuRepository;
import com.example.SinauKodingTask5.repository.PinjamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinjamService {
    @Autowired
    PinjamRepository pinjamRepository;

    @Autowired
    AnggotaRepository anggotaRepository;

    @Autowired
    BukuRepository bukuRepository;

    //Create
    public Pinjam createPinjam(Pinjam param){
        return pinjamRepository.save(param);

    }

    //Read
    public List<Pinjam> selectAllPinjam(){
        return pinjamRepository.findAll();
    }

    //Update
    public Pinjam updatePinjamById(Pinjam pinjam, int id){
        Pinjam reference = pinjamRepository.findById(id).get();
        reference.setAnggota(pinjam.getAnggota()!=null?pinjam.getAnggota():reference.getAnggota());
        reference.setBuku(pinjam.getBuku()!=null?pinjam.getBuku():reference.getBuku());
        reference.setTglPinjam(pinjam.getTglPinjam()!=null?pinjam.getTglPinjam():reference.getTglPinjam());
        reference.setTglKembali(pinjam.getTglKembali()!=null?pinjam.getTglKembali():reference.getTglKembali());
        return pinjamRepository.save(reference);
    }

    //Delete
    public Boolean deletePinjamById(int id){
        Pinjam reference = pinjamRepository.findById(id).orElse(null);
        if(reference != null){
            pinjamRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

}
