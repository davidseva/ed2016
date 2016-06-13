package tresenraya;



public  class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard
{
   
    // Disposición inicial del tablero
     Color [][] tablero =   { {Color.RED,Color.WHITE,Color.RED},{Color.VOID,Color.RED, Color.VOID},{Color.WHITE,Color.VOID, Color.WHITE} };
    
          
    
   
   

    /**
	 * Función que dice si el juego ha acabdo o no.
	 * @return true si el juego ha acabado, false en caso contrario.
	 */
    @Override
    public boolean isGameOver() {
        
                     
        
        // diagonales
        if (tablero[0][0] == Color.RED && tablero[1][1] == Color.RED && tablero[2][2] == Color.RED
            || tablero[0][2] == Color.RED && tablero[1][1] == Color.RED && tablero [2][0] == Color.RED
            || tablero[0][0] == Color.WHITE && tablero[1][1] == Color.WHITE && tablero[2][2] == Color.WHITE
            || tablero[0][2] == Color.WHITE && tablero[1][1] == Color.WHITE && tablero [2][0] == Color.WHITE)             
         return true;
        // horizontales
        else if (tablero[0][0] == Color.RED && tablero[0][1] == Color.RED && tablero[0][2] == Color.RED
                || tablero[1][0] == Color.RED && tablero[1][1] == Color.RED && tablero[1][2] == Color.RED
                || tablero[2][0] == Color.RED && tablero[2][1] == Color.RED && tablero[2][2] == Color.RED
                || tablero[0][0] == Color.WHITE && tablero[0][1] == Color.WHITE && tablero[0][2] == Color.WHITE
                || tablero[1][0] == Color.WHITE && tablero[1][1] == Color.WHITE && tablero[1][2] == Color.WHITE
                || tablero[2][0] == Color.WHITE && tablero[2][1] == Color.WHITE && tablero[2][2] == Color.WHITE)
        return true;
        // verticales
        else if (tablero[0][0] == Color.RED && tablero[1][0] == Color.RED && tablero[2][0] == Color.RED
                || tablero[0][1] == Color.RED && tablero[1][1] == Color.RED && tablero[2][1] == Color.RED
                || tablero[0][2] == Color.RED && tablero[1][2] == Color.RED && tablero[2][2] == Color.RED
                || tablero[0][0] == Color.WHITE && tablero[1][0] == Color.WHITE && tablero[2][0] == Color.WHITE
                || tablero[0][1] == Color.WHITE && tablero[1][1] == Color.WHITE && tablero[2][1] == Color.WHITE
                || tablero[0][2] == Color.WHITE && tablero[1][2] == Color.WHITE && tablero[2][2] == Color.WHITE)
            return true;
        else return false;
        
        
        //else return false;
        
    }

    /**
	 * Esta función intenta mover la ficha desde la posición de origen a la posición
	 * de destino.
	 * @param fromX Posición X de la ficha que queremos mover
	 * @param fromY Posición Y de la ficha que queremos mover
	 * @param toX Posición X a la cual queremos mover la ficha
	 * @param toY Posición Y a la cual queremos mover la ficha
	 * @return true si se pudo mover, false en caso contrario
	 */
    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        
        // si origen y destino coinciden 
        if (fromX == toX && fromY == toY)
            return false;
        
        // si los parámetros están fuera de los límites del tablero        
        else if(fromX < 0 || fromX > 2 || fromY < 0 || fromY > 2 || toX < 0 || toX > 2 || toY < 0 || toY > 2)                
            return false;
        // si la casilla de destino no está vacía
        else if (getPieceAt(toX,toY) != Color.VOID)
            return false;
    // en el resto de los casos, se puede mover y el color de la casilla destino pasa a ser la del origen 
    // la casilla de origen pasará a estar vacía
        else
        {
            tablero[toX][toY] = getPieceAt(fromX, fromY);
            tablero[fromX][fromY] = Color.VOID; 
            return true;
        }
    }

    /**
	 * Función que nos devuelve el color de la ficha en la posición indicada
	 * @param x Valor X de la posición donde queremos saber si hay una ficha
	 * @param y Valor Y de la posición donde queremos saber si hay una ficha
	 * @return Color de la ficha que hay en la celda indicada, si no hay ficha 
	 * la función devolverá VOID
	 */
    @Override
    public Color getPieceAt(int x, int y) {
        // si está en los límites del tablero
        if(x<=2 && x>=0 && y<=2 && y>=0)
        {
        
        
            if(tablero[x][y] == Color.RED)
                return Color.RED;
            else if(tablero[x][y] == Color.WHITE)
                return Color.WHITE;
            else
                return Color.VOID;
        }
        else return null;
       
    }

    /**
	 * Función que nos devuelve si se puede mover la ficha en la posicion x, y
	 * @param x Valor X de la posición donde queremos saber si se puede mover
	 * @param y Valor Y de la posición donde queremos saber si se puede mover
	 * @return true si se puede mover la ficha, false en caso contrario
	 */
    @Override
    public boolean canMovePieceAt(int x, int y) {
          
        // No se puede mover si está fuera de los límites del tablero o la casilla está vacía
       if((x>2 || x<0 || y>2 || y<0) ||  tablero[x][y] == Color.VOID)
           return false;
       else 
           // en el resto de casos, podrá mover
       {          
           return true;       
       }
                        
    }
    
    
    
    
}