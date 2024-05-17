package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.SaturnFlora;

public class floriculturaRepository {
	private List<SaturnFlora> flora;
	private File database;

	public floriculturaRepository() {
		this.database = new File("database.flies.txt");
		this.flora = new ArrayList<>();
		// carregar os dados
		loadFlora();
	}

	// Crud -> creat, read, update and delete
	

	// buscar todos
	public List<SaturnFlora> buscarTodos() {
		return new ArrayList<>(flora);
	}

	// deletar objeto especifico
	public void deleteSaturnFlora(int id) {
		// percorrer todo o array, caso seja igual ele vai remover
		flora.removeIf(SaturnFlora -> SaturnFlora.getId() == id);
		saveFlora();
	}

	// criar saturnflora
	public void addSaturnFlora(SaturnFlora saturnflora) {
		// vai faltar o id
		saturnflora.setId(getNextId());
		flora.add(saturnflora);
		// sobrescrever o arquivo database
		saveFlora();
	}

	// sobrescrever o arquivo
	private void saveFlora() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
			for (SaturnFlora saturnflora : flora) {
				String data = saturnflora.getId() + ";" + saturnflora.getPersonalizado() + ";"
						+ saturnflora.getDataEntrega() + ";" + saturnflora.getMsgPersonalizada();
				// escrever uma linha e passa a proxima
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Arquivo database não encontrado!");
		}
	}

	// carregar
	private void loadFlora() {
		try (Scanner sc = new Scanner(database)) {
			while (sc.hasNextLine()) {

				String[] data = sc.nextLine().split(";");
				if (data.length >= 4) {
					// 0 -> id, 1 -> nome, 2 -> inicio, 3 -> Fim
					SaturnFlora saturnflora = new SaturnFlora();
					saturnflora.setId(Integer.parseInt(data[0]));
					saturnflora.setPersonalizado(data[1]);
					saturnflora.setDataEntrega(data[2]);
					saturnflora.setMsgPersonalizada(data[3]);
					flora.add(saturnflora);

				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado, criando um novo!");
		}
	}

	public void updateSaturnFlora(SaturnFlora updateSaturnFlora) {
		for (int i = 0; i < flora.size(); i++) {
			if (flora.get(i).getId() == updateSaturnFlora.getId()) {
				flora.set(i, updateSaturnFlora);
				saveFlora();
				break;
			}
		}
	}
	public SaturnFlora getSaturnFloraById(int id) {
		for(SaturnFlora saturnflora : flora) {
			if(saturnflora.getId() == id) {
				return saturnflora;
			}
		}
		return null;
	}

	// logica para pegar o proximo iD
	public int getNextId() {
		int maxId = 0;
		for (SaturnFlora saturnflora : flora) {
			// verificar se o numero é maior que o nosso numero maximo
			if (saturnflora.getId() > maxId) {
				maxId = saturnflora.getId();
			}
		}
		return maxId + 1;
	}

}
