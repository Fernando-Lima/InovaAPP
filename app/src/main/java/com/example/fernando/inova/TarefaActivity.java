package com.example.fernando.inova;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TarefaActivity extends Debug {

    private EditText edtDate, edtTime, edtCliente, edtSetor, edtDesricao;
    private int year, month, day, hour, min;
    private ImageButton imgRemoveCliente, imgRemoveSetor;
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

        //Abre o dialog do Time com a hora atual
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
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
        String date = simpleDateFormat.format(calendar.getTime());
        edtDate.setText(date);
        }
    };

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int min) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        String time = timeFormat.format(calendar.getTime());
        edtTime.setText(time);
        }
    };
    public void hideKeyboard(){
        edtDate.setInputType(InputType.TYPE_NULL);
        edtTime.setInputType(InputType.TYPE_NULL);
        edtCliente.setInputType(InputType.TYPE_NULL);
        edtSetor.setInputType(InputType.TYPE_NULL);
    }

    public void findViewById(){
        edtDate = (EditText)findViewById(R.id.edt_date_tarefa);
        edtTime = (EditText)findViewById(R.id.edt_time_tarefa);
        edtCliente = (EditText)findViewById(R.id.edt_cliente_tarefa);
        edtSetor = (EditText)findViewById(R.id.edt_setor_tarefa);
        edtDesricao = (EditText)findViewById(R.id.edt_descricao_tarefa);

        imgRemoveCliente = (ImageButton)findViewById(R.id.img_remove_cliente_tarefa);
        imgRemoveSetor = (ImageButton)findViewById(R.id.img_remove_setor_tarefa);
    }
    public void buscarCliente(View view){
        Intent it = new Intent(TarefaActivity.this, ClienteActivity.class);
        startActivityForResult(it, REQUEST_CODE);
        showImg();
    }

    public void buscarSetor(View view){
        Intent it = new Intent(TarefaActivity.this, SetorActivity.class);
        startActivity(it);
    }

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
        if(edtSetor.getText().length()==0){
            imgRemoveSetor.setVisibility(View.INVISIBLE);
        }else{
            imgRemoveSetor.setVisibility(View.VISIBLE);
        }
    }
    public void clearTvCliente(View view){
        edtCliente.setText("");
        // limpar o id do cliente também
        imgRemoveCliente.setVisibility(View.INVISIBLE);
    }
    public void clearTvSetor(View view){
        edtSetor.setText("");
        // limpar o id do setor também
        imgRemoveSetor.setVisibility(View.INVISIBLE);
    }
}
