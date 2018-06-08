package dao;

import entity.Mahasiswa;

import java.util.List;

public interface MahasiswaDAO {

    Mahasiswa save(Mahasiswa entity);

    Mahasiswa update(Mahasiswa entity);

    Mahasiswa delete(Mahasiswa entity);

    Mahasiswa findById(int id);

    Mahasiswa findByNim(String nim);

    Mahasiswa findByName(String nama);

    List<Mahasiswa> find(Mahasiswa entity);



}
