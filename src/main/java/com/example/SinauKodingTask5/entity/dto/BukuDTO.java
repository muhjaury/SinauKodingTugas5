package com.example.SinauKodingTask5.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class BukuDTO {
    private String judul;
    private String penulis;
    private String penerbit;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tahunTerbit;
    private String jenisBuku;
}
