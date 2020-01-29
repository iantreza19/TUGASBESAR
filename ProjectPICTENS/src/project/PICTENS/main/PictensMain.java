/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.PICTENS.main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import project.PICTENS.database.PictensDatabase;
import project.PICTENS.entity.Pelanggan;
import project.PICTENS.error.PelangganException;
import project.PICTENS.service.PelangganDao;
import project.PICTENS.view.LoginView;
import project.PICTENS.view.MainHomeView;

/**
 *
 * @author IantReza
 */
public class PictensMain {

    /**
     * @param args the command line arguments
     */
    private static String userName;
    
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here

        /*Insert
        
         PelangganDao dao = PictensDatabase.getPelangganDao();
         Pelanggan pelanggan = new Pelanggan();
         pelanggan.setNama("Iant Reza Anshory");
         pelanggan.setExpertise("Landscape");
         pelanggan.setAlamat("Karawang");
         pelanggan.setTelepon("08174161749");
         pelanggan.setEmail("iantreza2@gmail.com");
        
         dao.insertPelanggan(pelanggan);
         */
        /*Delete
        
         PelangganDao dao = PictensDatabase.getPelangganDao();
        
         dao.deletePelanggan(1);
         */
        LoginView login = new LoginView();
        login.setVisible(true);
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    MainHomeView pelanggan = new MainHomeView(userName);
                    pelanggan.loadDataase();
                } catch (SQLException e) {
                
                } catch (PelangganException ex) {
                    Logger.getLogger(PictensMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
