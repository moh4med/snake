package snakegame;

import java.util.ArrayList;

public class Snake {
	public enum movetype {
		none, up, down, left, right;
	}

	ArrayList<rec> recs;
	movetype mmovetype = movetype.right;
	int size = 10;

	Snake(int x1, int y1, int size) {
		recs = new ArrayList<>();
		additem(x1, y1);
		this.size = size;

	}

	public void additem() {
		rec lastrec = recs.get(recs.size() - 1);
		additem(lastrec.x2, lastrec.y1);
	}

	public void additem(int x1, int y1) {
		addrec(x1, y1, x1 + size, y1 + size);
	}

	private void addrec(int x1, int y1, int x2, int y2) {
		recs.add(new rec(x1, y1, size));
	}

	public void move() {
		if (mmovetype == movetype.right) {
			moveright();
		} else if (mmovetype == movetype.left) {
			moveleft();
		} else if (mmovetype == movetype.up) {
			moveup();
		} else if (mmovetype == movetype.down) {
			movedown();
		}
	}

	public void movedown() {
		if (mmovetype == movetype.up) {
			return;
		}
		mmovetype = movetype.down;
		int x1 = recs.get(0).x1;
		int y1 = recs.get(0).y1 + size;
		int x2 = x1 + size;
		int y2 = y1 + size;
		rec x = new rec(x1, y1, size);
		recs.add(0, x);
		recs.remove(recs.size() - 1);
	}

	public void moveup() {
		if (mmovetype == movetype.down) {
			return;
		}
		mmovetype = movetype.up;
		int x1 = recs.get(0).x1;
		int y1 = recs.get(0).y1 - size;
		int x2 = x1 + size;
		int y2 = y1 + size;
		rec x = new rec(x1, y1, size);
		recs.add(0, x);
		recs.remove(recs.size() - 1);
		mmovetype = movetype.up;
	}

	public void moveleft() {
		if (mmovetype == movetype.right) {
			return;
		}
		mmovetype = movetype.left;
		int x1 = recs.get(0).x1 - size;
		int y1 = recs.get(0).y1;
		rec x = new rec(x1, y1, size);
		recs.add(0, x);
		recs.remove(recs.size() - 1);
		mmovetype = movetype.left;
	}

	public void moveright() {
		if (mmovetype == movetype.left) {
			return;
		}
		mmovetype = movetype.right;
		int x1 = recs.get(0).x1 + size;
		int y1 = recs.get(0).y1;
		int x2 = x1 + size;
		int y2 = x2 + size;
		rec x = new rec(x1, y1, size);
		recs.add(0, x);
		recs.remove(recs.size() - 1);
	}

}
