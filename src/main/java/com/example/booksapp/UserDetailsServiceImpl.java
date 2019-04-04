package com.example.booksapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String sql = "SELECT * FROM users WHERE username = ?";

        User userinfo = jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreated_at(rs.getDate("created_at"));
                user.setWishlist_id(rs.getInt("wishlist_id"));
                user.setHave_read_list_id(rs.getInt("have_read_list_id"));
                return user;
            }
        });

        UserDetails userDetails = (UserDetails)new User(userinfo.getId(), userinfo.getUsername(), userinfo.getEmail(), userinfo.getPassword(), userinfo.getCreated_at(), userinfo.getWishlist_id(), userinfo.getHave_read_list_id());
        return userDetails;
    }


}
