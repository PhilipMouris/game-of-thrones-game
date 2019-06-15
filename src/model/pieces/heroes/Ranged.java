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

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
		super(player, game, name);
	}

	public String toString() {
		return "R";
	}
	
	public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		super.move(r);
	}
	
	public int[] targetCellPower(int i,int j,Direction r) {
		if(r==Direction.RIGHT)
			return new int[] {i,j+1};
		if(r==Direction.LEFT)
			return new int[] {i,j-1};
		if(r==Direction.UP)
			return new int[] {i-1,j};
		return new int[] {i+1,j};
	}
	
	public void usePower(Direction r,Piece target,Point newPos) throws PowerAlreadyUsedException, InvalidPowerDirectionException, WrongTurnException, InvalidPowerTargetException {
		super.usePower(r, target, newPos);
		if(r==Direction.DOWNLEFT||r==Direction.DOWNRIGHT||r==Direction.UPLEFT||r==Direction.UPRIGHT)
			throw new InvalidPowerDirectionException("Power Direction is not allowed",this,r);
		int[] x = targetCellPower(getPosI(),getPosJ(),r);
		while(!(x[0]==-1||x[0]==7||x[1]==-1||x[1]==6)) {
			if(this.getGame().getCellAt(x[0],x[1]).getPiece()==null)
				x = targetCellPower(x[0],x[1],r);
			else
				if(this.getGame().getCellAt(x[0],x[1]).getPiece().getOwner()==this.getOwner())
					throw new InvalidPowerDirectionException("This direction will result in hitting a friendly piece",this,r);
				else {
					attack(this.getGame().getCellAt(x[0],x[1]).getPiece());
					setPowerUsed(true);
					this.getGame().switchTurns();
					return;
					}
		}
		throw new InvalidPowerDirectionException("This direction will result in hitting no enemies",this,r);
	}
}
