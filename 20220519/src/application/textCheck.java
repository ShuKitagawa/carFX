package application;

public class textCheck {


	public static   String checkText(String kyoriTextField2,String nenpiTextField2,String gasTextField2){
		//結果を返す
		String resultText = "";
		if ( kyoriTextField2.equals("") 
				|| nenpiTextField2.equals("")
				|| gasTextField2.equals("") )
		{ //空白だったら
			resultText = checkTextFinal.noText;
		} else if ( !isNumber(kyoriTextField2,nenpiTextField2,gasTextField2) ){ //数値じゃなかったら
			resultText = checkTextFinal.noText;
		} else {
			resultText = checkTextFinal.OK;
		}
		return resultText;
	}
	
	public static   String checkId(String kyoriTextField2){
		//結果を返す
		String resultText = "";
		if ( kyoriTextField2.equals("") )
		{ //空白だったら
			resultText = checkTextFinal.noText;
		} else if ( !isIDNumber(kyoriTextField2) ){ //数値じゃなかったら
			resultText =  checkTextFinal.noInteger;
		} else {
			resultText = checkTextFinal.OK;
		}
		return resultText;
	}
	
	public static   String caeManagementCheckText(String stringInsertNenpiId1,String stringInsertNenpiI1){
		//結果を返す
		String resultText = "";
		if ( stringInsertNenpiId1.equals("") 
				|| stringInsertNenpiI1.equals(""))
				
		{ //空白だったら
			resultText = checkTextFinal.noText;
		} else if ( !isFuelNumber(stringInsertNenpiId1,stringInsertNenpiI1) ){ //数値じゃなかったら
			resultText = checkTextFinal.noInteger;
		} else {
			resultText = checkTextFinal.OK;
		}
		return resultText;
	}

	public static   String checkFuelText(String carNameTextField2,String fuelAmountTextField2,String tripTextField2){

		String resultText = "";
		//空白だったら
		if ( fuelAmountTextField2.equals("") 
				|| tripTextField2.equals("")
				|| carNameTextField2.equals(""))
		{
			resultText = checkTextFinal.noText;;
			//11文字以上の入力はNGとする
		} else if (carNameTextField2.length()>10){ 
			resultText = checkTextFinal.canameNG;
			//数値じゃなかったら
		} else if ( !isFuelNumber(fuelAmountTextField2,tripTextField2) ){ 
			resultText = checkTextFinal.noInteger;
		} else {
			resultText = checkTextFinal.OK;
		}
		return resultText;
	}
	
	public static   String checkCarnameText(String insertCarField2){

		String resultText = "";
		//空白だったら
		if ( insertCarField2.equals("")) 
		{
			resultText = checkTextFinal.noText;
			//11文字以上の入力はNGとする
		} else if (insertCarField2.length()>10){ 
			resultText = checkTextFinal.canameNG;
		} else {
			resultText = checkTextFinal.OK;
		}
		return resultText;
	}
	
	public static boolean isIDNumber(String kyoriTextField2) {
		//数値チェック
		try {
			Integer.parseInt(kyoriTextField2);
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

	public static String toHalfWidth(String s) {
		//全角数字を半角に変換
		  StringBuilder sb = new StringBuilder(s);
		  for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (0xFF10 <= c && c <= 0xFF19) {
		      sb.setCharAt(i, (char) (c - 0xFEE0));
		    }
		  }
		  return sb.toString();
		}
}
