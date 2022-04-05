package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i, c;
		
		Set<Integer> A = new HashSet<Integer>();
		
		System.out.println("How many students for course A? ");
		c = sc.nextInt();
		
		for(i = 0 ; i<c ; i++ ) {
			A.add(sc.nextInt());
		}
		
		Set<Integer> B = new HashSet<Integer>();
		
		System.out.println("How many students for course B? ");
		c = sc.nextInt();
		
		for(i = 0 ; i<c ; i++ ) {
			B.add(sc.nextInt());
		}
		
		Set<Integer> C = new HashSet<Integer>();
		
		System.out.println("How many students for course C? ");
		c = sc.nextInt();
		
		for(i = 0 ; i<c ; i++ ) {
			C.add(sc.nextInt());
		}
		
		Set<Integer> lista = Concat(A, B, C);
		
		System.out.println("Total students: " + lista.size());
		
	}
	
	
	public static Set<Integer> Concat(Set<Integer> a, Set<Integer> b, Set<Integer> c){
		
		Set<Integer> lista = new HashSet<Integer>();
		lista.addAll(a);
		lista.addAll(b);
		lista.addAll(c);
		
		return lista;
	}

}
