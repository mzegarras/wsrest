package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.demo.entidades.User;

@Component
public class UserDAOImpl extends JdbcDaoSupport {
	
		

    @Autowired
    UserDAOImpl(DataSource dataSource){
        setDataSource(dataSource);
    }
	  
	  public void insertUser(User user) {
	    getJdbcTemplate().update(
	      "INSERT INTO USER (USERNAME, NAME) VALUES (?, ?)",
	        new Object[] {
	        user.getUsername(),
	        user.getName()
	      }
	    );
	  }

	  
	  public User getUser(String username) {
	    User user = getJdbcTemplate().queryForObject("SELECT * FROM USER WHERE USERNAME = ?",
	      new Object[] { username },
	      new UserMapper()
	      );
	    return user;
	  }
	  
	  
	  public List<User> getUsers() {
	    List<User> users = getJdbcTemplate().query("SELECT * FROM USER",
	      new UserMapper()
	      );
	    return users;
	  }
	  
	  private class UserMapper implements RowMapper<User>{

	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User user = new User();
	      user.setId(rs.getInt("ID"));
	      user.setUsername(rs.getString("USERNAME"));
	      user.setName(rs.getString("NAME"));
	      return user;
	    }
	    
	  }

}
