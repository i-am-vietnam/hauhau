package com.example.democha;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class HelloController {
    private static final String channel = "2002";
    @FXML
    private Button btnSend;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtMessage;
    @FXML
    private Jedis jedisP=new Jedis();
    @FXML
    private Jedis jedisS;
    @FXML
    private JedisPubSub jedisPubSub;


     @FXML
    public void sendMessage() {
        jedisP.publish(channel,"Mình nè: "+ txtMessage.getText());
    }

}