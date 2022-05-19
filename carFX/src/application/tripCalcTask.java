package application;

public class tripCalcTask {


	public static   String checkText(String kyoriTextField2,String nenpiTextField2,String gasTextField2){
		//結果を返す
		String resultText = "";
		if ( kyoriTextField2.equals("") 
				|| nenpiTextField2.equals("")
				|| gasTextField2.equals("") )
		{ //空白だったら
			resultText = "未入力です(もう一度入力してください)";
		} else if ( !isNumber(kyoriTextField2,nenpiTextField2,gasTextField2) ){ //数値じゃなかったら
			resultText = "数値ではありません(もう一度入力してください)";
		} else {
			resultText = "OK!";
		}
		return resultText;
	}

	public static   String checkFuelText(String fuelAmountTextField2,String tripTextField2){
		//結果を返す
		String resultText = "";
		if ( fuelAmountTextField2.equals("") 
				|| tripTextField2.equals(""))
				
		{ //空白だったら
			resultText = "未入力です(もう一度入力してください)";
		} else if ( !isFuelNumber(fuelAmountTextField2,tripTextField2) ){ //数値じゃなかったら
			resultText = "数値ではありません(もう一度入力してください)";
		} else {
			resultText = "OK!";
		}
		return resultText;
	}

	public static boolean isNumber(String kyoriTextField2,String nenpiTextField2,String gasTextField2) {
		//数値チェック
		try {
			Integer.parseInt(kyoriTextField2);
			Integer.parseInt(nenpiTextField2);
			Integer.parseInt(gasTextField2);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public static boolean isFuelNumber(String fuelAmountTextField2,String tripTextField2) {
		//数値チェック
		try {
			Integer.parseInt(fuelAmountTextField2);
			Integer.parseInt(tripTextField2);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
