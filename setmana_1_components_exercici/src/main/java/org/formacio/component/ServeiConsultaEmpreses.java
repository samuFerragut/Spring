package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// aquesta classe ha de ser detectada com un component
@Component

public class ServeiConsultaEmpreses {

	// aquest servei necessita d'un integrador de cotitzacions per retornar la informacio
	// declarau la dependencia i feis que spring la resolgui
	@Autowired
	IntegradorCotitzacions client = new ClientCotitzacionsWS();
	
	private float mitjanaDiariaCotitzacions = 0f;
	
	@PostConstruct
	public void init() {
		this.mitjanaDiariaCotitzacions = client.obteMitjanaDiariaCotitzacions();
	}
	
	// modifiqueu aquest metode per canviar el 0 per el valor obtingut del clientCotitzacionsWS
	public String infoEmpresa(String empresa) {
		return "La empresa " + empresa + " cotitza a " + client.obteCotitzacio(empresa);
	}

	
	// modifiqueu aquest metode per canviar el 0 per el valor obtingut del clientCotitzacionsWS
	// aquest es, segurament, l'exercici mes xungo !
	// com farieu per fer que el metode infoDiari de obteMitjanaDiariaCotitzacions nomes se crides una vegada?
	// pista (si nomes s'ha de cridar una vegada ... haurem de guardar el resultat a alguna banda ... )
	public String infoDiari() {
		return "La cotitzacio mitjana diaria es " + this.mitjanaDiariaCotitzacions;
	}

}
