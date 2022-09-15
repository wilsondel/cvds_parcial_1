# Parcial 1

**Nombres**:

* Maria Juanita Oramas Bermudez
* Wilson Alirio Delgado Hernandez


## Malas Prácticas

### Git y GitHub
No se tiene un buen uso del .gitignore, para no llevar trackeo de archivos o directorios innecesarios como los del IDE.  

### SOLID
* Se viola el principio de *Single Responsibility* ya que la clase Board está sobrecargada de distintas responsabilidades.  
![img_1.png](img_1.png)
* Se evidencia el uso del principio de *Open/Close* aplicado en el polimorfismo sobre los distintos tipos de casillas.
 En el caso de la clase, Joker que hereda de Box.

```
    @Override
    public String getWildcard(){
        String[] myWildCard = {movePlus5,moveMenus5};
        Random r = new Random();
        int randomitem = r.nextInt(myWildCard.length);
        String randomElement = myWildCard[randomitem];
        return randomElement;
    }
```

* Hay oportunidades de mejora *sustitución de Liskov* dado que hay casos donde se hereda de una clase y no se añade ninguna funcionalidad.

```
public class HomeWay extends  Box {
    public HomeWay() {
        super();
    }
    public HomeWay(Color color) {
        super(color);
    }
}
```



* No se hace uso del *principio de segregación de interfaces* porque no hay uso de interfaces, ni clases abstractas. 
Sin embargo, su uso se podría implementar en el diseño de las fichas y de las casillas.  
baja cohesion.
 

* Para el principio de *Inversion de dependencias*,
Hay una gran cantidad de dependencia entre las clases de la aplicación. Se evidencia que las clases son las que directamente se encargan de la creación de los objetos.
![img.png](img.png)

Para su solución se puede delegar la creación de objetos a un framework como guice.



### M.V.C

**Model**
![img_1.png](img_1.png)
Contiene la lógica para trabajar con los datos y manipular su estado.

**View** 
![img_3.png](img_3.png)
Interactúa con el controlador, modificando, recibiendo y actualizando la visualización de los datos. También cumple con tener las reglas de gestión de los eventos.

**Controller**
![img_2.png](img_2.png)
Se tiene una mala distribución de responsabilidades, ya que la clase que debería ser la controladora, en este caso, Poobchis no cumple su función y se está dejando a la clase Board la responsabilidad, la cual, también maneja los datos. 


#

## Unit Testing
Los tests no cuentan con clases de equivalencia lo que genera baja claridad sobre los conjuntos de datos de entrada.

### F.I.R.S.T
Se viola el principio 
codigo legacy 

### AAA
Vemos que algunas pruebas si cumplen con este patron, pero no todas.
```
    @Test
    public void shouldValidateBasePieceP1() {
        // Arrange
        Board board = new Board();
        Player p1 = new Player("P1");
        int[] result = {5,4};
        // Act
        board.evaluateBox(result,p1,1,result[1]);
        ArrayList<Integer> piecesBases = board.getBaseP1().lookPieces();
        boolean flag = piecesBases.contains(1);
        // Assert
        assertFalse(flag);
    }
```


*Arrange* Inicializar, *Act* método a probar, *Assert* comprobación. 

### Patrones de nombramiento
Hay oportunidades de mejora en el nombramiento de los tests. Por ejemplo:p

```
    @Test
    public void shouldDeletePieces() {
        Box box = new Box();
        Piece[] pieces = {new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan)};
        box.addPiece(pieces);
        box.removePiece();
        int sizePieces = box.getPieces().size();
        assertEquals(0,sizePieces);
    }

```


```
    @Test
    public void given4PiecesToABox_whenRemovePieces_thenSizeIs0() {
        Box box = new Box();
        Piece[] pieces = {new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan)};
        box.addPiece(pieces);
        box.removePiece();
        int sizePieces = box.getPieces().size();
        assertEquals(0,sizePieces);
    }

```



## Patrones
Se hace uso del patrón singleton en la clase MenuOptions
![img_5.png](img_5.png)


