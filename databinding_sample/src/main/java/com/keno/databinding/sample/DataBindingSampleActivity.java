package com.keno.databinding.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.keno.databinding.sample.databinding.ActivityDataBindingSampleBinding;
import com.keno.databinding.sample.pojo.LoginModel;

/**
* Description: 数据绑定
* Author: keno
* CreateDate: 2020/4/5 13:48
*/

public class DataBindingSampleActivity extends AppCompatActivity {

    private ActivityDataBindingSampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_sample);
        LoginModel loginModel = new LoginModel("account1", "password1");
        binding.setLoginModel(loginModel);

        //绑定事件持有对象
        binding.setEventPresent(new EventPresent());


    }

    /**
     * Description: 当前页事件持有类
     * Author: keno
     * CreateDate: 2020/3/5 21:18
     */
    public class EventPresent {
        public void startSingleBindingActivity() {
            startActivity(new Intent(DataBindingSampleActivity.this, SingleBindingActivity.class));
        }

        public void startEventBindingActivity() {
            startActivity(new Intent(DataBindingSampleActivity.this, EventBindingActivity.class));
        }

        public void startBindingAdapterActivity() {
            startActivity(new Intent(DataBindingSampleActivity.this, BindingAdapterActivity.class));
        }


        public void startBindingRecyclerViewActivity() {
            startActivity(new Intent(DataBindingSampleActivity.this, BindRecyclerviewActivity.class));
        }

        public void startSavedStateActivity() {
            startActivity(new Intent(DataBindingSampleActivity.this, ViewModelSavedStateActivity.class));
        }
    }
}
