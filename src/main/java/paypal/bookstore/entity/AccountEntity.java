package paypal.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 4/30/2017.
 */
@Entity
@Table(name = "taikhoan")
public class AccountEntity {

    @Id
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "sodu", nullable = false)
    private double soDu;

    public AccountEntity() {
    }

    public AccountEntity(String userName, String password, double soDu) {
        this.userName = userName;
        this.password = password;
        this.soDu = soDu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
