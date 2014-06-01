package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnPoint;
	Button btnFEqual, btnFPlus, btnFMinus, btnFDivide, btnFMulti, btnFRoot, btnFFactor,btnFExp;
	Button btnClear;
	TextView resultBox;
	String action="";
	String firstInput="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeViews();
	}
	
	private void initializeViews() {
		btn1 = (Button) findViewById(R.id.num1);
		btn2 = (Button) findViewById(R.id.num2);
		btn3 = (Button) findViewById(R.id.num3);
		btn4 = (Button) findViewById(R.id.num4);
		btn5 = (Button) findViewById(R.id.num5);
		btn6 = (Button) findViewById(R.id.num6);
		btn7 = (Button) findViewById(R.id.num7);
		btn8 = (Button) findViewById(R.id.num8);
		btn9 = (Button) findViewById(R.id.num9);
		btn0 = (Button) findViewById(R.id.num0);
		btnPoint = (Button) findViewById(R.id.point);
		btnFDivide = (Button) findViewById(R.id.divide);
		btnFMinus = (Button) findViewById(R.id.minus);
		btnFMulti = (Button) findViewById(R.id.multiply);
		btnFPlus = (Button) findViewById(R.id.plus);
		btnFExp = (Button) findViewById(R.id.power);
		btnFEqual = (Button) findViewById(R.id.equal);
		btnFRoot = (Button) findViewById(R.id.root);
		btnFFactor = (Button) findViewById(R.id.factorial);
		btnClear = (Button) findViewById(R.id.clean);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn0.setOnClickListener(this);
		btnPoint.setOnClickListener(this);
		btnFDivide.setOnClickListener(this);
		btnFMinus.setOnClickListener(this);
		btnFMulti.setOnClickListener(this);
		btnFPlus.setOnClickListener(this);
		btnFExp.setOnClickListener(this);
		btnFEqual.setOnClickListener(this);
		btnFRoot.setOnClickListener(this);
		btnFFactor.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		
		resultBox = (TextView) findViewById(R.id.output);
		resultBox.setText("0");
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.num0: writeNum("0");	break;
		case R.id.num1: writeNum("1");	break;
		case R.id.num2: writeNum("2");	break;
		case R.id.num3: writeNum("3");	break;
		case R.id.num4: writeNum("4");	break;
		case R.id.num5: writeNum("5");	break;
		case R.id.num6: writeNum("6");	break;
		case R.id.num7: writeNum("7");	break;
		case R.id.num8: writeNum("8");	break;
		case R.id.num9: writeNum("9");	break;
		case R.id.point: writeNum(".");	break;
		case R.id.clean: writeNum("CLEAR"); break;
		
		case R.id.divide: action="divide"; firstInput=(String) resultBox.getText();writeNum("CLEAR"); break;
		case R.id.power: action="power"; firstInput=(String) resultBox.getText();writeNum("CLEAR"); break;
		case R.id.minus: action="minus"; firstInput=(String) resultBox.getText();writeNum("CLEAR"); break;
		case R.id.plus: action="plus"; firstInput=(String) resultBox.getText();writeNum("CLEAR"); break;
		case R.id.multiply: action="multiply"; firstInput=(String) resultBox.getText();writeNum("CLEAR"); break;
		case R.id.root: action("root"); break;
		case R.id.factorial: action("factorial"); break;
		case R.id.equal: action("equal"); break;
		default: break;
		}
		
		
	}

	private void action(String act) {
		double otherNumInput = Double.parseDouble((String) resultBox.getText());
		if (act.equals("root")) {
			resultBox.setText(Math.sqrt(otherNumInput)+"");
		}
		if (act.equals("factorial")) {
			resultBox.setText(factorial(otherNumInput));
		}
		if(act.equals("equal")){
			double firstNumInput = Double.parseDouble(firstInput);
			if (action.equals("plus")) {
				Log.e("user", (firstNumInput+otherNumInput)+"");
				resultBox.setText((firstNumInput+otherNumInput)+"");
			}
			if (action.equals("minus")) {
				resultBox.setText((firstNumInput-otherNumInput)+"");
			}
			if (action.equals("divide")) {
				resultBox.setText((firstNumInput/otherNumInput)+"");
			}
			if (action.equals("multiply")) {
				resultBox.setText((firstNumInput*otherNumInput)+"");
			}
			if (action.equals("power")) {
				resultBox.setText((Math.pow(firstNumInput, otherNumInput))+"");
			}
		}
	}

	private String factorial(double otherInput) {
		int n = (int) Math.floor(otherInput);
		int ans=1;
		for (int i = 1; i <= n; i++) {
			ans*=i;
		}
		return ans+"";
	}

	private void writeNum(String input) {
		if (input.equals("CLEAR")) {
			resultBox.setText("0");
			return;
		}
		
		String box = (String) resultBox.getText();
		if (box.equals("0") && !(input.equals("."))) {
			box = input;
		}
		else{
			box += input;
		}
		resultBox.setText(box);
	}

}
