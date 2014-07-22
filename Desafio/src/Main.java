
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String ESPACO = " ";
	private static final String FIZZBUZZ = "FB ";
	private static final String FIZZ = "F ";
	private static final String BUZZ = "B ";

	public static void main(String args[]){
		if (args.length == 0)
			System.exit(1);

		File file = new File(args[0]);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));

			String linha;
			List<String>linhas = new ArrayList<String>();
			while((linha = reader.readLine()) != null){
				String [] lineArray = linha.split("\\s");
				if(lineArray.length >0){
					linhas.add(montarArquivo(lineArray));
				}
			}
			reader.close();
			criarArquivo(linhas);
			System.exit(0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static String montarArquivo(String[] linhaArquivo){
		Integer primeiroDivisor = Integer.parseInt(linhaArquivo[0]),
				segundoDivisor = Integer.parseInt(linhaArquivo[1]),
				maximo = Integer.parseInt(linhaArquivo[2]),
				restoA=0,restoB=0;

		StringBuilder linha= new StringBuilder();
		for(int cont=1;cont<=maximo;cont++){

			restoA = cont % primeiroDivisor;
			restoB = cont % segundoDivisor;
			if(restoA ==  0 && restoB ==0)
				linha.append(FIZZBUZZ);
			else if (restoA==0)
				linha.append(FIZZ);
			else if (restoB ==0)
				linha.append(BUZZ);
			else 
				linha.append(cont+ESPACO);
		}
		return linha.toString();

	}

	public static void criarArquivo(List<String> linhas){
		for(String linha:linhas){
			System.out.println(linha);
		}
	}
}
