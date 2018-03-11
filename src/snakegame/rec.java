package snakegame;

public class rec implements Comparable {
	int x1;
	int y1;
	int x2;
	int y2;
	int size;
	rec(int x1, int y1,int size) {
		this.x1 = (x1+300)%300;
		this.y1 = (y1+300)%300;
		this.x2 = (x1+size+300)%300;
		this.y2 = (y1+size+300)%300;
		this.size=size;
	}

	@Override
	public int compareTo(Object arg0) {
		rec x=(rec)arg0;
		if(this.x1==x.x1&&this.y1==x.y1) {
			return 0;
		}
		return  1;
	}
}
