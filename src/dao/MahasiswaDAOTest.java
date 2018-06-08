package dao;

import entity.Mahasiswa;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class MahasiswaDAOTest {

    private MahasiswaDAO mahasiswaDAO = new MahasiswaDAOImpl();

    @Test
    public void save() {
        Mahasiswa param = new Mahasiswa();
        param.setNim("010");
        param.setNama("iwan");

        Mahasiswa mahasiswa = mahasiswaDAO.save(param);
        Assert.assertEquals(param.getNim(), mahasiswa.getNim());
    }

    @Test
    public void update() {
        Mahasiswa param = new Mahasiswa();

        param.setId(9);
        param.setNim("009");
        param.setNama("janoko");


        Mahasiswa mahasiswa = mahasiswaDAO.update(param);
        Assert.assertEquals(param.getNim(), mahasiswa.getNim());

    }

    @Test
    public void delete() {
        Mahasiswa param = new Mahasiswa();

        param.setId(6);

        Mahasiswa mahasiswa = mahasiswaDAO.delete(param);
        Assert.assertEquals(param.getId(), mahasiswa.getId());
    }

    @Test
    public void findByNim() {
        Mahasiswa param = mahasiswaDAO.findByNim("008");
        Assert.assertNotNull(param);

    }







    @Test
    public void findByName() {

        Mahasiswa param = mahasiswaDAO.findByName("janoko");
        Assert.assertNotNull(param);

    }












    @Test
    public void findById() {
        Mahasiswa param = mahasiswaDAO.findById(3);
        Assert.assertNotNull(param);

    }

    @Test
    public void find() {

        List<Mahasiswa> param = mahasiswaDAO.find(new Mahasiswa());

        Assert.assertNotNull(param);

    }

}