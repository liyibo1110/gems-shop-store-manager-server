package com.liyibo1110.gemsshop.store.manager.server.service.storeuser;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class LoginService extends BaseStoreUserService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public StoreUser login(String username, String password){
		StoreUser storeUser = storeUserDao.getByUsername(username);
		if(storeUser == null){
			return null;
		}else{
			//开始验证密码
			if(BCrypt.checkpw(password, storeUser.getPassword())){
				return storeUser;
			}else{
				return null;
			}
		}
	}
}
