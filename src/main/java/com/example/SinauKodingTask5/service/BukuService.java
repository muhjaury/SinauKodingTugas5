package com.example.SinauKodingTask5.service;

import com.example.SinauKodingTask5.entity.Buku;
import com.example.SinauKodingTask5.entity.dto.BukuDTO;
import com.example.SinauKodingTask5.entity.mapping.BukuMapping;
import com.example.SinauKodingTask5.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BukuService {

    @Autowired
    BukuRepository bukuRepository;

    //Create
    public BukuDTO createBuku(BukuDTO data){
        Buku buku = bukuRepository.save(BukuMapping.INSTANCE.toEntity(data));
        return BukuMapping.INSTANCE.toDTO(buku);
    }

    //Read
    public List<BukuDTO> findAllBuku(){
        return BukuMapping.INSTANCE.toBukuDTOList(bukuRepository.findAll());
    }

    public List<BukuDTO> findByJudulContainingAndPenulisContaining(String judul, String penulis){
        return BukuMapping.INSTANCE.toBukuDTOList(bukuRepository.findByJudulContainingAndPenulisContaining(judul, penulis));
    }

    //Update
    public BukuDTO updateBukuById(BukuDTO data, int id){
        Buku reference = bukuRepository.findById(id).get();
        reference.setJudul(data.getJudul()!=null?data.getJudul():reference.getJudul());
        reference.setPenulis(data.getPenulis()!=null?data.getPenulis():reference.getPenulis());
        reference.setPenerbit(data.getPenerbit()!=null?data.getPenerbit():reference.getPenerbit());
        reference.setTahunTerbit(data.getTahunTerbit()!=null?data.getTahunTerbit():reference.getTahunTerbit());
        reference.setJenisBuku(data.getJenisBuku()!=null?data.getJenisBuku():reference.getJenisBuku());
        return BukuMapping.INSTANCE.toDTO(bukuRepository.save(reference));
    }

    //Delete
    public Boolean deleteBukuById(int id){
        Buku reference = bukuRepository.findById(id).orElse(null);
        if(reference != null){
            bukuRepository.delete(reference);
            return true;
        }else{
            return false;
        }
    }

    public Integer countByJudulContaining(String string){
        if(string != null){
            return bukuRepository.countByJudulContaining(string);
        }
        return (int) bukuRepository.count();
    }

    public Integer countByJudulContainingAndPenulisContaining(String string, String judul){
        if(string != null){
            return bukuRepository.countByJudulContainingAndPenulisContaining(string, judul);
        }
        return (int) bukuRepository.count();
    }
}
