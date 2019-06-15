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

public class Tech extends ActivatablePowerHero {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		if(r==Direction.LEFT||r==Direction.DOWN||r==Direction.UP||r==Direction.RIGHT)
			throw new UnallowedMovementException("Unallowed Movement",this,r);
		super.move(r);
	}
	
	public void usePower(Direction r,Piece target,Point newPos) throws PowerAlreadyUsedException, InvalidPowerDirectionException, InvalidPowerTargetException, WrongTurnException {
		super.usePower(r, target, newPos);
		if(newPos!=null) {
			if(target.getOwner()!=this.getOwner())
				throw new InvalidPowerTargetException("Target piece belongs to the enemy",this,target);
			if(this.getGame().getCellAt((int) newPos.getX(),(int)newPos.getY()).getPiece()!=null)
				throw new InvalidPowerTargetException("Target location is occupied",this,target);
			this.getGame().getCellAt((int)newPos.getX(),(int) newPos.getY()).setPiece(target);
			this.getGame().getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
			target.setPosI((int)newPos.getX());
			target.setPosJ((int)newPos.getY());
		}
		else {
			if(target.getOwner()!=this.getOwner()) {
				if(target instanceof Armored) {
					if(((Armored) target).isArmorUp())
						((Armored) target).setArmorUp(false);
					else
						throw new InvalidPowerTargetException("Enemy has already used its power and cannot be hacked",this,target);
				}
				else {
					if(((ActivatablePowerHero) target).isPowerUsed())
						throw new InvalidPowerTargetException("Enemy has already used its power and cannot be hacked",this,target);
					else
						((ActivatablePowerHero) target).setPowerUsed(true);
				}
			}
			else {
				if(target instanceof Armored) {
					if(((Armored) target).isArmorUp())
						throw new InvalidPowerTargetException("Target piece did not use its power yet",this,target);
					else
						((Armored) target).setArmorUp(true);
				}
				else {
					if(((ActivatablePowerHero) target).isPowerUsed())
						((ActivatablePowerHero) target).setPowerUsed(false);
					else
						throw new InvalidPowerTargetException("Target piece did not use its power yet",this,target);
				}
			}
		}
		this.setPowerUsed(true);
	}
}
