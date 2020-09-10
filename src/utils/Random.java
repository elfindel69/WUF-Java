package utils;

public interface Random {
	public static int RNG5 (int rng) {
		return (int) (Math.random() * rng * 5);
	}
	public static int RNG2 (int rng) {
		return (int) (Math.random() * rng * 2);
	}
}
