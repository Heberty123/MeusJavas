package entities;

import java.util.Date;
import java.util.Objects;

public class logEntry {
	
	private String name;
	private Date instante;
	
	public logEntry(String name, Date data) {
		this.name = name;
		this.instante = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	@Override
	public String toString() {
		return "logEntry [name=" + name + ", instante=" + instante + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		logEntry other = (logEntry) obj;
		return Objects.equals(name, other.name);
	}


	
	
}
