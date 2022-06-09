package com.example.SinauKodingTask5.service;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.dto.AnggotaDTO;
import com.example.SinauKodingTask5.entity.mapping.AnggotaMapping;
import com.example.SinauKodingTask5.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    AnggotaRepository anggotaRepository;

    //Create
    public AnggotaDTO createAnggota(AnggotaDTO data){
        Anggota anggota = anggotaRepository.save(AnggotaMapping.INSTANCE.toEntity(data));
        return AnggotaMapping.INSTANCE.toDTO(anggota);
    }

    //Read
//    Without DTO
//    public List<Anggota> selectAllAnggota(){
//        return anggotaRepository.findAll();
//    }
    public List<AnggotaDTO> selectAllAnggota(){
        return AnggotaMapping.INSTANCE.toAnggotaDTOList(anggotaRepository.findAll());
    }

    public List<AnggotaDTO> findByNama(String nama){
        return AnggotaMapping.INSTANCE.toAnggotaDTOList(anggotaRepository.findByNamaContaining(nama));
    }

    //Update
    public Anggota updateAnggotaById(Anggota anggota){ //Update ID in Body, not in PathVariable
        Anggota reference = anggotaRepository.findById(anggota.getIdAnggota()).get();
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

    public Integer countByNamaContaining(String string){
        if(string != null){
            return anggotaRepository.countByNamaContaining(string);
        }
        return (int) anggotaRepository.count();
    }
}
