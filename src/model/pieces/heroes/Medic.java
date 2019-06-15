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

public class Medic extends ActivatablePowerHero {

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "M";
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
		if(target.getOwner()!=this.getOwner())
			throw new InvalidPowerTargetException("Target belongs to the enemy team",this,target);
		if(target.getOwner()==this.getOwner()&&(!this.getOwner().getDeadCharacters().contains(target)))
			throw new InvalidPowerTargetException("Target has not been eliminated before, cannot be revived",this,target);
		int[] x = targetCellPower(getPosI(),getPosJ(),r);
		if(target.getOwner()==this.getOwner()&&this.getGame().getCellAt(x[0], x[1]).getPiece()!=null)
			throw new InvalidPowerTargetException("Target location is occupied",this,target);
		this.getGame().getCellAt(x[0],x[1]).setPiece(target);
		if(target instanceof Armored)
			((Armored) target).setArmorUp(true);
		if(target instanceof Ranged)
			((Ranged) target).setPowerUsed(false);
		if(target instanceof Super)
			((Super) target).setPowerUsed(false);
		if(target instanceof Tech)
			((Tech) target).setPowerUsed(false);
		if(target instanceof Medic)
			((Medic) target).setPowerUsed(false);
		this.getOwner().getDeadCharacters().remove(target);
		target.setPosI(x[0]);
		target.setPosJ(x[1]);
		setPowerUsed(true);
		getGame().switchTurns();
	}
}
