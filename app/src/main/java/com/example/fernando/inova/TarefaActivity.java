package com.example.fernando.inova;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TarefaActivity extends Debug implements View.OnClickListener {

    private EditText edtDate, edtTime, edtCliente,
            edtTipo, edtDesricao, edtSituacao;
    private int year, month, day, hour, min;
    private ImageButton imgRemoveCliente, imgRemoveTipo;
    private int REQUEST_CODE = 1;
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
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tarefa, menu);
        return true;
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
        edtTipo.setInputType(InputType.TYPE_NULL);
    }

    public void findViewById(){

        edtDate = (EditText)findViewById(R.id.edt_date_tarefa);
        edtTime = (EditText)findViewById(R.id.edt_time_tarefa);
        edtCliente = (EditText)findViewById(R.id.edt_cliente_tarefa);
        edtTipo = (EditText)findViewById(R.id.edt_tipo_tarefa);
        edtDesricao = (EditText)findViewById(R.id.edt_descricao_tarefa);
        edtSituacao = (EditText)findViewById(R.id.edt_situacao_tarefa);

        imgRemoveCliente = (ImageButton)findViewById(R.id.img_remove_cliente_tarefa);
        imgRemoveTipo = (ImageButton)findViewById(R.id.img_remove_tipo_tarefa);

    }
    public void selecionarCliente(View view){
        Intent it = new Intent(TarefaActivity.this, ClienteActivity.class);
        startActivityForResult(it, REQUEST_CODE);
        showImg();
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
            imgRemoveCliente.setVisibility(View.INVISIBLE);
        }else{
            imgRemoveCliente.setVisibility(View.VISIBLE);
        }
        if(edtTipo.getText().length()==0){
            imgRemoveTipo.setVisibility(View.INVISIBLE);
        }else{
            imgRemoveTipo.setVisibility(View.VISIBLE);
        }
    }
    public void clearTvCliente(View view){
        edtCliente.setText("");
        // limpar o id do cliente também
        imgRemoveCliente.setVisibility(View.INVISIBLE);
    }
    public void clearTvTipo(View view){
        edtTipo.setText("");
        // limpar o id do tipo também
        imgRemoveTipo.setVisibility(View.INVISIBLE);
    }
    public void goMaps(View view){
        //abrir google maps com o endereço de destino
    }
}