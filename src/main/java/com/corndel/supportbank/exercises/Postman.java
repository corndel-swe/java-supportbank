package com.corndel.supportbank.exercises;

import kong.unirest.Unirest;

class Message {
  public int id;
  public String content;

  public Message(int id, String content) {
    this.id = id;
    this.content = content;
  }
}

public class Postman {
  public static String echoMessage(int id, String content) {
    Message message = new Message(id, content);

    var response = Unirest.post("https://postman-echo.com/post")
        .header("Content-Type", "application/json")
        .body(message)
        .asString();

    return response.getBody();
  }

  public static void main(String[] args) {
    String response = echoMessage(1, "hello");
    System.out.println(response);
  }
}
