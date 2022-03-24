package com.algonquin.recipebook.dao;

import com.algonquin.recipebook.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository("message")
public class MessageDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDao(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    public int insertMessage(Message message) {
        String sql = "insert into TwitterLikeApp.Messages (MessageName, MessageContent) values (?,?)";
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{message.getMessageName(), message.getMessageContent()});
        return rowsAffected;
    }

    public List<Message> getMessagesByProducer(UUID uuid) {
        String sql = "SELECT * FROM TwitterLikeApp.Messages WHERE UserId = ?";
        List<Message> messages = jdbcTemplate.query(sql, new MessageRowMapper(), uuid);
        return messages;
    }
    public List<Message> getMessagesBySubscriber(UUID uuid) {
        String sql = "SELECT * FROM TwitterLikeApp.Messages WHERE UserId = ?";
        List<Message> messages = jdbcTemplate.query(sql, new MessageRowMapper(), uuid);
        return messages;
    }

    private static class MessageRowMapper implements RowMapper<Message> {

        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setMessageName(rs.getString("RecipeName"));
            message.setMessageContent(rs.getString("RecipeDescription"));

            return message;
        }
    }
    public List<Message> getMessages() {
        String sql = "SELECT * FROM TwitterLikeApp.Messages";
        List<Message> messages = jdbcTemplate.query(sql,new MessageRowMapper());
        return messages;

    }
}
