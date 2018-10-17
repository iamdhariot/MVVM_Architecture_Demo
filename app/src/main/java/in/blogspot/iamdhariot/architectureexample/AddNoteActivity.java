package in.blogspot.iamdhariot.architectureexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE=
            "in.blogspot.iamdhariot.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION=
            "in.blogspot.iamdhariot.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY=
            "in.blogspot.iamdhariot.architectureexample.EXTRA_PRIORITY";

    private EditText editTextTitle,editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }
    private void saveNote(){
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        int priority= numberPickerPriority.getValue();
        if(title.isEmpty()||description.isEmpty()){
            Toast.makeText(this,"Please insert a title and/or description.",Toast.LENGTH_SHORT).show();
            return;

        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);
     //   startActivity(data);
        setResult(RESULT_OK,data);
        finish();


    }

}