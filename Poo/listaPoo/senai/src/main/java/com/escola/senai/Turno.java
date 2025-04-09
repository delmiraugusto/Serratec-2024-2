package com.escola.senai;

public enum Turno {
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private final String turnoAula;

    Turno(String turnoAula) {
        this.turnoAula = turnoAula;
    }
    
    public String getTurnoAula() {
        return turnoAula;
    }
}
