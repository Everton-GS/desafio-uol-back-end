package com.test.uolhostt.Enum;

public enum TipoEnum {
    
    Avengers("vingadores"),
    LigaDaJustica("liga_da_justica");

   private String tipo;

    private TipoEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTiop() {
        return tipo;
    }


    
}
