package main.trabalho_01.lista;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Diogo Jayme
 */
public class Vertice {
        public String chave;
        public List<Vertice> adjacentes = new ArrayList<>();

        public Vertice(String chave) {
            this.chave = chave;
        }
    }