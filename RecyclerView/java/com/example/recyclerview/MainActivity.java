package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Brother> brotherList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBrother();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //这是什么鬼东西
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        recyclerView.setLayoutManager(layoutManager);
        //
        BrotherAdapter adapter = new BrotherAdapter(brotherList);
        recyclerView.setAdapter(adapter);
    }

    private void initBrother() {
        for (int i = 0;i<2;i++) {
            Brother one = new Brother(getRandomLengthName("葛优躺"),R.drawable.drawable_1);
            brotherList.add(one);
            Brother two = new Brother(getRandomLengthName("我很温柔"),R.drawable.drawable_2);
            brotherList.add(two);
            Brother three = new Brother(getRandomLengthName("工作狂"),R.drawable.drawable_3);
            brotherList.add(three);
            Brother four = new Brother(getRandomLengthName("小祈祷"),R.drawable.drawable_4);
            brotherList.add(four);
            Brother five = new Brother(getRandomLengthName("认真学习中"),R.drawable.drawable_5);
            brotherList.add(five);
            Brother six = new Brother(getRandomLengthName("我爱英语"),R.drawable.drawable_6);
            brotherList.add(six);
            Brother seven = new Brother(getRandomLengthName("对你冷冰冰"),R.drawable.drawable_7);
            brotherList.add(seven);
            Brother eight = new Brother(getRandomLengthName("我很累了"),R.drawable.drawable_8);
            brotherList.add(eight);
            Brother nine = new Brother(getRandomLengthName("柔情似水"),R.drawable.drawable_9);
            brotherList.add(nine);
            Brother ten = new Brother(getRandomLengthName("叫我大猩猩"),R.drawable.drawable_10);
            brotherList.add(ten);
            Brother eleven = new Brother(getRandomLengthName("上线男主播"),R.drawable.drawable_11);
            brotherList.add(eleven);
            Brother twelve = new Brother(getRandomLengthName("正经看你"),R.drawable.drawable_12);
            brotherList.add(twelve);
            Brother thirteen = new Brother(getRandomLengthName("我又在祈祷"),R.drawable.drawable_13);
            brotherList.add(thirteen);
            Brother fourteen = new Brother(getRandomLengthName("我很开心"),R.drawable.drawable_14);
            brotherList.add(fourteen);
            Brother fifteen = new Brother(getRandomLengthName("我很自闭"),R.drawable.drawable_15);
            brotherList.add(fifteen);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<length;i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
