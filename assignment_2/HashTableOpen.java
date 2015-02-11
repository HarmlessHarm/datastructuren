import java.util.*;
import java.io.*;

public class HashTableOpen {

	// private int hash_size;
	private Compressable function;
	private String[][] table;

	HashTableOpen(int hash_size, Compressable function) {
		// this.hash_size = hash_size;
		this.function = function;
		table = new String[hash_size][2];
	}

	public void put(String key, String value) {
		table[key][1] = value;
	}

	public String get(String key) {
		System.out.println(table[key][1]);
		return table[key][1];
	}

	public int size() {
		return table.length;
	}

}