/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.PICTENS.service;

import project.PICTENS.entity.Pelanggan;
import project.PICTENS.error.PelangganException;
import java.util.List;

/**
 *
 * @author IantReza
 */
public interface PelangganDao {

    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;

    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;

    public void deletePelanggan(Integer id) throws PelangganException;

    public Pelanggan getPelanggan(Integer id) throws PelangganException;

    public List<Pelanggan> selectAllPelanggan() throws PelangganException;

}
