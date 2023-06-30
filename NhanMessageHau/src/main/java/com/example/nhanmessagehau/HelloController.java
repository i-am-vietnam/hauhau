package com.example.nhanmessagehau;

import javafx.application.Platform;
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
    private Button btnSendNhan;

    @FXML
    private TextArea txtAreaNhan;

    @FXML
    private TextField txtMessageNhan;
    @FXML
    private Jedis jedisP;
    @FXML
    private Jedis jedisS;
    @FXML
    private JedisPubSub jedisPubSub;



    @FXML
    private void initialize() {
        jedisP = new Jedis("localhost", 6379);
        jedisS = new Jedis("localhost", 6379);
        Thread consumerThread = new Thread(this::consumeMessage);
        consumerThread.setDaemon(true);
        consumerThread.start();
        System.out.println("haya haya");

    }


    @FXML
    public void consumeMessage() {

        while(true) {

            JedisPubSub jedisPubSub = new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    System.out.println("Received message: " + message);
                    Platform.runLater(() -> {
                        txtAreaNhan.appendText(message + "\n");
                    });
                }
            };
            jedisS.subscribe(jedisPubSub, channel);

        }
    }


}