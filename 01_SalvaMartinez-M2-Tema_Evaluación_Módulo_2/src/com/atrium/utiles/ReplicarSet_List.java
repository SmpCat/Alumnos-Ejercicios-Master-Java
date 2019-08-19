package com.atrium.utiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ReplicarSet_List {

	public static List<?> replicar(Set<?> set) {
		List<Object> lista = new ArrayList<Object>();
		lista.addAll(set);
		return lista;
	}

}
