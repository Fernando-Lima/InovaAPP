package com.example.fernando.inova;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TarefaActivity extends Debug{

    private EditText edtDate, edtTime, edtCliente,  edtDesricao, edtSituacao, edtEndereco;
    private MenuItem m1, m2;
    private int year, month, day, hour, min;
    private ImageButton imgRemoveCliente, imgRemoveTipo;
    private int REQUEST_CODE = 1;
    private Spinner spinner;
    private String tipoTarefa[] = {"Instalação", "Manutenção", "Visita"};
    ArrayAdapter<String> arrayAdapter;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        findViewById();
        hideKeyboard();
        showImg();

        //Abre o dialog do calendar com a data atual
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        setDate();

        //Abre o dialog do Time com a hora atual
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        setTime();
        edtSituacao.setEnabled(false);
        spinnerAdapter();
    }

    public void spinnerAdapter(){
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tipoTarefa);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tarefa, menu);

        m1 = menu.findItem(R.id.action_tarefa_iniciar);
        m2 = menu.findItem(R.id.action_tarefa_problema);

        m1.setVisible(false);
        m2.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_tarefa_iniciar){
            // inicia tarefa
        }else if(id == R.id.action_tarefa_problema){
            //reportar problema
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showImg();
    }

    public void showDate(View view){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,mDateSetListener, year, month, day);
        datePickerDialog.show();
    }

    public void showTime(View view){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour,min,true);
        timePickerDialog.show();
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            setDate();
        }
    };

    public void setDate(){
        String date = simpleDateFormat.format(calendar.getTime());
        edtDate.setText(date);
    }

    public void setTime(){
        String time = timeFormat.format(calendar.getTime());
        edtTime.setText(time);
    }

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int min) {
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, min);
            setTime();
        }
    };
    public void hideKeyboard(){
        edtDate.setInputType(InputType.TYPE_NULL);
        edtTime.setInputType(InputType.TYPE_NULL);
        edtCliente.setInputType(InputType.TYPE_NULL);
    }

    public void findViewById(){

        edtDate = (EditText)findViewById(R.id.edt_date_tarefa);
        edtTime = (EditText)findViewById(R.id.edt_time_tarefa);
        edtCliente = (EditText)findViewById(R.id.edt_cliente_tarefa);

        edtDesricao = (EditText)findViewById(R.id.edt_descricao_tarefa);
        edtSituacao = (EditText)findViewById(R.id.edt_situacao_tarefa);
        edtEndereco = (EditText)findViewById(R.id.edt_endereco_tarefa);

        imgRemoveCliente = (ImageButton)findViewById(R.id.img_remove_cliente_tarefa);


        spinner = (Spinner)findViewById(R.id.spinner_tipo_tarefa);
    }
    public void selecionarCliente(View view){
        Intent it = new Intent(TarefaActivity.this, ClienteActivity.class);
        startActivityForResult(it, REQUEST_CODE);
        //showImg();
    }

    public void selecionarTipo(View view){

    }

    //espera um resultado de outra activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK);
            String result = data.getStringExtra("key");
            Toast.makeText(TarefaActivity.this, result,Toast.LENGTH_SHORT).show();
        }
    }

    public void showImg(){
        if(edtCliente.getText().length()==0){
            //imgRemoveCliente.setVisibility(View.INVISIBLE);
            imgRemoveCliente.setBackground(this.getDrawable(R.drawable.ic_add_black));
        }else{
            imgRemoveCliente.setBackground(this.getDrawable(R.drawable.ic_close_black));
        }
    }
    public void onClickCliente(View view){
        if(edtCliente.getText().length() == 0){
            selecionarCliente(view);
        }else {
            edtCliente.setText("");
            showImg();
        }
    }
    public void goMaps(View view){
        // Map point based on address
        String endereco = edtEndereco.getText().toString();
        Uri location = Uri.parse("geo:0,0?q="+endereco);
// Or map point based on latitude/longitude
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);

        //Para abrir o maps dentro do aplicativo
        //Intent intent = new Intent(this,MapsActivity.class);
        //startActivity(intent);
    }
}