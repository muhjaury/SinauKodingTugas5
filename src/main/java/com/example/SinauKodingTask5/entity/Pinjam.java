package com.example.SinauKodingTask5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @Column(name = "tgl_pinjam")
    private Date tglPinjam;

    @Column(name = "tgl_kembali")
    private Date tglKembali;
}
