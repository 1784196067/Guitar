package dao;

import java.util.List;
import doman.Guitar;

public interface GuitarDao {
	public void addGuitar(Guitar guitar);
	public Guitar getGuitar(String serialNumber);
	public List<Guitar> search(String desc);
}
