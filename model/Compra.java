package model;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private int id;
    private LocalDateTime data;
    private List<Jogo> jogos;
    private double total;

    public Compra(int id, LocalDateTime data, List<Jogo> jogos) {
        this.id = id;
        this.data = data;
        this.jogos = jogos;
        this.total = calcularTotal();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public double getTotal() {
        return total;
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Jogo jogo : jogos) {
            total += jogo.getPreco();
        }
        return total;
    }
}
