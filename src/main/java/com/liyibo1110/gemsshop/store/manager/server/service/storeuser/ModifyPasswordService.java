package com.liyibo1110.gemsshop.store.manager.server.service.storeuser;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class ModifyPasswordService extends BaseStoreUserService {

	private static Logger logger = LoggerFactory.getLogger(ModifyPasswordService.class);
	
	public int modify(Integer id, String password){
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		return storeUserDao.updatePassword(id, password);
	}
}
