package enf.android.celfar_evandro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
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
        res= (TextView) findViewById(R.id.resultado);

        rg = (RadioGroup) findViewById(R.id.rbgroup);

        converter = (Button) findViewById(R.id.btConverter);

        if (rg.getCheckedRadioButtonId()!=-1 && !graus.getText().toString().isEmpty()){
            //Toast.makeText(MainActivity.this, "selected: "+rg.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();
            converter.setOnClickListener(this);
        }
        else {
                if(graus.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Insere um valor em graus!", Toast.LENGTH_SHORT).show();

                }

                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(MainActivity.this, "Escolhe uma escala!", Toast.LENGTH_SHORT).show();
                }
        }




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

        //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        if(rb.getText().equals("Celsius")){
            //Toast.makeText(MainActivity.this, "Celsius", Toast.LENGTH_SHORT).show();

            String StGr =graus.getText().toString();

            double valor = celfar(Double.parseDouble(StGr));

            res.setText(valor+" F");


        }

        if(rb.getText().equals("Fahrenheit")){
            //Toast.makeText(MainActivity.this, "Fahrenheit", Toast.LENGTH_SHORT).show();

            String StGr =graus.getText().toString();

            double valor = farcel(Double.parseDouble(StGr));

            res.setText(valor+" C");
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


}
