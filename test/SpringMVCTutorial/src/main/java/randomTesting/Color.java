package randomTesting;

public class Color {
	 
	private String colorName;
 
	private String colorCode;
 
	public Color(){}
 
	public Color(String colorName, String colorCode) {
		this.colorName = colorName;
		this.colorCode = colorCode;
	}
 
	public String getColorName() {
		return colorName;
	}
 
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
 
	public String getColorCode() {
		return colorCode;
	}
 
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
 
}
