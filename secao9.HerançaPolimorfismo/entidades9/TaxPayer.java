package entidades9;

public abstract class TaxPayer {

	private String name;

	// rendimento anual
	private Double anualincome;

	public TaxPayer() {
	}

	public TaxPayer(String name, Double anualncome) {
		this.name = name;
		this.anualincome = anualncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualincome() {
		return anualincome;
	}

	public void setAnualincome(Double anualncome) {
		this.anualincome = anualncome;
	}

	public abstract Double tax();

}
