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

public class SideKickP1 extends SideKick {

	public SideKickP1(Game game, String name) {
		super(game.getPlayer1(), game, name);
	}
	
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getGame().getCurrentPlayer()!=this.getOwner())
			throw new WrongTurnException("Wrong Turn",this);
		if(r==Direction.DOWNLEFT||r==Direction.DOWNRIGHT||r==Direction.DOWN)
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
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Armored(this.getOwner(),this.getGame(),"Hodor"));
		if(target instanceof Medic)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Medic(this.getOwner(),this.getGame(),"Catelyn Stark"));
		if(target instanceof Ranged)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Ranged(this.getOwner(),this.getGame(),"Jon Snow"));
		if(target instanceof Speedster)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Speedster(this.getOwner(),this.getGame(),"Arya Stark"));
		if(target instanceof Super)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Super(this.getOwner(),this.getGame(),"Ned Stark"));
		if(target instanceof Tech)
			this.getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(new Tech(this.getOwner(),this.getGame(),"Brandon Stark"));

	}

}
