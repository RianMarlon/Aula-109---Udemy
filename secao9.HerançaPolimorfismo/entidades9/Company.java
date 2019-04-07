package entidades9;

public class Company extends TaxPayer {

	// número de funcionários
	private int numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualncome, int numberOfEmployees) {
		super(name, anualncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public final Double tax() {

		if (numberOfEmployees > 10) {
			return (getAnualincome() * 0.14);
		} else {
			return (getAnualincome() * 0.16);

		}

	}

}