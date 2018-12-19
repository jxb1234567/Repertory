package com.todo.service;

import java.sql.SQLException;

import com.todo.db.OpSqliteDB;
import com.todo.entity.User;


public class UserService {
	
	public boolean registerSave(User user) throws SQLException{
		OpSqliteDB.execUpdateSql("insert into user(userName,loginName,password) values('"+ user.getUserName() +"','"+ user.getLoginName() +"','"+ user.getPassword() +"')");
		return true;
	}
}
