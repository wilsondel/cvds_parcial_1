package presentation;

public class DaRules {
    public static final String RULES = "\n" + "POOBchis\n\r"+
            " \n" +
            "\n" +
            "Poobhis es un juego de mesa similar al parqués.\n" +
            "Es un juego de 2 jugadores que requiere un tablero característico formado por un circuito de 100 casillas y 4 casas de diferentes colores: amarillo, rojo, verde y azul. Cada jugador dispone de 4 fichas del mismo color que su casa.\n" +
            "\n" +
            "Los movimientos de las fichas se determinan con dos dados, los cuales van a ser lanzados por cada uno de los jugadores en su turno correspondiente.\n" +
            "\n" +
            "\n" +
            "REGLAS DEL JUEGO\n" +
            "--------------------------------------------------------------------------\n" +
            "1.1  REGLAS PARCHÍS\n" +
            "\n" +
            "\n" +
            "GANAR EL JUEGO\n" +
            "Gana el jugador que primero logre llevar sus cuatro piezas alrededor del tablero hasta la llegada en forma segura.\n" +
            "\n" +
            "SALIR DEL NIDO\n" +
            "Las piezas salen del nido cuando el jugador tira CINCO en un solo dado o en la forma de ambos. Un doble CINCO puede ser usado para mover 2 piezas fuera del nido en forma simultánea.\n" +
            "\n" +
            "CASTIGO POR TIRAR DOBLES TRES VECES CONSECUTIVAS\n" +
            "Si el jugador tira doble tres veces en el mismo turno, la tercera vez se pierde y la ultima pieza movida debe enviarse al nido  (las piezas que alcanzaron la llegada no pueden regresar)\n" +
            "BLOQUEOS\n" +
            "Si dos piezas del mismo color llegan a un mismo casillero forman un bloqueo. Ninguna pieza del mismo jugador o de otro oponente pueden cruzar. Si un jugador no puede mover ninguna pieza a causa de un bloqueo pierde el turno. Nota: si el jugador tiro dobles este forzado a romper el bloqueo (en caso de que exista alguno).\n" +
            "\n" +
            "ESPACIOS SEGUROS\n" +
            "Todos los casilleros grises con estrellas son espacios seguros. Una pieza que descanse en ellos no puede ser capturada y enviada al principio. \n" +
            "\n" +
            "DESCANSAR EN UN ESPACIO SEGURO\n" +
            "Dos piezas de diferentes colores no pueden descansar en un mismo espacio seguro al mismo tiempo, en este caso formaran un bloqueo debiendo aplicarse las mimas reglas descriptivas anteriormente. \n" +
            "\n" +
            "PREMIO POR CAPTURAS\n" +
            "El premio por enviar a una pieza del oponente a su base es una movida LIBRE de 20 casilleros que no puede dividirse entre diferentes piezas (30 para un tablero de 6 jugadores)\n" +
            "\n" +
            "PREMIO POR ALCANZAR LA LLEGADA\n" +
            "El premio por alcanzar la llegada con una pieza es una movida LIBRE de 10 casilleros que no puede dividirse entre diferentes piezas (15 tableros de 6 jugadores).\n" +
            "\n" +
            "---------------------------------------------------------------------------- \n" +
            "1.2 REGLAS POOBchis\n" +
            "\n" +
            "POOBchis tiene las siguientes novedades:\n" +
            "\n" +
            "•\tPoderes para las fichas.\n" +
            "•\tModos de juego (2 modos)\n" +
            "•\tCasillas con comodines.\n" +
            "•\tPersonalización para las fichas.\n" +
            "•\tPersonalización para las casillas.\n" +
            "•\tPersonalización para los dados.\n" +
            "JUEGO\n" +
            "En POOBchis, cada jugador tiene el control de sus dados y fichas, el jugador debe indicar que ficha quiere mover y la cantidad de casillas. En el transcurso de la partida, la ficha puede encarcelar a las fichas de sus oponentes (cae en una casilla no segura y hay una ficha de otro jugador); puede ser enviada a la cárcel (si saca tres veces seguidas dobles en los dados); puede recoger comodines que aparecerán aleatoriamente en el tablero, puede lanzar poderes de las fichas (si los tiene).\n" +
            "Las 4 fichas de cada jugador inician en la cárcel, si el número de jugadores es 2, las casas disponibles para jugar no deben ser adyacentes, para el caso de que el número de jugadores sea 2, las casas del tablero estarán llenas en su totalidad.\n" +
            "Las reglas de parchís que se mencionaron anteriormente deben ser respetadas para POOBchis, finalmente, el jugador que primero logré coronar sus 4 fichas será el ganador de la partida y una vez haya un ganador, el juego termina.\n" +
            "\n" +
            "\n" +
            " \n" +
            "---------------------------------------------------------------------------- \n" +
            " \n" +
            "MODOS DE JUEGO \n" +
            "En POOBchis se tienen dos modos de juego:\n" +
            "•\tModo “Divertido”: En este modo aparecen comodines aleatoriamente a lo largo del tablero, si una ficha cae en una casilla con comodín (se definen más adelante), dicho comodín se aplicará de inmediato, no puede ser guardado. Adicionalmente, para este tablero los jugadores contarán con tipos de fichas que estarán diferenciadas por sus habilidades (se definen más adelante). Sin embargo, en este modo se juega contra una persona.\n" +
            "\n" +
            "•\tModo “PvM”: En este tablero aparecen comodines aleatoriamente a lo largo del tablero, si una ficha cae en una casilla con comodín (se definen más adelante), dicho comodín se aplicará de inmediato, no puede ser guardado. Adicionalmente, para este tablero los jugadores contarán con tipos de fichas que estarán diferenciadas por sus habilidades (se definen más adelante). Sin embargo, en este modo se juega contra la  maquina. \n" +
            "TIPOS DE FICHAS\n" +
            "Para cada partida, el jugador arma su equipo de fichas dependiendo del modo elegido para jugar, fichas que están en un tablero no pueden estar en otro.\n" +
            "\n" +
            "\uF0D8\tPara modo 1:\n" +
            "•\tNormal: Avanza a lo largo del tablero según el valor que le indica el jugador.\n" +
            "•\tVentajosa: Cada dos turnos del jugador la ficha avanzará 3 casillas sin necesidad que el jugador se lo indique o caiga 3 en el valor de los dados.\n" +
            "•\tAspiradora: Trae la ficha (del mismo equipo) que esté casillas atrás más cerca de ella; y la lleva a la misma casilla donde está la ficha aspiradora (forma un nuevo bloqueo, máximo dos fichas por casilla). Este poder solo puede ser usado dos veces durante la partida.\n" +
            "\n" +
            "•\tSaltarina: Esta ficha puede saltar los bloqueos que estén en el camino, es decir, avanzará la cantidad en los dados sin importar los bloqueos formados (incluso los de su propio color). Tener en cuenta que no se puede formar bloqueos de más de dos fichas \n" +
            " \n" +
            " \n" +
            "COMODINES\n" +
            "Los comodines son habilidades o desventajas que puede adquirir el jugador durante la partida, al caer en una casilla “comodín” recibe un comodín; los comodines pueden repetirse en la partida, una vez tomado el comodín la casilla desaparece y aparece un nuevo comodín en una casilla vacía aleatoriamente en el tablero; se definen los siguientes comodines:\n" +
            "•\tIrse a la cárcel: La ficha que obtenga este comodín se irá directamente a la cárcel.\n" +
            "•\tAvanzar 5 casillas: La ficha que obtenga este comodín avanza 5 casillas automáticamente.\n" +
            "•\tRetroceder 5 casillas: La ficha que le salga este comodín retrocede automáticamente 5 casillas. Este comodín no debe permitir retroceder la ficha más atrás de la casilla de inicio del jugador.\n" +
            "•\tSacar una ficha de su cárcel: El equipo del color correspondiente a la ficha que adquiere este comodín, podrá liberar una de sus fichas (solo si tiene fichas en la cárcel).\n" +
            "•\tJugar doble turno: El jugador dueño de la ficha a la que le sale este comodín, tendrá un turno adicional, es decir, podrá jugar de nuevo los dados.\n" +
            "•\tRomper bloqueo: Si hay bloqueos en el tablero, este comodín permite romper el bloqueo de fichas más próximo a la casilla donde se obtuvo el comodín.\n" +
            "•\tInmortal: Si se obtiene este comodín nadie puede matar a la ficha que lo obtuvo en los próximos 4 turnos (Un turno es una tirada de dados).\n" +
            "•\tMutar: Si se obtiene este comodín la ficha puede mutar.\n" +
            "\n";

}
