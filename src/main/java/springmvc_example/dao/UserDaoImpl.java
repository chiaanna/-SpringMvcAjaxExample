package springmvc_example.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.User;


@Repository
public class UserDaoImpl implements UserDao{
   
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<User> listUserByName(String name) {
		String sql = "SELECT * FROM user WHERE name like :name";
	
		List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(name), new UserMapper());
				
		return list;
	}
	
	private static  final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs,int rowNum) throws SQLException{
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
	}
	
	private SqlParameterSource getSqlParameterByModel(String name) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(name, "%"+name+"%");
		
		return paramSource;
	}
}
