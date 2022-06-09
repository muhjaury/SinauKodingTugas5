package com.example.SinauKodingTask5.entity.mapping;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.dto.AnggotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnggotaMapping {
    AnggotaMapping INSTANCE = Mappers.getMapper(AnggotaMapping.class);
    Anggota toEntity(AnggotaDTO dto);
    AnggotaDTO toDTO(Anggota anggota);

    List<Anggota> toAnggotList(List<AnggotaDTO> data);
    List<AnggotaDTO> toAnggotaDTOList(List<Anggota> data);
}
