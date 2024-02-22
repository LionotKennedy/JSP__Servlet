
package model;
import java.sql.*;

public class Client {
    private int id;
    private String nom;
    private float solde;
    private String Status;

    public Client(String nom, float solde, String Status) {
        this.id = id;
        this.nom = nom;
        this.solde = solde;
        this.Status = Status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the solde
     */
    public float getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(float solde) {
        this.solde = solde;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
    public int insert(Connection conn) {
        PreparedStatement prepare;
        int s = 1;
        try {
            String Query = "INSERT INTO comptes (nameClient,soldeClient,soldeStatus) VALUES (?,?,?)";
            prepare = conn.prepareStatement(Query);
            prepare.setString(1, this.getNom());
            prepare.setFloat(2, this.getSolde());
            prepare.setString(3, this.getStatus());
            prepare.executeUpdate();
            prepare.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            s = 0;
        }
        return s;
    }
    
    public int display(Connection conn) {
        PreparedStatement prepare;
        int s = 1;
        try {
            String Query = "SELECT * FROM comptes";
            prepare = conn.prepareStatement(Query);
            prepare.executeQuery();
            prepare.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            s = 0;
        }
        return s;
    }
}
