import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = -2723363051271966964L;
	private Integer firstNumber = null; 
	private Integer secondNumber = null;

	private Integer result = null;
	
	public Message(Integer firstNumber, Integer secondNumber) {
		this.setFirstNumber(firstNumber);
		this.setSecondNumber(secondNumber);
		
	}

	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Integer getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
}
