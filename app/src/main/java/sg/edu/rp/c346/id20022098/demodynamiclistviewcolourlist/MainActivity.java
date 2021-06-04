package sg.edu.rp.c346.id20022098.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etPosition;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos= Integer.parseInt(etPosition.getText().toString());
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();
                etElement.setText("");
                etPosition.setText("");
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos= Integer.parseInt(etPosition.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                etElement.setText("");
                etPosition.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputColour = etElement.getText().toString();
                int pos= Integer.parseInt(etPosition.getText().toString());
                alColours.set(pos, inputColour);
                aaColour.notifyDataSetChanged();
                etElement.setText("");
                etPosition.setText("");
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourPicked = lvColour.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, colourPicked, Toast.LENGTH_SHORT).show();
            }
        });

    }
}