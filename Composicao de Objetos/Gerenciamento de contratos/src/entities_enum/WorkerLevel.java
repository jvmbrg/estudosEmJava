package entities_enum;

public enum WorkerLevel {
	JUNIOR(1),
	PLENO(2),
	SENIOR(3);

	private int level;
	WorkerLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
}
