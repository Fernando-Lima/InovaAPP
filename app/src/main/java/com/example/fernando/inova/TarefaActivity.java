package com.example.fernando.inova;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TarefaActivity extends Debug {

    private EditText edtDate, edtTime, edtCliente, edtSetor, edtDesricao;
    private int year, month, day, hour, min;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        findViewById();
        hideKeyboard();

        //Abre o dialog do calendar com a data atual
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //Abre o dialog do Time com a hora atual
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
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
        edtDesricao.setInputType(InputType.TYPE_NULL);
    }

    public void findViewById(){
        edtDate = (EditText)findViewById(R.id.edt_date_tarefa);
        edtTime = (EditText)findViewById(R.id.edt_time_tarefa);
        edtCliente = (EditText)findViewById(R.id.edt_cliente_tarefa);
        edtSetor = (EditText)findViewById(R.id.edt_setor_tarefa);
        edtDesricao = (EditText)findViewById(R.id.edt_descricao_tarefa);
    }
}
