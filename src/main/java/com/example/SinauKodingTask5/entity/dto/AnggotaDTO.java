package com.example.SinauKodingTask5.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AnggotaDTO {
    private String nama;
    private String alamat;
    private String noTelp;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglLahir;
    private String jenisKelamin;
}
