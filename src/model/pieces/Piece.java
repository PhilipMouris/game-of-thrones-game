package model.pieces;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public abstract class Piece implements Movable {

	private String name;
	private Player owner;
	private Game game;
	private int posI;
	private int posJ;

	public Piece(Player p, Game g, String name) {
		this.owner = p;
		this.game = g;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int i) {
		posI = i;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int j) {
		posJ = j;
	}

	public Game getGame() {
		return game;
	}

	public Player getOwner() {
		return owner;
	}
	
	public void attack(Piece target) {
		if(target instanceof Armored)
			if(((Armored) target).isArmorUp()) {
				((Armored) target).setArmorUp(false);
				return;
			}
		target.owner.getDeadCharacters().add(target);
		if(target instanceof SideKickP1||target instanceof SideKickP2) {
			this.owner.setSideKilled(this.owner.getSideKilled()+1);
			if(this.owner.getSideKilled()%2==0) 
				this.owner.setPayloadPos(this.owner.getPayloadPos()+1);
		}
		else
			this.owner.setPayloadPos(this.owner.getPayloadPos()+1);
		game.getCellAt(target.posI,target.posJ).setPiece(null);
		game.checkWinner();
	}
	
	public void moveDown() {
		int[] x = targetCell(posI,posJ,Direction.DOWN);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveUp() {
		int[] x = targetCell(posI,posJ,Direction.UP);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveLeft() {
		int[] x = targetCell(posI,posJ,Direction.LEFT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveRight() {
		int[] x = targetCell(posI,posJ,Direction.RIGHT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveDownLeft() {
		int[] x = targetCell(posI,posJ,Direction.DOWNLEFT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveDownRight() {
		int[] x = targetCell(posI,posJ,Direction.DOWNRIGHT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveUpLeft() {
		int[] x = targetCell(posI,posJ,Direction.UPLEFT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public void moveUpRight() {
		int[] x = targetCell(posI,posJ,Direction.UPRIGHT);
		game.getCellAt(x[0],x[1]).setPiece(this);
		game.getCellAt(posI, posJ).setPiece(null);
		posI=x[0];
		posJ=x[1];
	}
	
	public int[] targetCell(int i,int j,Direction r) {
		if(r==Direction.RIGHT) {
			if(j==5)
				return new int[] {i,0};
			else
				return new int[] {i,j+1};
		}
		if(r==Direction.LEFT) {
			if(j==0)
				return new int[] {i,5};
			else
				return new int[] {i,j-1};
		}
		if(r==Direction.UP) {
			if(i==0)
				return new int[] {6,j};
			else
				return new int[] {i-1,j};
		}
		if(r==Direction.DOWN) {
			if(i==6)
				return new int[] {0,j};
			else
				return new int[] {i+1,j};
		}
		if(r==Direction.UPRIGHT) {
			if(i==0 && j==5)
				return new int[] {6,0};
			else
				if(i==0)
					return new int[] {6,j+1};
				else
					if(j==5)
						return new int[] {i-1,0};
					else
						return new int[] {i-1,j+1};
		}
		if(r==Direction.UPLEFT) {
			if(i==0 && j==0)
				return new int[] {6,5};
			else
				if(i==0)
					return new int[] {6,j-1};
				else
					if(j==0)
						return new int[] {i-1,5};
					else
						return new int[] {i-1,j-1};
		}
		if(r==Direction.DOWNRIGHT) {
			if(i==6 && j==5)
				return new int[] {0,0};
			else
				if(i==6)
					return new int[] {0,j+1};
				else
					if(j==5)
						return new int[] {i+1,0};
					else
						return new int[] {i+1,j+1};
		}
		if(r==Direction.DOWNLEFT) {
			if(i==6 && j==0)
				return new int[] {0,5};
			else
				if(i==6)
					return new int[] {0,j-1};
				else
					if(j==0)
						return new int[] {i+1,5};
		}
		return new int[] {i+1,j-1};
	}
	
	public void move(Direction r) throws OccupiedCellException, WrongTurnException, UnallowedMovementException {
		int[] x = targetCell(posI,posJ,r);
		if(game.getCellAt(x[0],x[1]).getPiece()!=null)
			if(game.getCellAt(x[0],x[1]).getPiece().getOwner()==owner)
				throw new OccupiedCellException("Cell is occupied",this,r);
		if(game.getCellAt(x[0],x[1]).getPiece()!=null)
			attack(game.getCellAt(x[0],x[1]).getPiece());
		if(game.getCellAt(x[0],x[1]).getPiece()==null)
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
		game.switchTurns();
	}
	
	public int[] targetCellPower(int i,int j,Direction r) {
		if(r==Direction.RIGHT) {
			if(j==5)
				return new int[] {i,0};
			else
				return new int[] {i,j+1};
		}
		if(r==Direction.LEFT) {
			if(j==0)
				return new int[] {i,5};
			else
				return new int[] {i,j-1};
		}
		if(r==Direction.UP) {
			if(i==0)
				return new int[] {6,j};
			else
				return new int[] {i-1,j};
		}
		if(r==Direction.DOWN) {
			if(i==6)
				return new int[] {0,j};
			else
				return new int[] {i+1,j};
		}
		if(r==Direction.UPRIGHT) {
			if(i==0 && j==5)
				return new int[] {6,0};
			else
				if(i==0)
					return new int[] {6,j+1};
				else
					if(j==5)
						return new int[] {i-1,0};
					else
						return new int[] {i-1,j+1};
		}
		if(r==Direction.UPLEFT) {
			if(i==0 && j==0)
				return new int[] {6,5};
			else
				if(i==0)
					return new int[] {6,j-1};
				else
					if(j==0)
						return new int[] {i-1,5};
					else
						return new int[] {i-1,j-1};
		}
		if(r==Direction.DOWNRIGHT) {
			if(i==6 && j==5)
				return new int[] {0,0};
			else
				if(i==6)
					return new int[] {0,j+1};
				else
					if(j==5)
						return new int[] {i+1,0};
					else
						return new int[] {i+1,j+1};
		}
		if(r==Direction.DOWNLEFT) {
			if(i==6 && j==0)
				return new int[] {0,5};
			else
				if(i==6)
					return new int[] {0,j-1};
				else
					if(j==0)
						return new int[] {i+1,5};
		}
		return new int[] {i+1,j-1};
	}
}
