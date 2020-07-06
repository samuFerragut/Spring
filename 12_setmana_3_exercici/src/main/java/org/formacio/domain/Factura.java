package org.formacio.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_factures")
public class Factura {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fac_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fac_client")
	private Client client;
	
	/* no se modifica la clase LiniaFactura añadiendo allí un nuevo atributo, 
	 * sino que desde el script SQL se modifica la BBDD añadiendo nuevo campo
	 * "lin_factura",
	 * y el campo lo metemos en el modelo de la tabla desde la clase Factures
	 * con OneToMany y el Set de LiniaFactures.
	 * */
	 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="lin_factura")
	private Set<LiniaFactura> linies = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<LiniaFactura> getLinies() {
		return linies;
	}

	public void setLinies(Set<LiniaFactura> linies) {
		this.linies = linies;
	}
	
	
}
