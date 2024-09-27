package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class D3E3Test {

  @Test
  public void testEchoMessage() throws Exception {
    String response = Postman.echoMessage(1, "hello");

    ObjectMapper mapper = new ObjectMapper();
    JsonNode data = mapper.readTree(response).get("data");

    assertEquals(1, data.get("id").asInt());
    assertEquals("hello", data.get("content").asText());
  }
}
