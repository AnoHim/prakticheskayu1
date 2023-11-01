package com.example.avtosalon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<String> selectedCars = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView carList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        carList = findViewById(R.id.carList);
        // устанавливаем для списка адаптер
        carList.setAdapter(adapter);
        // создаем адаптер
        CarAdapter carAdapter = new CarAdapter(this, R.layout.list_item, cars);
        // устанавливаем адаптер
        carList.setAdapter(carAdapter);

        // обработка установки и снятия отметки в списке
        carList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                String user = adapter.getItem(position);
                if(carList.isItemChecked(position))
                    selectedCars.add(user);
                else
                    selectedCars.remove(user);
            }
        });
    }

    public void add(View view){

        EditText carName = findViewById(R.id.carName);
        String car = carName.getText().toString();
        if(!car.isEmpty()){
            adapter.add(car);
            carName.setText("");
            adapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selectedCars.size();i++){
            adapter.remove(selectedCars.get(i));
        }
        // снимаем все ранее установленные отметки
        carList.clearChoices();
        // очищаем массив выбраных объектов
        selectedCars.clear();

        adapter.notifyDataSetChanged();
    }
    private void setInitialData() {
        cars.add(new Car ("Toyota Mark II ", "четырёхдверный среднеразмерный седан, выпускавшийся компанией Toyota с 1968 по 2004 годы.", R.drawable.mark2));
        cars.add(new Car ("Nissan Silvia S15", "спортивное купе, выпускавшееся японским автопроизводителем Nissan с 1965 по 2002 годы. ", R.drawable.silvias15));
        cars.add(new Car ("Nissan Skyline R34", "10-е поколение Nissan Skyline было представлено в мае 1998 в кузовах R34 с большим акцентом на спортивность и соответствие новым экологическим нормам", R.drawable.skyliner34));
        cars.add(new Car ("Toyota Supra", "серийный спортивный автомобиль, выпускающийся компанией Toyota с 1978 года", R.drawable.supra));
    }
}