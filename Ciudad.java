package modelo;

public enum Ciudad {
    ANDALUCIA,BUGALAGRANDE,ELCERRITO,GINEBRA,GUACARI,BUGA,RIOFRIO,TRUJILLO,CALIMA,RESTREPO,SANPEDRO,TULUA,YOTOCO,ELAGUILA,
ALCALA,ANSERMANUEVO,ARGELIA,ELCAIRO,LAUNION,LAVICTORIA,ULLOA,BOLIVAR,CARTAGO,ELDOVIO,OBANDO,ROLDANILLO,TORO,VERSALLES,
ZARZAL,BUENAVENTURA,CAICEDONIA,SEVILLA,CALI,CANDELARIA,PALMIRA,DAGUAFLORIDA,JAMUNDI,LACUMBRE,PRADERA,VIJES,YUMBO;
    public static Ciudad obtenerCiudad(String nombreCiudad) {
        for (Ciudad ciudad : Ciudad.values()) {
            if (ciudad.name().equalsIgnoreCase(nombreCiudad)) {
                return ciudad;}}
                return null;}
}
