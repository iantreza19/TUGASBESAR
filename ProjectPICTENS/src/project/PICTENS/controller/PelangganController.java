/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.PICTENS.controller;

import javax.swing.JOptionPane;
import project.PICTENS.model.PelangganModel;
import project.PICTENS.view.HomeView;

/**
 *
 * @author IantReza
 */
public class PelangganController {

    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    public void resetPelanggan(HomeView view) {
        model.resetPelanggan();
    }

    public void insertPelanggan(HomeView view) {

        String nama = view.getNameTxt().getText();
        String expertise = view.getExpertiseTxt().getText();
        String alamat = view.getAddressTxt().getText();
        String telepon = view.getPhoneTxt().getText();
        String email = view.getEmailTxt().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh kosong");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        } else {

            model.setNama(nama);
            model.setExpertise(expertise);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }

        }

    }

    public void updatePelanggan(HomeView view) {

        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan diubah");
            return;
        }

        Integer id = Integer.parseInt(view.getIdTxt().getText());
        String nama = view.getNameTxt().getText();
        String expertise = view.getExpertiseTxt().getText();
        String alamat = view.getAddressTxt().getText();
        String telepon = view.getPhoneTxt().getText();
        String email = view.getEmailTxt().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        } else {

            model.setId(id);
            model.setNama(nama);
            model.setExpertise(expertise);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di Ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }

        }

    }

    public void deletePelanggan(HomeView view) {

        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getIdTxt().getText());
            model.setId(id);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }

    }

}
