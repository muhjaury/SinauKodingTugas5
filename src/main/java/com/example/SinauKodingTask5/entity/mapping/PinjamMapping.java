package com.example.SinauKodingTask5.entity.mapping;

import com.example.SinauKodingTask5.entity.Buku;
import com.example.SinauKodingTask5.entity.Pinjam;
import com.example.SinauKodingTask5.entity.dto.BukuDTO;
import com.example.SinauKodingTask5.entity.dto.PinjamDTO;
import com.example.SinauKodingTask5.entity.dto.custom.PinjamCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PinjamMapping {
    PinjamMapping INSTANCE = Mappers.getMapper(PinjamMapping.class);
    Pinjam toEntity(PinjamDTO dto);
    PinjamDTO toDTO(Pinjam pinjam);

    PinjamCustomDTO toCustomDTO(Pinjam pinjam);

    List<Pinjam> toPinjamList(List<PinjamDTO> data);
    List<PinjamDTO> toPinjamDTOList(List<Pinjam> data);

    List<PinjamCustomDTO> toPinjamCustomDTOList(List<Pinjam> data);
}
