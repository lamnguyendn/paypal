package paypal.bookstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import paypal.bookstore.entity.AccountEntity;

import java.util.List;

/**
 * Created by Administrator on 4/30/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

    @Query(value = "SELECT * FROM `taikhoan` WHERE `username` = ?1 AND `password` = ?2", nativeQuery = true)
    AccountEntity checkLogin(String userName, String password);

    AccountEntity findByUserNameAndPassword(String userName, String password);
}
