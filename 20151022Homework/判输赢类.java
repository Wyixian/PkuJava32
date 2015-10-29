class Check {
	public static int checkLeft(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx - 1; i >= 0; i--) {
			if (points[i][ny] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkRight(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx + 1; i < 15; i++) {
			if (points[i][ny] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkUp(int nx, int ny, int[][] points) {
		int count = 0;
		for (int j = ny - 1; j >= 0; j--) {
			if (points[nx][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkDown(int nx, int ny, int[][] points) {
		int count = 0;
		for (int j = ny + 1; j < 15; j++) {
			if (points[nx][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkLeftUp(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx - 1, j = ny - 1; i >= 0 && j >= 0; i--, j--) {
			if (points[i][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkRightDown(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx + 1, j = ny + 1; i < 15 && j < 15; i++, j++) {
			if (points[i][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkRightUp(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx + 1, j = ny - 1; i < 15 && j >= 0; i++, j--) {
			if (points[i][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static int checkLeftDown(int nx, int ny, int[][] points) {
		int count = 0;
		for (int i = nx - 1, j = ny + 1; i >= 0 && j < 15; i--, j++) {
			if (points[i][j] != points[nx][ny])
				break;
			count++;
		}
		return count;
	}

	public static boolean checkWinner(int nx, int ny, int[][] points) {
		if (checkLeft(nx, ny, points) + checkRight(nx, ny, points) >= 4)
			return true;
		if (checkUp(nx, ny, points) + checkDown(nx, ny, points) >= 4)
			return true;
		if (checkLeftUp(nx, ny, points) + checkRightDown(nx, ny, points) >= 4)
			return true;
		if (checkRightUp(nx, ny, points) + checkLeftDown(nx, ny, points) >= 4)
			return true;
		return false;
	}
}