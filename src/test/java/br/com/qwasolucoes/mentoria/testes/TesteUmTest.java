package br.com.qwasolucoes.mentoria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.qwasolucoes.mentoria.implementacoes.TesteUm;
import br.com.qwasolucoes.mentoria.interfaces.ITesteUm;

public class TesteUmTest {

  @Test
  public void testeSomaPositivos() {
    ITesteUm testeUm = new TesteUm();
    int resultado = testeUm.soma(10, 18);
    Assert.assertEquals("Teste soma simples", 28, resultado);
  }
} 