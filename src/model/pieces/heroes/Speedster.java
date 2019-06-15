package model.pieces.heroes;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "S";
	}
	
	public void moveDown() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWN);
		x = targetCell(x[0],x[1],Direction.DOWN);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveUp() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UP);
		x = targetCell(x[0],x[1],Direction.UP);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.LEFT);
		x = targetCell(x[0],x[1],Direction.LEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.RIGHT);
		x = targetCell(x[0],x[1],Direction.RIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveDownLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWNLEFT);
		x = targetCell(x[0],x[1],Direction.DOWNLEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveDownRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.DOWNRIGHT);
		x = targetCell(x[0],x[1],Direction.DOWNRIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveUpLeft() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UPLEFT);
		x = targetCell(x[0],x[1],Direction.UPLEFT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void moveUpRight() {
		int[] x = targetCell(getPosI(),getPosJ(),Direction.UPRIGHT);
		x = targetCell(x[0],x[1],Direction.UPRIGHT);
		getGame().getCellAt(x[0],x[1]).setPiece(this);
		getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
		setPosI(x[0]);
		setPosJ(x[1]);
	}
	
	public void move(Direction r) throws OccupiedCellException, WrongTurnException, UnallowedMovementException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		int[] x = targetCell(getPosI(),getPosJ(),r);
		x = targetCell(x[0],x[1],r);
		if(getGame().getCellAt(x[0],x[1]).getPiece()!=null)
			if(getGame().getCellAt(x[0],x[1]).getPiece().getOwner()==getOwner())
				throw new OccupiedCellException("Cell is occupied",this,r);
		if(getGame().getCellAt(x[0],x[1]).getPiece()!=null)
			attack(getGame().getCellAt(x[0],x[1]).getPiece());
		if(getGame().getCellAt(x[0],x[1]).getPiece()==null)
			switch(r) {
			case RIGHT: moveRight();break;
			case LEFT: moveLeft();break;
			case UP: moveUp();break;
			case DOWN: moveDown();break;
			case UPRIGHT: moveUpRight();break;
			case UPLEFT: moveUpLeft();break;
			case DOWNLEFT: moveDownLeft();break;
			case DOWNRIGHT: moveDownRight();break;
			}
		getGame().switchTurns();
	}
}
