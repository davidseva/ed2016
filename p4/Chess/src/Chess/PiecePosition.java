package Chess;

public class PiecePosition {

	/**
	 * Indica si la casilla definida por los parámetros column y row,
         * está dentro del tablero, devuelve true si está dentro
	 */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
	 * Indica si la casilla a la que se quiere mover está (true) o no (false)
         * disponible, a partir de una posición dada y sus incrementos en los ejes X e Y
	 */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
	 * Dada una posición, indica si está (true) o no (false) disponible
	 */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
	 * Constructor con dos parámetros
	 */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Devuelve la columna de la posición dada
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Devuelve la fila de la posición dada
	 */
	public int getRow() {
		return row;
	}
	
        /**
         * Método que indica si los parámetros column y row están dentro del tablero,
         * y si es así devuelve true y establece esas  coordenadas en la posición de la pieza,
         * en caso contrario devuelve false y no las establece
         * @param column
         * @param row
         * @return 
         */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
	 * Método que obtiene la posición donde se desplaza la pieza,
         * a partir de los parametos de entrada columnCount y rowCount
	 */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
	 * Método que obtiene una posición de la pieza igual a la actual
	 */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
	 * Obtiene si la posición especificada como parámetro de entrada,
         * es igual a la actual
	 */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
