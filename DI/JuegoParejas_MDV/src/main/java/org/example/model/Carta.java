package org.example.model;

public class Carta {
    private final int id;

    public Carta(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return id == carta.id;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
