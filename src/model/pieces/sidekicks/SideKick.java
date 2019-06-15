package model.pieces.sidekicks;

import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public abstract class SideKick extends Piece {

	public SideKick(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	
	public void moveDown() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWN);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveUp() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UP);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.LEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.RIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveDownLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWNLEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveDownRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWNRIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveUpLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UPLEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
	
	public void moveUpRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UPRIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosI(x[0]);
		getGame().getCellAt(x[0],x[1]).getPiece().setPosJ(x[1]);
	}
}
