package br.senai.sc.aulas.miniaula.util;

import javax.persistence.Persistence;

public class CriaTabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("MiniAulaPU");
	}
	
}
