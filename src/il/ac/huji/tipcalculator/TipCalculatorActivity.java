package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		// get all views to be prepared for onclick() method
		final EditText billAmount = (EditText) findViewById(R.id.edtBillAmount);
		final CheckBox checkRound = (CheckBox) findViewById(R.id.chkRound);
		final Button calcButton = (Button) findViewById(R.id.btnCalculate);
		final TextView textResult = (TextView) findViewById(R.id.txtTipResult);
		final DecimalFormat df = new DecimalFormat("0.00");
		calcButton.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				try{
					String strBillAmount = billAmount.getText().toString();
					double tip = Double.parseDouble(strBillAmount) * 0.12;
					boolean toRound = checkRound.isChecked();
					if(toRound){
						textResult.setText("Tip: $"+Long.toString(Math.round(tip)));
					}
					else{
						textResult.setText("Tip: $"+df.format(tip));
					}
				}catch(NumberFormatException e){}
			}
		});
	}    
}
