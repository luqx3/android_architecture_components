package com.example.zzb.aac;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.DaggerFragmentComponet;
import com.example.zzb.aac.dragger.FragmentComponet;
import com.example.zzb.aac.dragger.FragmentModule;
import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPRepository;
import com.example.zzb.aac.viewmodle.IPViewModle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentComponet=DaggerFragmentComponet.builder()
                .activityModule(getActivityModule())
                .fragmentModule(new FragmentModule())
                .build();

//        getAppComponent().inject(this);

        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            IPFragment fragment = new IPFragment(fragmentComponet);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();
        }
        initializeInjector();
    }
    private void initializeInjector() {
//        this.fragmentComponet = DaggerFragmentComponet.builder()
//                .appComponent(getAppComponent())
//                .activityModule(getActivityModule())
//                .build();
    }





//    EditText et;
//    Button btn1;
//    TextView tv;
//    IPRepository ipRepository;
//    IPViewModle viewModel;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btn1=(Button)findViewById(R.id.search);
//        et=(EditText)findViewById(R.id.ed1) ;
//        tv=(TextView)findViewById(R.id.tv);
//
//
//        viewModel = ViewModelProviders.of(this).get(IPViewModle.class);
//        subscribeUi(viewModel);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewModel.searchbyIP(et.getText().toString());
//            }
//        });
//    }
//
//    @Override
//    public LifecycleRegistry getLifecycle() {
//        return super.getLifecycle();
//    }
//
//    private void subscribeUi(IPViewModle viewModel){
//        viewModel.getip().observe(this, new Observer<IP>() {
//            @Override
//            public void onChanged(@Nullable IP ip) {
//                tv.setText(ip.getCountry()+ip.getCity()+ip.getProvincial());
//            }
//        });
//    }
}
