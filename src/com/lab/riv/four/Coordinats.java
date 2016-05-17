package com.lab.riv.four;

public class Coordinats {
	
	private Double[] point = new Double[2];
	private Double[] lineOne,lineTwo;

	private boolean isParallel(){
		return lineOne[0].equals(lineTwo[0]);
	}
	
	private boolean isOrtogonal(){
		return lineOne[0].equals(-1/lineTwo[0]);
	}
	
	private Double findAbciss(){
		return (lineTwo[1] - lineOne[1])/(lineOne[0]-lineTwo[0]); 
	}
	
	private Double findOrdinat(){
		return lineOne[0]*point[0] + lineOne[1];
	}
	
	public void findPoint(){
		point[0] = findAbciss();
		point[1] = findOrdinat();
	}
	
	public void setLineOne(Double a, Double b){
		lineOne = new Double[]{a, b};
	}
	
	public void setLineTwo(Double a, Double b){
		lineTwo = new Double[]{a, b};
	}
	
	private String format(double value){
		return value%((int)value) == 0 ? (int)value + "" : value + "";
	}
	
	private String displayFunction(Double[] f){
		boolean show = true;
		String func = "y=" + (f[0] != 0d ? f[0] != 1d ? f[0] != -1d ? format(f[0]) + "x": "-x" : "x" : "");
		show = func.contains("x") ? true : false;
		func += f[1] != 0d ? show ? "+" + format(f[1]) : format(f[1]) : ""; 
		return func+"\n";
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder("Прямые:\n");
		builder.append(displayFunction(lineOne));
		builder.append(displayFunction(lineTwo));
		builder.append(isParallel() ? "параллельны и не имеют общих точек пересечения" : "");
		builder.append(isOrtogonal() ? "перпендикулярны." : "");
		builder.append(!isParallel() ? "Точка пересечения прямых: (" + format(point[0]) + ", " + format(point[1]) + ")" : "");
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Coordinats c = new Coordinats();
		c.setLineOne(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		c.setLineTwo(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		c.findPoint();
		System.out.println(c);
	}

}
