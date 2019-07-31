package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyChessAndGoGame {

	public Set<String> supportGameType = new HashSet<String>() {
		{
			add("chess");  //象棋
			add("go");  //围棋
		}
	};
	public Game game;
	public String playerANameString, playerBNameString;
	public ArrayList<Player> players = new ArrayList<Player>();

	public void printMenu() {
		System.out.println("1.\t将尚未在棋盘上的一颗棋子放在棋盘上的指定位置");
		System.out.println("2.\t移动棋盘上的某个位置的棋子至新的位置");
		System.out.println("3.\t提子（移除对手棋子）");
		System.out.println("4.\t吃子（使用己方棋子吃掉对手棋子）");
		System.out.println("5.\t查询某个位置的占用情况");
		System.out.println("6.\t计算两个玩家分别在棋盘上的棋子总数");
		System.out.println("7.\t跳过");
		System.out.println("end.\t 结束操作");
	}

	public void gameMain()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BufferedReader reader = null;
		String[] splitItems;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println(
						String.format("输入游戏类型\t%s:", supportGameType.stream().reduce((a, b) -> a + ",\t" + b)));
				
				
				///不能复用的部分用strLine判断///
				String strLine = reader.readLine().trim();
				if (supportGameType.contains(strLine)) {
					game = new Game(strLine);
					break;
				} else {
					System.out.println("输入错误，请重新输入");
				}
			}
			System.out.println("[用户A]\t请输入您的名称");
			playerANameString = reader.readLine().trim();
			System.out.println("[用户B]\t请输入您的名称");
			playerBNameString = reader.readLine().trim();
			game.iniGameWithPlayerName(playerANameString, playerBNameString);

			players.add(game.getPlayerA());
			players.add(game.getPlayerB());
			System.out.println(String.format("%s，%s，游戏开始，请依次操作", playerANameString, playerBNameString));

			int pNI = 0;
			while (true) {
				System.out.println();
				System.out.println(String.format("->[%s]", players.get(pNI).getPlayerName()));
				printMenu();
				String strLine = reader.readLine().trim();
				boolean exitFlag = false;
				switch (strLine) {
				case "1": // 围棋
					//将尚未在棋盘上的一颗棋子放在棋盘上的指定位置
					System.out.println("输入pieceName edX edY,pieceName为名称_i：");
					strLine = reader.readLine().trim();
					splitItems = strLine.split(" ");
					if (splitItems.length == 3) {
						try {
							int px = Integer.valueOf(splitItems[1]);
							int py = Integer.valueOf(splitItems[2]);
							String pName = splitItems[0];
							//System.out.println(px + " " + py + " " + pName);
							Player player = players.get(pNI);

							boolean find = false;
							Piece p_res = null;
							Iterator<Piece> iterator = null;
							if (pNI == 0)
								iterator = game.getPlayerA().getPlayerPieces().iterator();
							else
								iterator = game.getPlayerB().getPlayerPieces().iterator();
							while (iterator.hasNext()) {
								Piece findpiece = iterator.next();
								if (findpiece.getpName().equals(pName) && findpiece.getPieceState() == 0) {
									find = true;
									p_res = findpiece;
									break;
								}
							}
							//异常情况处理
							if (px < 1 || px > 18 | py < 1 | py > 18) {
								System.out.println(String.format("( %d , %d ) 输入位置违规", px, py));
								continue;
							} else if (!game.getGameAction().getGameBoard().getBoardSet()[px][py].equals("")) {
								System.out.println(String.format("( %d , %d ) 已被占用", px, py));
								continue;
							} else if (!find) {
								System.out.println(String.format("%s 没有未放置的 %s 棋子", player.getPlayerName(), pName));
								continue;
							}
							game.putPiece(player, p_res, new Position(px, py));
							pNI = (pNI + 1) % 2;
							System.out.println("[SUCCESS]");
						} catch (NumberFormatException e) {
							System.out.println("输入类型错误，重新输入");
							continue;
						}
					} else {
						System.out.println("输入错误，请重新输入");
						continue;
					}
					break;
				case "2": // 象棋
					//移动棋盘上的某个位置的棋子至新的位置
					System.out.println("输入(stX stY edX edY)：");
					strLine = reader.readLine().trim();
					splitItems = strLine.split("\\s");
					if (splitItems.length == 4) {
						try {
							int stX = Integer.valueOf(splitItems[0]), stY = Integer.valueOf(splitItems[1]),
									edX = Integer.valueOf(splitItems[2]), edY = Integer.valueOf(splitItems[3]);
							Player player = players.get(pNI);
							if(!game.movePiece(player, new Position(stX, stY), new Position(edX, edY))) {
								continue;
							}
							pNI = (pNI + 1) % 2;
							System.out.println("[SUCCESS]");
						} catch (NumberFormatException e) {
							System.out.println("输入类型错误，重新输入");
							continue;
						}
					} else {
						System.out.println("输入错误，请重新输入");
						continue;
					}
					break;
				case "3": // 围棋
					//提子
					System.out.println("输入edX edY：");
					strLine = reader.readLine().trim();
					splitItems = strLine.split(" ");
					if (splitItems.length == 2) {
						try {
							int px = Integer.valueOf(splitItems[0]);
							int py = Integer.valueOf(splitItems[1]);
							Player player = players.get(pNI);
							if (game.getGameAction().getGameBoard().getBoardSet()[px][py].equals("")) {
								System.out.println(String.format("( %d , %d ) 无子可提", px, py));
								continue;
							} else if (game.getGameAction().getGameBoard().getBoardSet()[px][py]
									.startsWith(player.getPlayerName())) {
								System.out.println(String.format("%s 所提棋子不是对方棋子",
										game.getGameAction().getGameBoard().getBoardSet()[px][py]));
								continue;
							}
							game.removePiece(player, new Position(px, py));
							pNI = (pNI + 1) % 2;
							System.out.println("[SUCCESS]");

						} catch (NumberFormatException e) {
							System.out.println("输入类型错误，重新输入");
							continue;
						}
					} else {
						System.out.println("输入错误，请重新输入");
						continue;
					}
					break;
				case "4": // 象棋
					//吃子
					System.out.println("输入(stX stY edX edY)：");
					strLine = reader.readLine().trim();
					splitItems = strLine.split("\\s");
					if (splitItems.length == 4) {
						try {
							int stX = Integer.valueOf(splitItems[0]), stY = Integer.valueOf(splitItems[1]),
									edX = Integer.valueOf(splitItems[2]), edY = Integer.valueOf(splitItems[3]);
							Player player = players.get(pNI);
							if(!game.eatPiece(player, new Position(stX, stY), new Position(edX, edY))) {
								continue;
							}
							
							pNI = (pNI + 1) % 2;
							System.out.println("[SUCCESS]");
						} catch (NumberFormatException e) {
							System.out.println("输入类型错误，重新输入");
							continue;
						}
					} else {
						System.out.println("输入错误，请重新输入");
						continue;
					}
					break;
				case "5":
					//查询某个位置的占用情况
					System.out.println("输入edX edY：");
					strLine = reader.readLine().trim();
					splitItems = strLine.split(" ");
					if (splitItems.length == 2) {
						try {
							int px = Integer.valueOf(splitItems[0]);
							int py = Integer.valueOf(splitItems[1]);

							if (game.getGameAction().getGameBoard().getBoardSet()[px][py].equals("")) {
								System.out.println("该位置没有棋子");
							} else {
								System.out.println(String.format("该位置为  %s 棋子",
										game.getGameAction().getGameBoard().getBoardSet()[px][py]));
								
							}

						} catch (NumberFormatException e) {
							System.out.println("输入类型错误，重新输入");
							continue;
						}
					} else {
						System.out.println("输入错误，请重新输入");
						continue;
					}
					break;
				case "6":
					//计算两个玩家分别在棋盘上的棋子总数
					System.out.println(String.format("玩家\t%s\t在棋盘上的棋子总数为%d", players.get(0).getPlayerName(),
							game.getNumOfPlayerPiecesInBoard(players.get(0))));
					System.out.println(String.format("玩家\t%s\t在棋盘上的棋子总数为%d", players.get(1).getPlayerName(),
							game.getNumOfPlayerPiecesInBoard(players.get(1))));
					break;
				case "7":
					//跳过
					System.out.println("[跳过]");
					pNI = (pNI + 1) % 2;
					break;
				case "end":
					//结束游戏操作
					System.out.println("-------->>> END GAME <<<--------");
					exitFlag = true;
					break;
				default:
					System.out.println("输入错误，请重新输入");
					break;
				}
				if (exitFlag)
					break;
			}

			//询问是否查看本次比赛的走棋历史
			pNI = 0;
			for(pNI=0;pNI<2;pNI++) {
				while(true) {
					System.out.println();
					System.out.println(String.format("->[%s]", players.get(pNI).getPlayerName()));
					System.out.println("是否需要查看本次游戏操作历史？[yes,no]");
					boolean exitFlag = true;
					switch(reader.readLine().trim()) {
						case "yes":
							System.out.println(game.getGameHistoryString(players.get(pNI)));
							break;
						case "no":
							break;
						default:
							exitFlag = false;
							break;
					}
					if(exitFlag) break;
				}	
			}
			System.out.println("游戏结束，再见！");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		new MyChessAndGoGame().gameMain();
	}

}