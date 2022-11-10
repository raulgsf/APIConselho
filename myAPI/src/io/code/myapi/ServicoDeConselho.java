package io.code.myapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import io.code.myapi.dominio.Conselho;

public class ServicoDeConselho {
	static String webService = "https://api.adviceslip.com/advice";
	static int codigoSucesso = 200;
	
	static HttpURLConnection montaConexao() throws IOException {
		return montaConexao(0);
	}
	
	private static HttpURLConnection montaConexao(int id) throws IOException {
		URL url;
		
		if(id > 0) {
			url = new URL(webService + "/" + id);
		}else {
			url = new URL(webService);
		}
		return (HttpURLConnection) url.openConnection();
	}
	
	public static Conselho buscaConselho() throws Exception {

		try {
			HttpURLConnection conexao = montaConexao();
			
			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			Gson gson = new Gson();
			Conselho conselho = gson.fromJson(jsonEmString, Conselho.class);
			
			return conselho;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}
	public static Conselho buscaConselhoPorId(int id) throws Exception {

		try {
			HttpURLConnection conexao = montaConexao(id);
			
			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			Gson gson = new Gson();
			Conselho conselho = gson.fromJson(jsonEmString, Conselho.class);
			
			return conselho;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}
}
