package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Super extends ActivatablePowerHero {

	public Super(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		if(r==Direction.DOWNLEFT||r==Direction.DOWNRIGHT||r==Direction.UPLEFT||r==Direction.UPRIGHT)
			throw new UnallowedMovementException("Unallowed Movement",this,r);
		super.move(r);
	}
	
	public void usePower(Direction r,Piece target,Point newPos) throws PowerAlreadyUsedException, WrongTurnException, InvalidPowerDirectionException, InvalidPowerTargetException {
		super.usePower(r, target, newPos);
		if(r==Direction.DOWNLEFT||r==Direction.DOWNRIGHT||r==Direction.UPLEFT||r==Direction.UPRIGHT)
			throw new InvalidPowerDirectionException("Power Direction is not allowed",this,r);
		int[] x = targetCellPower(getPosI(),getPosJ(),r);
		if(this.getGame().getCellAt(x[0],x[1]).getPiece()!=null)
			if(this.getGame().getCellAt(x[0], x[1]).getPiece().getOwner()!=this.getOwner())
				attack(this.getGame().getCellAt(x[0], x[1]).getPiece());
		x = targetCellPower(x[0],x[1],r);
		if(this.getGame().getCellAt(x[0],x[1]).getPiece()!=null)
			if(this.getGame().getCellAt(x[0], x[1]).getPiece().getOwner()!=this.getOwner())
				attack(this.getGame().getCellAt(x[0], x[1]).getPiece());
		setPowerUsed(true);
		this.getGame().switchTurns();
	}
	
	public int[] targetCellPower(int i,int j,Direction r) {
		if(r==Direction.RIGHT) {
			if(j==5)
				return new int[] {i,5};
			else
				return new int[] {i,j+1};
		}
		if(r==Direction.LEFT) {
			if(j==0)
				return new int[] {i,0};
			else
				return new int[] {i,j-1};
		}
		if(r==Direction.UP) {
			if(i==0)
				return new int[] {0,j};
			else
				return new int[] {i-1,j};
		}
		if(r==Direction.DOWN)
			if(i==6)
				return new int[] {6,j};
		return new int[] {i+1,j};
	}
}


