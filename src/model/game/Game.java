package model.game;

import java.util.ArrayList;
import java.util.Collections;

import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Game {

	private final int payloadPosTarget = 6;
	private final int boardWidth = 6;
	private final int boardHeight = 7;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Cell[][] board;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		currentPlayer = player1;
		board = new Cell[boardHeight][boardWidth];
		this.assemblePieces();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}

	@Override
	public String toString() {
		String s = "";
		System.out.println("      " + getPlayer2().getName());
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null)
					System.out.print("n ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		System.out.println("    " + getPlayer1().getName());
		return s;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}
	
	public void assemblePieces() {
		for(int i=0;i<7;i++)
			for(int j=0;j<6;j++)
				board[i][j]=new Cell();
		ArrayList<Hero> p1Heros = new ArrayList<>();
		Armored armored1 = new Armored(player1,this,"Hodor");
		Medic medic1 = new Medic(player1,this,"Catelyn Stark");
		Ranged ranged1 = new Ranged(player1,this,"Jon Snow");
		Speedster speedster1 = new Speedster(player1,this,"Arya Stark");
		Super super1 = new Super(player1,this,"Ned Stark");
		Tech tech1 = new Tech(player1,this,"Brandon Stark");
		p1Heros.add(armored1);
		p1Heros.add(medic1);
		p1Heros.add(ranged1);
		p1Heros.add(speedster1);
		p1Heros.add(super1);
		p1Heros.add(tech1);
		Collections.shuffle(p1Heros);
		for(int i=0;i<6;i++) {
			board[5][i].setPiece(p1Heros.get(i));
			board[5][i].getPiece().setPosI(5);
			board[5][i].getPiece().setPosJ(i);
		}
		for(int i=0;i<6;i++) {
			board[4][i].setPiece(new SideKickP1(this,"Theon Greyjoy"));
			board[4][i].getPiece().setPosI(4);
			board[4][i].getPiece().setPosJ(i);
		}
		ArrayList<Hero> p2Heros = new ArrayList<>();
		Armored armored2 = new Armored(player2,this,"The Hound");
		Medic medic2 = new Medic(player2,this,"Cersei Lannister");
		Ranged ranged2 = new Ranged(player2,this,"Jamie Lannister");
		Speedster speedster2 = new Speedster(player2,this,"Bronn");
		Super super2 = new Super(player2,this,"Tywin Lannister");
		Tech tech2 = new Tech(player2,this,"Tyrion Lannister");
		p2Heros.add(armored2);
		p2Heros.add(medic2);
		p2Heros.add(ranged2);
		p2Heros.add(speedster2);
		p2Heros.add(super2);
		p2Heros.add(tech2);
		Collections.shuffle(p2Heros);
		for(int i=0;i<6;i++) {
			board[1][i].setPiece(p2Heros.get(i));
			board[1][i].getPiece().setPosI(1);
			board[1][i].getPiece().setPosJ(i);
		}
		for(int i=0;i<6;i++) {
			board[2][i].setPiece(new SideKickP2(this,"Joffrey Baratheon"));
			board[2][i].getPiece().setPosI(2);
			board[2][i].getPiece().setPosJ(i);
		}
	}
	
	public Cell getCellAt(int i,int j) {
		return board[i][j];
	}
	
	public void switchTurns() {
		if(currentPlayer==player1)
			currentPlayer=player2;
		else
			currentPlayer=player1;
	}
	
	public boolean checkWinner() {
		if(player1.getPayloadPos()==payloadPosTarget||player2.getPayloadPos()==payloadPosTarget)
			return true;
		return false;
	}
	
	

}
