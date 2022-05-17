package application;

public class tripCalcTask {


	  public static   String checkText(String kyoriTextField2){
	    //結果を返す
	    String resultText = "";
	    if ( kyoriTextField2.equals("") ) { //空白だったら
	      resultText = "未入力です";
	    } else if ( !isNumber(kyoriTextField2) ){ //数値じゃなかったら
	      resultText = "数値ではありません";
	    } else { //それ以外
	      int tgtInt = Integer.parseInt(kyoriTextField2); //数値変換
	      if ( 10 <= tgtInt && tgtInt <= 20 ) { //範囲内かチェック
	        resultText = "OK!";
	      } else {
	        resultText = "範囲外です";
	      }
	    }
	    return resultText;
	  }
	  public static boolean isNumber(String val) {
	    //数値チェック
	    try {
	      Integer.parseInt(val);
	      return true;
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	  }
}
