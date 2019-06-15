package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public class SideKickP2 extends SideKick {

	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(), game, name);
	}
	
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		if(r==Direction.UP||r==Direction.UPLEFT||r==Direction.UPRIGHT)
			throw new UnallowedMovementException("Unallowed Movement",this,r);
		super.move(r);
	}
	
	public void attack(Piece target) {
		super.attack(target);
		if(target instanceof SideKickP1||target instanceof SideKickP2)
			return;
		if(target.getGame().getCellAt(target.getPosI(),target.getPosJ()).getPiece()!=null)
			return;
		if(target instanceof Armored)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Armored(this.getOwner(),this.getGame(),"The Mountain"));
		if(target instanceof Medic)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Medic(this.getOwner(),this.getGame(),"Cersei Lannister"));
		if(target instanceof Ranged)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Ranged(this.getOwner(),this.getGame(),"Jamie Lannister"));
		if(target instanceof Speedster)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Speedster(this.getOwner(),this.getGame(),"Bronn"));
		if(target instanceof Super)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Super(this.getOwner(),this.getGame(),"Tywin Lannister"));
		if(target instanceof Tech)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Tech(this.getOwner(),this.getGame(),"Tyrion Lannister"));

	}

}
