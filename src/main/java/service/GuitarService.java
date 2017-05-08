package service;

import java.util.List;

import dao.GuitarDao;
import doman.Guitar;
import impl.GuitarDaoImpl;

public class GuitarService {
	private GuitarDao guitarDao = new GuitarDaoImpl();
	
	public void setGuitarDao(GuitarDaoImpl guitarDao) {
		this.guitarDao = guitarDao;
	}
	
	public void addGuitar(Guitar guitar){
		guitarDao.addGuitar(guitar);
	};
	public Guitar getGuitar(String serialNumber){
		return guitarDao.getGuitar(serialNumber);
	};
	public List<Guitar> search(String str){
		return guitarDao.search(str);
	};
	
	
}
