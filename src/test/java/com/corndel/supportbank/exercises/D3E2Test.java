package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class D3E2Test {
  @Test
  public void testPokemonAPI() {
    try {
      Pokemon pokemon = PokeAPI.getPokemonByName("pikachu");
      assertEquals("pikachu", pokemon.name().trim().toLowerCase());
      assertEquals(60, pokemon.weight());
      assertEquals(25, pokemon.id());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
