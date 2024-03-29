package com.father_in_law.artisan_s_workplace.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.father_in_law.artisan_s_workplace.Activity.Search.WaitDialog;
import com.father_in_law.artisan_s_workplace.Adapter.JobAdapter;
import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.data.JobItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

public class Jang_jobActivity extends AppCompatActivity {
    ListView listView;
    JobAdapter adapter;
    ArrayList<JobItem> items = new ArrayList<>();
    private Button btn1;

    public WaitDialog dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jang_job);

        btn1 = findViewById(R.id.jang_contRegn1);
        btn1.setText("서울시 강남구");

        //다이얼로그 띄우기
        dlg = new WaitDialog(Jang_jobActivity.this);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dlg.show();

        initView();

        loadJobData();

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Jang_jobActivity.this, Jang_jobDetailActivity.class);
                intent.putExtra("jangjob", items.get(position));
                startActivity(intent);
            }
        });
    }

    private void initView() {

        findViewById(R.id.Jang_Job_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listView = findViewById(R.id.listview);
        adapter = new JobAdapter(items);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    private void loadJobData() {
        items.clear();
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    getJobDataUsingCSVParser();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    showErrorMessage("데이터 혹은 파싱 라이브러리에 문제가 있어요 ㅠㅠㅠ");
                    e.printStackTrace();
                }
                dlg.dismiss();
            }
        }.start();
    }

    //백그라운드 쓰레드에서 보내는 메시지
    private void showErrorMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Jang_jobActivity.this,
                        message, Toast.LENGTH_LONG).show();
            }
        });
    }

    //연번,구인등록일,모집기간,사업장명,모집직종,고용형태,임금형태,임금,근무지,입사형태,요구경력,요구학력,전공계열,요구자격증,사업장 주소,기업형태,담당기관,등록일,연락처
    private void getJobDataUsingCSVParser() throws IOException {
        File file = getFileFromRaw();
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);

        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        for (CsvRow row : csv.getRows()) {
            //System.out.println("First column of line: " + row.getField("name"));
            JobItem jobItem = new JobItem(
                    row.getField("연번"),
                    row.getField("구인등록일"),
                    row.getField("모집기간"),
                    row.getField("사업장명"),
                    row.getField("모집직종"),
                    row.getField("고용형태"),
                    row.getField("임금형태"),
                    row.getField("임금"),
                    row.getField("근무지"),
                    row.getField("입사형태"),
                    row.getField("요구경력"),
                    row.getField("요구학력"),
                    row.getField("전공계열"),
                    row.getField("요구자격증"),
                    row.getField("사업장 주소"),
                    row.getField("기업형태"),
                    row.getField("담당기관"),
                    row.getField("등록일"),
                    row.getField("연락처")
            );

            if (jobItem.getEstablishmentAddress().startsWith("서울특별시 강남구")) {
                items.add(jobItem);
            }
        }
    }

    private File getFileFromRaw() throws IOException{
       InputStream is = getResources().openRawResource(R.raw.data);

       File tempFile = File.createTempFile(String.valueOf(is.hashCode()), ".csv");
       tempFile.deleteOnExit();

       FileOutputStream os = new FileOutputStream(tempFile);

       int read;
       byte[] buffer = new byte[1024];

       while((read = is.read(buffer)) != -1) {
           os.write(buffer, 0, read);
       }

        return tempFile;
    }

}
