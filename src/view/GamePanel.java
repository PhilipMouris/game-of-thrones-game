package view;

import javax.swing.*;
import controller.ControlPanel;
import controller.DirectionButton;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;

import java.awt.*;
import java.awt.event.*;

import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public class GamePanel extends JPanel implements ActionListener{
	
	private MainFrame frame;
	private Game game;
	private DeadPanel1 dead1;
	private DeadPanel2 dead2;
	private BoardPanel board;
	private ProgressBarPanel progress;
	private ControlPanel control;
	private BottomPanel bottom;
	private Piece currentPiece;
	private boolean powerFlag;
	private boolean medicFlag;
	private boolean techFlag;
	private boolean teleportFlag;
	private Point point;
	private Piece revived;
	private boolean reviveFlag;
	
	public GamePanel(Game game,MainFrame frame) {
		super();
		this.frame=frame;
		this.game=game;
		setLayout(new BorderLayout());
		setOpaque(false);
		board = new BoardPanel(game,this);
		JPanel boardBack = new JPanel();
		board.setPreferredSize(new Dimension(700,600));
		boardBack.setOpaque(false);
		boardBack.add(board);
		add(boardBack,BorderLayout.CENTER);
		progress = new ProgressBarPanel();
		add(progress,BorderLayout.NORTH);
		dead1 = new DeadPanel1(game,this);
		add(dead1,BorderLayout.WEST);
		dead2 = new DeadPanel2(game,this);
		add(dead2,BorderLayout.EAST);
		control = new ControlPanel(this);
		bottom = new BottomPanel(control,game);
		add(bottom,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof BoardButton)&&powerFlag==false&&techFlag==false&&medicFlag==false)
			currentPiece=((BoardButton) e.getSource()).getGameCell().getPiece();
		if((e.getSource() instanceof DirectionButton)&&powerFlag==false&&techFlag==false&&medicFlag==false&&currentPiece!=null)
			try {
				currentPiece.move(((DirectionButton) e.getSource()).getR());
			} catch (OccupiedCellException | UnallowedMovementException | WrongTurnException e1) {
				// TODO Auto-generated catch block
				JFrame error = new JFrame();
				error.setSize(400,100);
				JLabel message = new JLabel(e1.getMessage());
				error.getContentPane().add(message);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				error.setLocation(dim.width/2-error.getSize().width/2, dim.height/2-error.getSize().height/2);
				error.setVisible(true);
			}
			finally {
				currentPiece=null;
			}
		if(e.getActionCommand().equals("Power")&&currentPiece!=null)
			if(currentPiece instanceof Super||currentPiece instanceof Ranged)
				powerFlag=true;
			else
				if(currentPiece instanceof Tech)
					techFlag=true;
				else
					if(currentPiece instanceof Medic)
						medicFlag=true;
		if((e.getSource() instanceof DirectionButton)&&powerFlag==true&&techFlag==false&&medicFlag==false&&currentPiece!=null) {
			try {
				((ActivatablePowerHero) currentPiece).usePower(((DirectionButton)e.getSource()).getR(),null,null);
			} catch (PowerAlreadyUsedException | InvalidPowerDirectionException | InvalidPowerTargetException
					| WrongTurnException e1) {
				// TODO Auto-generated catch block
				JFrame error = new JFrame();
				error.setSize(400,100);
				JLabel message = new JLabel(e1.getMessage());
				error.getContentPane().add(message);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				error.setLocation(dim.width/2-error.getSize().width/2, dim.height/2-error.getSize().height/2);
				error.setVisible(true);
			}
			finally {
				powerFlag=false;
				currentPiece=null;
			}
		}
		if((e.getSource() instanceof BoardButton)&&techFlag==true&&powerFlag==false&&medicFlag==false&&currentPiece!=null&&teleportFlag==false)
			if(((BoardButton)e.getSource()).getGameCell().getPiece()==null) {
				teleportFlag=true;
				point = new Point(((BoardButton)e.getSource()).getI(),((BoardButton)e.getSource()).getJ());
			} else
				try {
					((ActivatablePowerHero) currentPiece).usePower(null,((BoardButton)e.getSource()).getGameCell().getPiece(),null);
				} catch (PowerAlreadyUsedException | InvalidPowerDirectionException | InvalidPowerTargetException
						| WrongTurnException e1) {
					// TODO Auto-generated catch block
					JFrame error = new JFrame();
					error.setSize(400,100);
					JLabel message = new JLabel(e1.getMessage());
					error.getContentPane().add(message);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					error.setLocation(dim.width/2-error.getSize().width/2, dim.height/2-error.getSize().height/2);
					error.setVisible(true);
				}
				finally {
					techFlag=false;
					currentPiece=null;
				}
		if((e.getSource() instanceof BoardButton)&&techFlag==true&&powerFlag==false&&medicFlag==false&&currentPiece!=null&&teleportFlag==true)
			if(((BoardButton)e.getSource()).getGameCell().getPiece()!=null)
				try {
					((ActivatablePowerHero) currentPiece).usePower(null,((BoardButton)e.getSource()).getGameCell().getPiece(),point);
				} catch (PowerAlreadyUsedException | InvalidPowerDirectionException | InvalidPowerTargetException
						| WrongTurnException e1) {
					// TODO Auto-generated catch block
					JFrame error = new JFrame();
					error.setSize(400,100);
					JLabel message = new JLabel(e1.getMessage());
					error.getContentPane().add(message);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					error.setLocation(dim.width/2-error.getSize().width/2, dim.height/2-error.getSize().height/2);
					error.setVisible(true);
				}
				finally {
					techFlag=false;
					teleportFlag=false;
					point=null;
				}
		if((e.getSource() instanceof DeadButton)&&medicFlag==true&&powerFlag==false&&techFlag==false&&reviveFlag==false&&currentPiece!=null) {
			revived=((DeadButton) e.getSource()).getDeadPiece();
			reviveFlag=true;
		}
		if((e.getSource() instanceof DirectionButton)&&medicFlag==true&&powerFlag==false&&techFlag==false&&reviveFlag==true&&currentPiece!=null) {
			try {
				((ActivatablePowerHero) currentPiece).usePower(((DirectionButton) e.getSource()).getR(),revived,null);
			} catch (PowerAlreadyUsedException | InvalidPowerDirectionException | InvalidPowerTargetException
					| WrongTurnException e1) {
				// TODO Auto-generated catch block
				JFrame error = new JFrame();
				error.setSize(400,100);
				JLabel message = new JLabel(e1.getMessage());
				error.getContentPane().add(message);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				error.setLocation(dim.width/2-error.getSize().width/2, dim.height/2-error.getSize().height/2);
				error.setVisible(true);
			}
			finally {
				medicFlag=false;
				reviveFlag=false;
				revived=null;
			}
		}
		board.removeAll();
		for(int i=0;i<7;i++)
			for(int j=0;j<6;j++) {
				BoardButton button = new BoardButton(game.getCellAt(i,j),i,j);
				button.addActionListener(this);
				board.add(button);
		}
		board.revalidate();
		board.repaint();
		dead1.removeAll();
		for(int i=0;i<game.getPlayer1().getDeadCharacters().size();i++) {
			DeadButton button = new DeadButton(game.getPlayer1().getDeadCharacters().get(i));
			button.addActionListener(this);
			dead1.add(button);
		}
		dead1.revalidate();
		dead1.repaint();
		dead2.removeAll();
		for(int i=0;i<game.getPlayer2().getDeadCharacters().size();i++) {
			DeadButton button = new DeadButton(game.getPlayer2().getDeadCharacters().get(i));
			button.addActionListener(this);
			dead2.add(button);
		}
		dead2.revalidate();
		dead2.repaint();
		progress.removeAll();
		progress.getBar1().setValue(game.getPlayer1().getPayloadPos());
		progress.getBar2().setValue(game.getPlayer2().getPayloadPos());
		progress.add(progress.getStarks());
		progress.add(progress.getLannisters());
		progress.add(progress.getBar1());
		progress.add(progress.getBar2());
		progress.revalidate();
		progress.repaint();
		bottom.removeAll();
		if(game.getCurrentPlayer()==game.getPlayer1())
			bottom.getSigil().setIcon(new ImageIcon("resources/pic2.png"));
		else
			bottom.getSigil().setIcon(new ImageIcon("resources/pic3.png"));
		bottom.setTurn(new JLabel("Your move "+game.getCurrentPlayer().getName()));
		bottom.getTurn().setFont(new Font("Game of Thrones",Font.PLAIN,20));
		bottom.add(control);
		bottom.add(bottom.getSigil());
		bottom.add(bottom.getTurn());
		bottom.revalidate();
		bottom.repaint();
		if(game.checkWinner()) {
			frame.setWin(new WinningPanel(frame,game));
			frame.getContentPane().add(frame.getWin());
			((CardLayout) frame.getContentPane().getLayout()).next(frame.getContentPane());
		}
	}
}
