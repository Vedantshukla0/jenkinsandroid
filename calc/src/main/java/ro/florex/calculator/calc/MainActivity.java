package ro.florex.calculator.calc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
        private EditText Scr;
        private String Operatie;
        private ButtonClickListener bClick = new ButtonClickListener();
        float x;
        String Op;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Scr = (EditText) findViewById(R.id.afisareRez);
            //Scr.setEnabled(false);
            int idList [] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8,
                    R.id.button9, R.id.buttonC, R.id.buttonPlus, R.id.buttonMinus, R.id.buttonInmultire, R.id.buttonImpartire, R.id.buttonEgal, R.id.buttonPunct};
            for(int id:idList)
            {
                View v = (View) findViewById(id);
                v.setOnClickListener(bClick);
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        public void getKeyboard(String str){
            String ScrCurrent = Scr.getText().toString();
            if(ScrCurrent.equals("0"))
                ScrCurrent = "";
            ScrCurrent += str;
            Scr.setText(ScrCurrent);
        }

    public float Rezultat (){
        float y = Float.parseFloat(Scr.getText().toString());
        float result= 0 ;

        if(Operatie.equals("+")){
            result = x + y;
        }

        if(Operatie.equals("-")){
            result = x - y;
        }

        if(Operatie.equals("*")){
            result = x * y;
        }

        if(Operatie.equals("/")){
            result = x / y;
        }

        return result;
    }

    public void mMath(String str){
        x = Float.parseFloat(Scr.getText().toString());
        Operatie = str;
        Op = str;
        Scr.setText(String.format("%s%s", x, Operatie)); //sterge ecranul
    }

        private class ButtonClickListener implements View.OnClickListener{
            public void onClick(View v) {
                //do {
                    switch (v.getId()) {
                        case R.id.buttonC:
                            Scr.setText("0");
                            x = 0;
                            Operatie = "";

                        case R.id.buttonPlus:
                            mMath("+");
                            break;

                        case R.id.buttonMinus:
                            mMath("-");
                            break;

                        case R.id.buttonInmultire:
                            mMath("*");
                            break;

                        case R.id.buttonImpartire:
                            mMath("/");
                            Operatie = "/";
                            break;

                        case R.id.buttonEgal:
                            Scr.setText(String.valueOf(Rezultat()));
                            break;

                        default:
                            String numb = ((Button) v).getText().toString();
                            getKeyboard(numb);
                            break;
                    }
                //} while(Op.equals("="));
            }
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            return id == R.id.action_settings || super.onOptionsItemSelected(item);
        }

    }

