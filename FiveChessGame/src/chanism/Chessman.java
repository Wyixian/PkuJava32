package chanism;


public enum Chessman {
	BLACK("●"), WHITE("○"), EMPTY("+");
	
	private String chessman;

	/**
	 * 私有构造器
	 */
	private Chessman(String chessman) {
		this.chessman = chessman;
	}

	/**
	 * @return String 黑棋或者白棋
	 */
	public String getChessman() {
		return this.chessman;
	}
}