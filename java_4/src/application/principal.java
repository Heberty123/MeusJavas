package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.logEntry;

public class principal {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		File file = new File("//home//heberty//Documentos//programação//java//Meus_Javas//java_4//text.txt");
		SimpleDateFormat sdfSource = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss'Z'", Locale.getDefault());
		BufferedWriter bf = new BufferedWriter(new FileWriter(file));
		
		char value =  's';
		
		while(value != 'n') {
			
			System.out.println("Digite o nome do usuário: ");
			String usuario = sc.next();
			logEntry log = new logEntry(usuario, new Date());
			
			
			bf.write(log.getName() + ", " + sdfSource.format(log.getInstante()));
			bf.newLine();
			
			System.out.println("Tem usuário para fazer login [s/n]: ");
			value = sc.next().charAt(0);
			
			
		}
		bf.close();
		
		System.out.println("--------------------------------------------");
		System.out.println("Usuários logados: ");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		Set<logEntry> lista = new HashSet<logEntry>();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] fields = line.split(",");
			lista.add(new logEntry(fields[0], sdfSource.parse(fields[1])));
			
			line = br.readLine();
		}
		
		System.out.println(lista);
		System.out.println("total users: " + lista.size());
	}

}
