package paypal.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paypal.bookstore.entity.BookEntity;
import paypal.bookstore.entity.AccountEntity;
import paypal.bookstore.repository.BookRepository;
import paypal.bookstore.repository.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 4/30/2017.
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    AccountRepository accountRepository;

    // get all account information
    @RequestMapping(method = RequestMethod.GET)
    public Object getAllAccount() {
        List<AccountEntity> taiKhoanEntities = (List<AccountEntity>) accountRepository.findAll();
        return taiKhoanEntities;
    }

    // add new account to database
    @RequestMapping(method = RequestMethod.POST)
    public Object addNewAccount(@RequestBody AccountEntity accountEntity) {
        AccountEntity accountEntityTemp = accountRepository.findByUserNameAndPassword(accountEntity.getUserName(), accountEntity.getPassword());
        if (null == accountEntityTemp) {
            AccountEntity result = accountRepository.save(accountEntity);
            return result;
        } else {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", accountEntity.getUserName() + " already exists");
            }};
            return error;
        }
    }

    // update balance of account
    @RequestMapping(method = RequestMethod.PUT)
    public Object updateAccount(@RequestBody AccountEntity accountEntity) {
        AccountEntity accountEntityTemp = accountRepository.findByUserNameAndPassword(accountEntity.getUserName(), accountEntity.getPassword());
        if (null == accountEntityTemp) {
            //error, khong tim thay account
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", "Username or password is incorrect!");
            }};
            return error;
        }
        if (null != accountEntityTemp) {
            if (accountEntityTemp.getSoDu() >= accountEntity.getSoDu()) {
                // thuc hien update
                double soDu = accountEntityTemp.getSoDu() - accountEntity.getSoDu();
                accountEntity.setSoDu(soDu);
                AccountEntity result = accountRepository.save(accountEntity);
                Map<String, String> success = new HashMap<String, String>() {{
                    put("success", "Successfully transacted");
                }};
                return success;
            } else {
                //error, tai khoan khong du tien
                Map<String, String> error = new HashMap<String, String>() {{
                    put("error", "The balance is not enough to make a transaction");
                }};
                return error;
            }
        }
        return null;
    }

    // delete account information
    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    public Object deleteBook(@PathVariable(value = "userName") String userName) {
        AccountEntity accountEntity = accountRepository.findOne(userName);
        if (null == accountEntity) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", "An account which username = " + userName + " does not exists");
            }};
            return error;
        } else {
            accountRepository.delete(userName);
            Map<String, String> success = new HashMap<String, String>() {{
                put("success", "An account which username = " + userName + " has been deleted successfully");
            }};
            return success;
        }
    }

}
