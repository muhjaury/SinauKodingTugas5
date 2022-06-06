package com.example.SinauKodingTask5.service;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    AnggotaRepository anggotaRepository;

    //Create
    public Anggota createAnggota(Anggota anggota){
        return anggotaRepository.save(anggota);
    }

    //Read
    public List<Anggota> selectAllAnggota(){
        return anggotaRepository.findAll();
    }

    public List<Anggota> findByNama(String nama){
        return anggotaRepository.findByNamaContaining(nama);
    }

    //Update
    public Anggota updateAnggotaById(Anggota anggota, int id){
        Anggota reference = anggotaRepository.findById(id).get();
        reference.setNama(anggota.getNama()!=null?anggota.getNama():reference.getNama());
        reference.setAlamat(anggota.getAlamat()!=null?anggota.getAlamat():reference.getAlamat());
        reference.setNoTelp(anggota.getNoTelp()!=null?anggota.getNoTelp():reference.getNoTelp());
        reference.setTglLahir(anggota.getTglLahir()!=null?anggota.getTglLahir():reference.getTglLahir());
        reference.setJenisKelamin(anggota.getJenisKelamin()!=null?anggota.getJenisKelamin(): reference.getJenisKelamin());
        return anggotaRepository.save(reference);
    }

    //Delete
    public Boolean deleteAnggotaById(int id){
        Anggota reference = anggotaRepository.findById(id).orElse(null);
        if(reference != null){
            anggotaRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }
}
