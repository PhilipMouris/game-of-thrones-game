package model.pieces.heroes;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero {

	private boolean armorUp;

	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		this.armorUp = true;
	}

	public boolean isArmorUp() {
		return armorUp;
	}

	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}

	@Override
	public String toString() {
		return "A";
	}
	
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		super.move(r);
	}

}
