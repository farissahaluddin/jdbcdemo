package dao;

import connection.DBConnection;

import entity.Mahasiswa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Override
    public Mahasiswa save(Mahasiswa entity) {

        String sql = "INSERT INTO mahasiswa(nim, nama) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, entity.getNim());
            preparedStatement.setString(2, entity.getNama());

            preparedStatement.executeUpdate();


            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Mahasiswa update(Mahasiswa entity) {

        String sql = "UPDATE mahasiswa SET nim=?, nama=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

            preparedStatement.setString(1, entity.getNim());
            preparedStatement.setString(2, entity.getNama());
            preparedStatement.setInt(3, entity.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;

    }

    @Override
    public Mahasiswa delete(Mahasiswa entity) {

        String sql = "DELETE FROM mahasiswa WHERE id=?";

        try {

            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, entity.getId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }





    @Override
    public Mahasiswa findByName(String nama) {
        String sql = "SELECT * FROM mahasiswa WHERE nama=?";

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, nama);

            ResultSet result = preparedStatement.executeQuery();
            Mahasiswa mahasiswa = new Mahasiswa();

            while (result.next()){
                mahasiswa.setId(result.getInt("id"));
                mahasiswa.setNim(result.getString("nim"));
                mahasiswa.setNama(result.getString("nama"));

                System.out.println("Id : " + mahasiswa.getId());
                System.out.println("Nim : " + mahasiswa.getNim());
                System.out.println("Nama : " + mahasiswa.getNama());

            }
            return mahasiswa;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "SELECT * FROM mahasiswa WHERE id=?";

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            Mahasiswa mahasiswa = new Mahasiswa();

            while (result.next()){
                mahasiswa.setId(result.getInt("id"));
                mahasiswa.setNim(result.getString("nim"));
                mahasiswa.setNama(result.getString("nama"));

                System.out.print("id : " + id);
                System.out.print(", Nim : " + mahasiswa.getNim() );
                System.out.print(", Nama : " + mahasiswa.getNama());

            }
            return mahasiswa;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Mahasiswa findByNim(String nim) {
        return null;
    }

    @Override
    public List<Mahasiswa> find(Mahasiswa mahasiswa) {
        String sql = "SELECT * FROM mahasiswa";

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){

                mahasiswa.setId(result.getInt("id"));
                mahasiswa.setNim(result.getString("nim"));
                mahasiswa.setNama(result.getString("nama"));

                System.out.print(" ID : " + mahasiswa.getId());
                System.out.print(", Nim : " + mahasiswa.getNim());
                System.out.println(", Nama : " + mahasiswa.getNama());

            }
            return null;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
