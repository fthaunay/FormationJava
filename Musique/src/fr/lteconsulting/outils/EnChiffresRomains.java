package fr.lteconsulting.outils;

public class EnChiffresRomains {

	private String unChiffreDecimal(int n, char i, char v, char x) {
		String s;
		switch (n) {
		case 0:
			s = "";
			break;
		case 1:
			s = "" + i;
			break;
		case 2:
			s = "" + i + i;
			break;
		case 3:
			s = "" + i + i + i;
			break;
		case 4:
			s = "" + i + v;
			break;
		case 5:
			s = "" + v;
			break;
		case 6:
			s = "" + v + i;
			break;
		case 7:
			s = "" + v + i + i;
			break;
		case 8:
			s = "" + v + i + i + i;
			break;
		case 9:
			s = "" + i + x;
			break;
		default:
			s = "???";
		}
		return s;
	}

	public String convertitEnRomains(int n) {
		int u = n % 10;
		int d = (n / 10) % 10;
		int c = (n / 100) % 10;
		int m = (n / 1000) % 1000;
		return (unChiffreDecimal(m, 'M', '?', '?') + unChiffreDecimal(c, 'C', 'D', 'M')
				+ unChiffreDecimal(d, 'X', 'L', 'C') + unChiffreDecimal(u, 'I', 'V', 'X'));
	}
}
