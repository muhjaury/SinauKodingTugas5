package com.example.SinauKodingTask5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pinjam")
@Getter
@Setter
public class Pinjam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pinjam")
    private Integer idPinjam;

    @JsonIgnoreProperties(value = {"pinjams","handler","hibernateLazyInitializer"}
            ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;

    @JsonIgnoreProperties(value = {"pinjams","handler","hibernateLazyInitializer"}
                        ,allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @Column(name = "tgl_pinjam")
    private Date tglPinjam;

    @Column(name = "tgl_kembali")
    private Date tglKembali;
}
