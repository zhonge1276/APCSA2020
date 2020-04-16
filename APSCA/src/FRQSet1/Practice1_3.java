package FRQSet1;
import java.util.*;

public class Practice1_3{
	public class NumberTile{
		private int[] tile = {1,2,3,4};
		public void rotate() {
			for(int i=0; i<4; i++) {
				int temp = tile[i];
				tile[i] = tile[i+1];
				tile[i+1] = temp;
			}
		}
		public int getLeft() {
			return tile[0];
		}
		public int getRight() {
			return tile[2];
		}
	}
	
	public class TileGame{
		private ArrayList<NumberTile> board;
		public TileGame() {
			board = new ArrayList<NumberTile>();
		}
		
		private int getIndexForFit(NumberTile tile) {
			int left = tile.getLeft();
			int right = tile.getRight();
			for(int i=0; i<board.size() - 1; i++) {
				if(board.get(i).getRight() == left && board.get(i+1).getLeft() == right) {
					return i+1;
				}
			}
			if(board.get(0).getLeft() == right) {
				return 0;
			}
			if(board.get(board.size()-1).getRight() == left) {
				return board.size()-1;
			}
			return -1;
		}
		
		public boolean insertTile(NumberTile tile) {
			NumberTile till = tile;
			for(int i=0; i<4; i++) {
				if(getIndexForFit(till) > -1) {
					board.add(getIndexForFit(till), till);
					return true;
				} else {
					till.rotate();
				}
			}
			return false;
		}
	}
}
