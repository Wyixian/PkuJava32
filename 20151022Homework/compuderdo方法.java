public void computerdo() {
		cMGrad = 0;
		if (start) {
			while (true) {
				int tx = (int) (Math.random() * 2);
				int ty = (int) (Math.random() * 2);
				nx = 6 + tx;
				ny = 6 + ty;
				if (points[nx][ny] == 0)
					break;
			}
			start = false;
		} else {
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					cGrades[i][j] = 0; // 该点分数清零
					if (points[i][j] == 0) {
						for (int k = 0; k < 572; k++) {
							if (cMarks[i][j][k])
								switch (weights[0][k]) {
								case 1:
									cGrades[i][j] += 5;
									break;
								case 2:
									cGrades[i][j] += 50;
									break;
								case 3:
									cGrades[i][j] += 100;
									break;
								case 4:
									cGrades[i][j] += 400;
									break;
								default:
									break;
								}
						}
					}
					if (cMGrad < cGrades[i][j]) {
						cMGrad = cGrades[i][j];
						cMx = i;
						cMy = j;
					}
				}
			pMGrad = 0;

			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					pGrades[i][j] = 0;
					if (points[i][j] == 0) {
						for (int k = 0; k < 572; k++) {
							if (pMarks[i][j][k])
								switch (weights[1][k]) {
								case 1:
									pGrades[i][j] += 5;
									break;
								case 2:
									pGrades[i][j] += 52;
									break;
								case 3:
									pGrades[i][j] += 110;
									break;
								case 4:
									pGrades[i][j] += 400;
									break;
								default:
									break;
								}
						}
					}
					if (pMGrad < pGrades[i][j]) {
						pMGrad = pGrades[i][j];
						pMx = i;
						pMy = j;
					}
					// System.out.print("*" + pMGrad);
				}
				System.out.print("px" + pMx + " py" + pMy);
				System.out.print("  cx" + cMx + " cy" + cMy);
			if (pMGrad >= cMGrad && pMGrad > 100) { // 防守
				nx = pMx;
				ny = pMy;
			} else {
				nx = cMx;
				ny = cMy;
			}

		}
		System.out.println(cMGrad + " " + pMGrad + "********");
		points[nx][ny] = 2;
		for (int k = 0; k < 572; k++) {
			if (cMarks[nx][ny][k] && weights[0][k] != 7) {
				weights[0][k]++;
			}
			if (pMarks[nx][ny][k]) {
				pMarks[nx][ny][k] = false;
				weights[1][k] = 7;
			}
		}
		repaint();
	}

	public void resetMarks() {
		int count = 0;
		// 横向
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 11; j++) {
				for (int k = 0; k < 5; k++) {
					cMarks[i][j + k][count] = true;
					pMarks[i][j + k][count] = true;
				}
				count++;
			}
		// 纵向
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 15; j++) {
				for (int k = 0; k < 5; k++) {
					cMarks[i + k][j][count] = true;
					pMarks[i + k][j][count] = true;
				}
				count++;
			}
		// 正对角
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++) {
				for (int k = 0; k < 5; k++) {
					cMarks[i + k][j + k][count] = true;
					pMarks[i + k][j + k][count] = true;
				}
				count++;
			}
		// 反对角
		for (int i = 0; i < 11; i++)
			for (int j = 14; j > 3; j--) {
				for (int k = 0; k < 5; k++) {
					cMarks[i + k][j - k][count] = true;
					pMarks[i + k][j - k][count] = true;
				}
				count++;
			}
		// 初始化每个黑白子点的权值
		for (int i = 0; i <= 1; i++)
			for (int j = 0; j < 572; j++)
				weights[i][j] = 0;
	}
