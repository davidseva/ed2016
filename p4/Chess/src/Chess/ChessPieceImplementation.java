package Chess;



import java.io.File;
import java.util.*;

public class ChessPieceImplementation implements ChessPiece {

    Type type;
    Color color;
    ChessPiece piece;
    PiecePosition[] posicion;
    int nfCount = 0; // indica el número de veces que se llama al método notifyMoved()
    
    

    ChessPieceImplementation(Color color, Type type) {
        this.color = color;
        this.type = type; 
        
    }

    
        /**
	 * Esta función devuelve el color de la pieza.
	 * @return The color of the piece.
	 */
    @Override
    public Color getColor() {
        
        return color;
        
    }
        /**
	 * Esta función devuelve el tipo de la pieza
	 * @return 
	 */
    @Override
    public Type getType() {
        
        return type;
        
    }
         /**
	 * Cuando el tablero mueve una ficha, llama a esta función para notificarle
	 * que la ha movido.
	 */
    @Override
    public void notifyMoved() {
        System.out.println("Se ha movido una ficha");
        nfCount++;
    }
        /**
	 * Esta función devuelve si la ficha se ha movido en algún momento de la partida 
	 * o no.
	 * @return true if notifyMoved was called once at least, false otherwise.
	 */
    @Override
    public boolean wasMoved() {
        return nfCount > 0;
    }
    /**
	 * Esta función devuelve un array con todas las posibles posiciones a las que 
	 * se puede mover una ficha.
	 * @param aBoard Board containing the piece.
	 * @return the array with the available positions where the piece can be moved.
	 */
    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {        
        
        if(this.piece != null)
        {
           switch(this.piece.getType()) 
           {
              
                                       
               case BISHOP:
                   posicion = ChessMovementManager.getAvailablePositionsOfBishop(this.piece, aBoard); break;
               case KING:
                   posicion = ChessMovementManager.getAvailablePositionsOfKing(this.piece, aBoard); break;
               case QUEEN:
                   posicion = ChessMovementManager.getAvailablePositionsOfQueen(this.piece, aBoard); break;
               case KNIGHT:
                   posicion = ChessMovementManager.getAvailablePositionsOfKnight(this.piece, aBoard); break;
               case ROOK:
                   posicion = ChessMovementManager.getAvailablePositionsOfRook(this.piece, aBoard); break;
               case PAWN:
                    break;
               default:                   
                   posicion = ChessMovementManager.getAvailablePositionsOfPawn(this.piece, aBoard);  break;              
           }
                   
        }
        return posicion;
    }
    
}