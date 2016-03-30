package enf.android.celfar_evandro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText graus;
    Button converter;
    TextView res;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        graus= (EditText) findViewById(R.id.graus);
        res= (TextView) findViewById(R.id.res);
        rg = (RadioGroup) findViewById(R.id.rbgroup);

        converter = (Button) findViewById(R.id.btConverter);
        converter.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        int selected = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(selected);

        res.setText("");
        Boolean isAnumber=Boolean.FALSE;
        String text = graus.getText().toString();
        double valor = 0;
        try {
                valor = Double.parseDouble(text);
                isAnumber=Boolean.TRUE;
                //Log.i("",num+" is a number");
                //Toast.makeText(MainActivity.this, " is a number", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
                //Log.i("", text + "is not a number");
                //Toast.makeText(MainActivity.this, "is not a number", Toast.LENGTH_SHORT).show();
        }


        //Se já escolheu um radioButton e o campo grau contem um número
        if (rg.getCheckedRadioButtonId()!=-1 && isAnumber){
            //Toast.makeText(MainActivity.this, "selected: "+rg.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();
           //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
            if(rb.getText().equals("Celsius")){
                //Toast.makeText(MainActivity.this, "Celsius", Toast.LENGTH_SHORT).show();

                double Fvalor = celfar(valor);

                res.setText(Fvalor+" F");

            }

            if(rb.getText().equals("Fahrenheit")){
                //Toast.makeText(MainActivity.this, "Fahrenheit", Toast.LENGTH_SHORT).show();

                double Cvalor = farcel(valor);

                res.setText(Cvalor+" C");
            }

        }
        else {
            if(!isAnumber){
                Toast.makeText(MainActivity.this, "Insere um valor válido para graus!", Toast.LENGTH_SHORT).show();
            }

            if(rg.getCheckedRadioButtonId()==-1){
                Toast.makeText(MainActivity.this, "Escolhe uma escala!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    double celfar(double C){

        double F = C*1.8+32;
        return F;
    }

    double farcel(double F){

        double C = (F -32) / 1.8;
        return C;
    }

    public void TestPullForGitHub(){

        Toast.makeText(MainActivity.this, "SLB SLB SBL SBL Glorioso SBL!", Toast.LENGTH_SHORT).show();
    }


}
